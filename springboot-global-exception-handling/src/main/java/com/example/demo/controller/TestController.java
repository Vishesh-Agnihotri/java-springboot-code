package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CustomException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TestController {

	@GetMapping("/exception")
	public String customException() throws CustomException {
		throw new CustomException("Exception occured");
	}
	
}
