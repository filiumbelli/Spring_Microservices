package com.sofisticat.rest.webservices.controller;


import com.sofisticat.rest.webservices.entity.Post;
import com.sofisticat.rest.webservices.entity.User;
import com.sofisticat.rest.webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getUserPosts(@PathVariable long id) {
        return userService.getUserPosts(id);
    }

    @PostMapping("/{id}/posts")
    public void createPost(@PathVariable long id, @RequestBody Post post) {
        userService.createPost(post, id);
    }

    @GetMapping("/{id}/posts/{post_id}")
    public Post getUserPost(@PathVariable long id, @PathVariable long post_id) {
        return userService.getPost(id, post_id);
    }
}
