package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.tags.Tag;

@org.springframework.web.bind.annotation.RestController
@Tag(name = "Rest Controller", description = "This is a REST controller for handling API requests")
public class RestController {
	
	@GetMapping("/api/v1")
	public String page() {
		return "This is a REST controller for handling API requests";
	}

}
