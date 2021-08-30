package com.paule.kitprod_api.controller;

import com.paule.kitprod_api.model.Employee;
import com.paule.kitprod_api.model.SequenceGeneratorService;
import com.paule.kitprod_api.repository.EmployeeRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EmployeeController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired public EmployeeRepositoryCustomImpl employeeRepositoryCustomImpl;

    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployees(@RequestParam String idExploitation){

        return employeeRepositoryCustomImpl.findAll(idExploitation);
    }

    @PostMapping(value = "/employees")
    public Employee createEmployee(@RequestParam String idExploitation, @RequestBody Employee employee){
        employee.setId(UUID.randomUUID().toString());
        Employee insertedEmployee = employeeRepositoryCustomImpl.insert(idExploitation, employee);

        return insertedEmployee;
    }
    
    @DeleteMapping(value = "/employees")
    public Employee deleteEmployee(@RequestParam String idExploitation, @RequestParam String idEmployee){
        return employeeRepositoryCustomImpl.delete(idExploitation, idEmployee);
    }
}
