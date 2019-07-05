package com.example.demo_resful.controller;

import com.example.demo_resful.entity.Employee;
import com.example.demo_resful.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> getAllEmployee() {
        return employeeService.findAll();
    }

    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") String employeeId) {
        Employee employee = employeeService.findById(employeeId);
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable("id") String id) {
        employeeService.delete(id);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return reponse;
    }

    @PutMapping("/{id}")
    public Map<String, Boolean> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employeeDetail) {
        employeeService.save(employeeDetail);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("updated", Boolean.TRUE);
        return reponse;
    }
}
