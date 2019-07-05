package com.example.demo_resful.service.impl;

import com.example.demo_resful.entity.Employee;
import com.example.demo_resful.repository.EmployeeRepository;
import com.example.demo_resful.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employeeDetail) {
        Employee employee=findById(employeeDetail.getId());
        employee.setFirstName(employeeDetail.getFirstName());
        employee.setLastName(employeeDetail.getLastName());
        employee.setEmail(employeeDetail.getEmail());
        employeeRepository.save(employee);
    }

    @Override
    public void delete(String id) {
        employeeRepository.delete(employeeRepository.findById(id).orElse(null));
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
