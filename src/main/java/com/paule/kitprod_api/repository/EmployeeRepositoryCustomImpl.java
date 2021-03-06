package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Employee;
import com.paule.kitprod_api.model.Exploitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryCustomImpl implements IEmployeeRepositoryCustom {

    @Autowired
    ExploitationRepository exploitationRepository;

    @Override
    public Employee insert(String idExploitation, Employee employee) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();
            existingExploitation.addEmployee(employee);
            exploitationRepository.save(existingExploitation);

            return employee;
        }
        return null;
    }

    @Override
    public List<Employee> findAll(String idExploitation) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();

            return existingExploitation.getEmployees();
        }
        return Collections.emptyList();
    }

    @Override
    public boolean delete(String idExploitation, String idEmployee) {
        boolean wasRemoved = false;
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();
            wasRemoved = existingExploitation.removeEmployee(idEmployee);
            exploitationRepository.save(existingExploitation);

            return wasRemoved;
        }

        return wasRemoved;
    }

    @Override
    public Employee update(String idExploitation, String idEmployee, Employee updatedEmployee) {
        Optional<Exploitation> exploitation = exploitationRepository.findById(idExploitation);

        if (exploitation.isPresent()) {
            Exploitation existingExploitation = exploitation.get();
            List<Employee> updatedEmployees = existingExploitation.getEmployees().stream().peek(employee -> {
                if (employee.getId().equals(idEmployee)) {
                    employee.setName(updatedEmployee.getName());
                    employee.setHourCost(updatedEmployee.getHourCost());
                    employee.setNumberOfHour(updatedEmployee.getNumberOfHour());
                    employee.setEmployeeType(updatedEmployee.getEmployeeType());

                    updatedEmployee.setId(employee.getId());
                }
            }).collect(Collectors.toList());

            existingExploitation.setEmployees(updatedEmployees);
            exploitationRepository.save(existingExploitation);

            return updatedEmployee;
        }
        return null;
    }
}
