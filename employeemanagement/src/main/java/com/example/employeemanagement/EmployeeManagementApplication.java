package com.example.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 // Enable Swagger for your Spring Boot application
public class EmployeeManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.example.employeemanagement.util.EmployeeManagementApplication.class, args);
    }
}