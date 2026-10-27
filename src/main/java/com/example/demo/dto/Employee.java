package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Employee {
	@Min(value = 1, message = "Id should be greater than or equal to 1")
	private int id;
	@NotBlank(message = "Name should not be blank")
	private String name;
	@NotNull(message = "Phone number should not be null")
	private long phno;
	@Email(message = "Email should be valid")
	private String email;
	

}
