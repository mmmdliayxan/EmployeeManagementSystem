package org.example.employeemanagementsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.employeemanagementsystem.entity.Employee;
import org.example.employeemanagementsystem.repository.EmployeeRepository;
import org.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
