package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        try {
            return departmentRepository.findAll();
        } catch (IOException e) {
            // Handle exception
            return null;
        }
    }

    public Department getDepartmentById(Long id) {
        try {
            return departmentRepository.findById(id);
        } catch (IOException e) {
            // Handle exception
            return null;
        }
    }

    public Department createDepartment(Department department) {
        try {
            List<Department> departments = departmentRepository.findAll();
            departments.add(department);
            departmentRepository.save(departments);
            return department;
        } catch (IOException e) {
            // Handle exception
            return null;
        }
    }

    public Department updateDepartment(Long id, Department department) {
        try {
            List<Department> departments = departmentRepository.findAll();
            departments.removeIf(d -> d.getId().equals(id));
            departments.add(department);
            departmentRepository.save(departments);
            return department;
        } catch (IOException e) {
            // Handle exception
            return null;
        }
    }

    public boolean deleteDepartment(Long id) {
        try {
            List<Department> departments = departmentRepository.findAll();
            boolean removed = departments.removeIf(d -> d.getId().equals(id));
            departmentRepository.save(departments);
            return removed;
        } catch (IOException e) {
            // Handle exception
            return false;
        }
    }

    public Double getDepartmentRating(Long id) {
        try {
            Department department = departmentRepository.findById(id);
            return department != null ? department.getRating() : null;
        } catch (IOException e) {
            // Handle exception
            return null;
        }
    }

    public Department getDepartmentWithHighestRating() {
        try {
            List<Department> departments = departmentRepository.findAll();
            return departments.stream().max(Comparator.comparing(Department::getRating)).orElse(null);
        } catch (IOException e) {
            // Handle exception
            return null;
        }
    }
}

