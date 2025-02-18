package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        try {
            return employeeRepository.findAll();
        } catch (IOException e) {
            // Handle exception
            return null;
        }
    }

    public Employee getEmployeeById(Long id) {
        try {
            return employeeRepository.findById(id);
        } catch (IOException e) {
            // Handle exception
            return null;
        }
    }

    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        try {
            return employeeRepository.findByDepartmentId(departmentId);
        } catch (IOException e) {
            // Handle exception
            return null;
        }
    }

    public Employee createEmployee(Employee employee) {
        try {
            List<Employee> employees = employeeRepository.findAll();
            employees.add(employee);
            employeeRepository.save(employees);
            return employee;
        } catch (IOException e) {
            // Handle exception
            return null;
        }
    }

    public Employee updateEmployee(Long id, Employee employee) {
        try {
            List<Employee> employees = employeeRepository.findAll();
            employees.removeIf(e -> e.getId().equals(id));
            employees.add(employee);
            employeeRepository.save(employees);
            return employee;
        } catch (IOException e) {
            // Handle exception
            return null;
        }
    }

    public boolean deleteEmployee(Long id) {
        try {
            List<Employee> employees = employeeRepository.findAll();
            boolean removed = employees.removeIf(e -> e.getId().equals(id));
            employeeRepository.save(employees);
            return removed;
        } catch (IOException e) {
            // Handle exception
            return false;
        }
    }
}

