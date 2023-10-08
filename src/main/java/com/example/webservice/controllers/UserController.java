package com.example.webservice.controllers;

import com.example.webservice.models.User;
import com.example.webservice.services.UserDaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        return userDaoService.findById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userDaoService.save(user);
    }
}
