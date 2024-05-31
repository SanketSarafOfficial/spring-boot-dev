package com.in28minutes.rest.webservices.springbootdevelopment.jpa;

import com.in28minutes.rest.webservices.springbootdevelopment.Posts.Post;
import com.in28minutes.rest.webservices.springbootdevelopment.Users.User;
import com.in28minutes.rest.webservices.springbootdevelopment.Users.UserDaoService;
import com.in28minutes.rest.webservices.springbootdevelopment.Users.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


//Will be changing all service -> Repository

@RestController
public class UserJPAControllerResource {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

    public UserJPAControllerResource(UserRepository repository, PostRepository postRepository) {
        this.repository = repository;
        this.postRepository = postRepository;
    }

    //GET -> /users
    @GetMapping(path="/jpa/users")
    public List<User> retrieveAllUser(){
        return repository.findAll();
    }

    @GetMapping(path="/jpa/users/{id}")
    public EntityModel<User> retrieveUserInfoById(@PathVariable  Integer id){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("UserNotFoundException :: User Id is not found " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveUserInfoById(id));
        entityModel.add(link.withRel("all-details"));
        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path="/jpa/users/{id}")
    public void deleteUserById(@PathVariable  Integer id){
        repository.deleteById(id);
    }

    //for a specific userId , we want to create list of post
    @PostMapping(path="/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostByUserId(@PathVariable int id , @Valid @RequestBody Post posts){
         // fetch the user Id
        Optional<User> userInfo = repository.findById(id);

        //using the user info , I will create one post

        if(userInfo.isEmpty()){
            throw new UserNotFoundException("id = "+id);
        }

        // saving the user ID info for a particular post
        posts.setUser(userInfo.get());

        // post creation for that user Id
        Post savedPostFromAUser = postRepository.save(posts);

        // using responseEntity to get correct response at postman
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPostFromAUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
