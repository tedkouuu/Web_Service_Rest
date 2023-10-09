package com.example.webservice.versioning;

public class PersonV2 {

    private Name name;

    public PersonV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public PersonV2 setName(Name name) {
        this.name = name;
        return this;
    }
}
