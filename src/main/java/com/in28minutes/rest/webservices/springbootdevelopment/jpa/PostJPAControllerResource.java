package com.in28minutes.rest.webservices.springbootdevelopment.jpa;

import com.in28minutes.rest.webservices.springbootdevelopment.Posts.Post;
import com.in28minutes.rest.webservices.springbootdevelopment.Users.User;
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

@RestController
public class PostJPAControllerResource {

    //my repo dependency for post

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    //GET -> return post for a particular user

    @GetMapping(path="/jpa/users/{id}/posts")
    public List<Post> retrievePostByUserId(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id = "+id);
        }
        return user.get().getPosts();
    }

    @GetMapping(path="/jpa/posts")
    public List<Post> retrieveAllPost() {
        return postRepository.findAll();
    }
}
