package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Department;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class DepartmentRepository {

    private static final String DEPARTMENT_FILE = "departments.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Department> findAll() throws IOException {
        return List.of(objectMapper.readValue(new File(DEPARTMENT_FILE), Department[].class));
    }

    public Department findById(Long id) throws IOException {
        return findAll().stream().filter(department -> department.getId().equals(id)).findFirst().orElse(null);
    }

    public void save(List<Department> departments) throws IOException {
        objectMapper.writeValue(new File(DEPARTMENT_FILE), departments);
    }
}
