package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.util.JsonDatastore;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() throws IOException {
        Map<String, Object> data = JsonDatastore.readData();
        List<Department> departments = (List<Department>) data.get("departments");
        return ResponseEntity.ok(departments);
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(@Valid @RequestBody Department department) throws IOException {
        Map<String, Object> data = JsonDatastore.readData();
        List<Department> departments = (List<Department>) data.get("departments");
        departments.add(department);
        JsonDatastore.writeData(data);
        return ResponseEntity.status(HttpStatus.CREATED).body("Department created");
    }

    @GetMapping("/{id}/rating")
    public ResponseEntity<Double> getDepartmentRating(@PathVariable String id) throws IOException {
        Map<String, Object> data = JsonDatastore.readData();
        List<Department> departments = (List<Department>) data.get("departments");
        Department department = departments.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return ResponseEntity.ok(department.getRating());
    }

    // Implement other endpoints (PUT, DELETE, etc.)
}
