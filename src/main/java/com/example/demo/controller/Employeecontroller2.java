package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v2")
@Tag(name = "EmployeeController-NEW", description = "API for managing employees2")
public class Employeecontroller2 {
	
	List<String> employeess = new ArrayList<>();
	@PostMapping("/addEmployee")
	
   @ApiResponse(responseCode = "200", description = "Successfully added employee",
   		 content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/text"))
	public String addEmployee2(String emp) {
		employeess.add(emp);
		return "Employee added successfully";
	}
	@GetMapping("/getEmployees")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
	        @ApiResponse(responseCode = "401",description = "You are not authorized to view the resource"),
	        @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
	})
	public List<String> getEmployees2() {
		return employeess;
	}

}
