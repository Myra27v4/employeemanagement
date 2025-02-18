package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class EmployeeRepository {

    private static final String EMPLOYEE_FILE = "employees.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Employee> findAll() throws IOException {
        return List.of(objectMapper.readValue(new File(EMPLOYEE_FILE), Employee[].class));
    }

    public Employee findById(Long id) throws IOException {
        return findAll().stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Employee> findByDepartmentId(Long departmentId) throws IOException {
        return findAll().stream().filter(employee -> employee.getDepartmentId().equals(departmentId)).toList();
    }

    public void save(List<Employee> employees) throws IOException {
        objectMapper.writeValue(new File(EMPLOYEE_FILE), employees);
    }
}

