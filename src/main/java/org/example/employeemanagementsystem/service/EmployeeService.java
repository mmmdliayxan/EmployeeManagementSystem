package org.example.employeemanagementsystem.service;

import org.example.employeemanagementsystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getById(Long id);
    List<Employee> getAll();
    void add(Employee employee);
    void delete(Long id);
}
