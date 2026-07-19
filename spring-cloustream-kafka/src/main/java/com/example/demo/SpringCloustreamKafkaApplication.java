package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringCloustreamKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloustreamKafkaApplication.class, args);
	}

}
