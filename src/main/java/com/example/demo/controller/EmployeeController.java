package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.Employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@RestController
@RestControllerAdvice
@RequestMapping("/api/v1")
@Tag(name = "EmployeeController", description = "API for managing employees")
public class EmployeeController {

	List<Employee> employees = new ArrayList<>();
	
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return employees;
	}
	
	
	@PostMapping("/addEmployee")
	@Operation(summary = "Add a new employee with operation", description = "This API endpoint allows you to add a new employee to the list.")
	@Tag(name = "addEmployee method", description = "API for adding a new employee")
	@ApiResponse(responseCode = "200", description = "Successfully added employee1",
			content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json"))
	public String addEmployee(@Valid @RequestBody Employee emp) {
		employees.add(emp);
		return "This is a REST controller for handling API requests";
	}
	
	@Tag(name = "updateEmployee method", description = "API for updating an existing employee")
	@PutMapping("/updateEmployee")
	public Employee updateemployee(@RequestBody Employee emp) {
		for(int i=0;i<employees.size();i++) {
			if(employees.get(i).getId()==emp.getId()) {
				employees.set(i, emp);
				return emp;
	
			}
		}
		throw new RuntimeException("Employee not found with id: " + emp.getId());
		
	}
	
		@DeleteMapping("/deleteEmployee")
		public String deleteEmployee(@RequestBody Employee emp) {
			for(int i=0;i<employees.size();i++) {
				if(employees.get(i).getId()==emp.getId()) {
					employees.remove(i);
					return "Employee deleted with id: " + emp.getId();
				}
			}
			throw new RuntimeException("Employee to delectenot found with id: " + emp.getId());
			
			
		
	}
	    @Tag(name = "patchEmployee method", description = "API for partially updating an existing employee")
		@PatchMapping("/patchEmployee")
		public Employee patchproduct(@RequestBody Employee emp) {
			for(int i=0;i<employees.size();i++) {
				if(employees.get(i).getId()==emp.getId()) {
					Employee existingEmp = employees.get(i);
					if(emp.getName()!=null) {
						existingEmp.setName(emp.getName());
					}
					if(emp.getEmail()!=null) {
						existingEmp.setEmail(emp.getEmail());
					}
					if(emp.getPhno()!=0) {
						existingEmp.setPhno(emp.getPhno());
					}
					return existingEmp;
		
				}
			}
			throw new RuntimeException("Employee not found  to do update with id: " + emp.getId());
		}  
	   	@ExceptionHandler(Exception.class)
	public String handleexception(Exception e) {
		return e.getMessage();
	}
	
}
