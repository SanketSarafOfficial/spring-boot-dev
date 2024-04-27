package com.in28minutes.rest.webservices.springbootdevelopment;

import org.springframework.web.bind.annotation.*;

// Here we will make a REST API Which will return Hello world in a specific url
@RestController
public class HelloWorldController {

//    @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
    //controller 1
    @GetMapping(path = "/hello-world")
    public static String helloWorld(){
        return "Hello World";
    }

    //controller 2
    @GetMapping(path = "/hello-world-bean")
    public static HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World Bean it is !!!");
    }

    //controller 3
    @GetMapping(path = "/hello-world/controller/{name}")
    public static HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format(
                "hello World , name = %s", name
        ));
    }


}


// we have various type of HTTP Mappings::
//@GetMapping , @PostMapping , @PutMapping , @DeleteMapping , @PatchMapping
