package com.example.webservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*

 Versioning REST API - URI Versioning

 */

@RestController
public class VersioningUserController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Jameson");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        Name name = new Name("Teodor", "Tr");
        return new PersonV2(name);
    }

    /*

    Versioning REST API - Request Parameter

     */

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter() {
        return new PersonV1("Mari Charles");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        Name name = new Name("Bob", "Charlie");
        return new PersonV2(name);
    }

    /*

    (Custom) headers versioning

     */

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader() {
        return new PersonV1("Mari Charles");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader() {
        return new PersonV2(new Name("Mari", "Charles"));
    }

    /*

    Media type versioning (a.k.a "content negotiation" or "accept header")

     */

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader() {
        return new PersonV1("Mari Charles");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader() {
        return new PersonV2(new Name("Mari", "Charles"));
    }
}
