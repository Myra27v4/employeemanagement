package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Department department = departmentService.getDepartmentById(id);
        return department != null ? ResponseEntity.ok(department) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department) {
        Department createdDepartment = departmentService.createDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @Valid @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartment(id, department);
        return updatedDepartment != null ? ResponseEntity.ok(updatedDepartment) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        boolean isDeleted = departmentService.deleteDepartment(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/rating")
    public ResponseEntity<Double> getDepartmentRating(@PathVariable Long id) {
        Double rating = departmentService.getDepartmentRating(id);
        return rating != null ? ResponseEntity.ok(rating) : ResponseEntity.notFound().build();
    }

    @GetMapping("/highest-rating")
    public ResponseEntity<Department> getDepartmentWithHighestRating() {
        Department department = departmentService.getDepartmentWithHighestRating();
        return department != null ? ResponseEntity.ok(department) : ResponseEntity.notFound().build();
    }
}