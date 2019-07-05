package com.example.demo_resful.service;

import com.example.demo_resful.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    void update(Employee employee);

    void delete(String id);

    Employee findById(String id);
}
