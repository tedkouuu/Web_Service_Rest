package com.example.webservice.versioning;

public class PersonV1 {

    private String name;

    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public PersonV1 setName(String name) {
        this.name = name;
        return this;
    }
}
