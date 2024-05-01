package com.in28minutes.rest.webservices.springbootdevelopment;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

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

    //Using MessageSource for Internationalization


    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //Understanding Internationalization
    //Controller 4 - GET Method
    @GetMapping(path = "/hello-world/internationalization")
    public String helloWorldInternationalization(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"default Message",locale);
    }
}


// we have various type of HTTP Mappings::
//@GetMapping , @PostMapping , @PutMapping , @DeleteMapping , @PatchMapping
