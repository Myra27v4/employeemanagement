package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.util.JsonDatastore;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() throws IOException {
        Map<String, Object> data = JsonDatastore.readData();
        List<Employee> employees = (List<Employee>) data.get("employees");
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) throws IOException {
        Map<String, Object> data = JsonDatastore.readData();
        List<Employee> employees = (List<Employee>) data.get("employees");
        Employee employee = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@Valid @RequestBody Employee employee) throws IOException {
        Map<String, Object> data = JsonDatastore.readData();
        List<Employee> employees = (List<Employee>) data.get("employees");
        employees.add(employee);
        JsonDatastore.writeData(data);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created");
    }

    // Implement PUT and DELETE endpoints similarly
}