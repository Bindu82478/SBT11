package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.Employee;

import jakarta.validation.Valid;
@RestController
@RestControllerAdvice
public class EmployeeController {

	List<Employee> employees = new ArrayList<>();
	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return employees;
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@Valid @RequestBody Employee emp) {
		employees.add(emp);
		return "This is a REST controller for handling API requests";
	}
	@ExceptionHandler(Exception.class)
	public String handleexception(Exception e) {
		return e.getMessage();
	}
	
}
