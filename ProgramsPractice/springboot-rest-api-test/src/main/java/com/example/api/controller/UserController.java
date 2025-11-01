package com.example.api.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.User;
import com.example.api.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService UserService;

    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @GetMapping("/todos")
    public List<User> getTodos() {
        return UserService.fetchTodos();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id ) {
        return UserService.fetchTodosUser(id);
    }
}
