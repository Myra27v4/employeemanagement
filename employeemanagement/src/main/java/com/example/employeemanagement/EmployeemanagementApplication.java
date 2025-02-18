package com.example.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EmployeemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementApplication.class, args);
	}
}

/* http://localhost:8080/employees
http://localhost:8080/departments
http://localhost:8080/departments/{id}/ratings
http://localhost:8080/swagger-ui.html */