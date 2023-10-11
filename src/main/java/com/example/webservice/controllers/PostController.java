package com.example.webservice.controllers;

import com.example.webservice.exceptions.UserNotFoundException;
import com.example.webservice.models.Post;
import com.example.webservice.models.User;
import com.example.webservice.services.PostService;
import com.example.webservice.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        Optional<User> user = this.userService.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }

        return user.get().getPosts();
    }
}

