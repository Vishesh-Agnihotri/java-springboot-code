package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)  // Load only HelloController for testing
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;  // Mocking HTTP requests

    @Test
    public void testSayHello() throws Exception {
        mockMvc.perform(get("/api/hello"))
               .andExpect(status().isOk())  // Check HTTP 200 status
               .andExpect(content().string("Hello, Spring Boot Testing!"));  // Validate response body
        // if you write some other string here it will give error
        
    }
}
