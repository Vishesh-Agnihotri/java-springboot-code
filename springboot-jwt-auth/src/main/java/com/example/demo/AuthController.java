package com.example.demo;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userService;

    public AuthController(AuthenticationManager authManager,
                          JwtUtil jwtUtil,
                          UserDetailsServiceImpl userService) {

        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        UserDetails user = userService.loadUserByUsername(username);

        return jwtUtil.generateToken(user.getUsername());
    }

    @GetMapping("/secure")
    public String secureApi() {
        return "You accessed a secure endpoint!";
    }
}
