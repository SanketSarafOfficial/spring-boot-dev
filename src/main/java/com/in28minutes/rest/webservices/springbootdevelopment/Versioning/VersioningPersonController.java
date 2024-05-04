package com.in28minutes.rest.webservices.springbootdevelopment.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    //versioning using URL
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Sanket Saraf");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Sanket","Saraf"));
    }

    //versioning using params
    @GetMapping(path="/person",params = "version=1")
    public PersonV1 getFirstVersionOfPersonWithRequestParameter(){
        return new PersonV1("Sanket Saraf");
    }
    @GetMapping(path="/person",params = "version=2")
    public PersonV2 getSecondVersionOfPersonWithRequestParameter(){
        return new PersonV2(new Name("Sanket","Saraf"));
    }

    //versioning using Custom headers
    @GetMapping(path="/person/headers", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonWithCustomHeader(){
        return new PersonV1("Sanket Saraf");
    }

    @GetMapping(path="/person/headers", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonWithCustomHeader(){
        return new PersonV2(new Name("Sanket","Saraf"));
    }

    //versioning using Media Type - Accept headers
    @GetMapping(path="/person/acceptHeader", produces = "application/personV1+json")
    public PersonV1 getFirstVersionOfPersonWithMediaTypeAcceptHeader(){
        return new PersonV1("Sanket Saraf");
    }

    @GetMapping(path="/person/acceptHeader", produces = "application/PersonV2+json")
    public PersonV2 getSecondVersionOfPersonWithMediaTypeAcceptHeader(){
        return new PersonV2(new Name("Sanket","Saraf"));
    }
}
