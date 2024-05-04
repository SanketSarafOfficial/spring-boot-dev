package com.in28minutes.rest.webservices.springbootdevelopment.Versioning;

public class PersonV2 {
    public Name name;

    public PersonV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "name=" + name +
                '}';
    }
}
