package com.example.profile.service;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public interface MyService {
    String getMessage();
}

@Service
@Profile("dev")  // Only active in "dev" profile
class DevService implements MyService {
    @Override
    public String getMessage() {
        return "Running in Development Mode";
    }
}

@Service
@Profile("prod") // Only active in "prod" profile
class ProdService implements MyService {
    @Override
    public String getMessage() {
        return "Running in Production Mode";
    }
}
