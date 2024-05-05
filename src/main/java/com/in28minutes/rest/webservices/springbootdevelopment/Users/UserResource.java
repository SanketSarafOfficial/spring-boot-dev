package com.in28minutes.rest.webservices.springbootdevelopment.Users;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

// Now we will make API endpoint to retrieve All users Info
//Controller file
@RestController
public class UserResource {

//    @Autowired
    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }

    //GET -> /users
    @GetMapping(path="/users")
    public List<User> retrieveAllUser(){
        return service.findAll();
    }

    //This is using a path variable / Path params / path name
    //Using HATEOAS - EntityModel
    //HATEOAS - will show HAL responses with hyperlink to the resources being used
    @GetMapping(path="/users/{id}")
    public EntityModel<User> retrieveUserInfoById(@PathVariable  Integer id){
        User user = service.findOne(id);
        if(user == null){ // user == null means there is no record for a particular user
            throw new UserNotFoundException("UserNotFoundException :: User Id is not found " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user);

        //Next steps is to generate links for our EntityModel
        //we use WebMvcLinkBuilder for that.
        //We will link this RestController with some of its controller method (You can use any method)

        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveUserInfoById(id));

        //After link is created , add that to entity Model
        entityModel.add(link.withRel("all-details"));
        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = service.userSave(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();

        //Response Entity is used to get the correct HTTP response status as well as to pass our URI details into headers response
        // Here the response will be having the details of URI if we return this
        //All API urls details will be visible in the Headers of the Response Payload
    }

    @DeleteMapping(path="/users/{id}")
    public void deleteUserById(@PathVariable  Integer id){
        service.deleteById(id);
    }
}

// As we know that POST HTTP method requires a "request payload' , hence we use annotation @RequestBody in the parameter