package com.example.profile.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.profile.service.MyService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final MyService myService;

    public ProfileController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping
    public String getProfileMessage() {
        return myService.getMessage();
    }
}
