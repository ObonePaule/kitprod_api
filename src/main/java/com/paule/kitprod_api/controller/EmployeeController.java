package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.Charge;
import com.paule.kitprod_api.model.Employee;
import com.paule.kitprod_api.model.SequenceGeneratorService;
import com.paule.kitprod_api.repository.EmployeeRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired public EmployeeRepositoryCustomImpl employeeRepositoryCustomImpl;

    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployees(@RequestParam long idExploitation){
        return employeeRepositoryCustomImpl.findAll(idExploitation);
    }

    @PostMapping(value = "/employees")
    public String createEmployee(@RequestParam long idExploitation, @RequestBody Employee employee){
        employee.setId(sequenceGeneratorService.generateSequence(employee.SEQUENCE_NAME));
        Employee insertedEmployee = employeeRepositoryCustomImpl.insert(idExploitation, employee);
        return "Employee created: "+insertedEmployee.getName();
    }
}
