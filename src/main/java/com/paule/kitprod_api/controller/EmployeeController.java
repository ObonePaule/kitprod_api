package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.repository.EmployeeRepository;
import com.paule.kitprod_api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    public EmployeeRepository employeeRepository;

    @GetMapping(value = "/all-employee")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping(value = "/create-employee")
    public String createEmployee(@RequestBody Employee employee){
        Employee insertedEmployee = employeeRepository.insert(employee);
        return "Employee created: "+insertedEmployee.getName();
    }
}
