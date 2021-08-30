package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Employee;
import java.util.List;

public interface IEmployeeRepositoryCustom {
    public Employee insert(String idExploitation, Employee employee);
    public List<Employee> findAll(String idExploitation);
    public boolean delete(String idExploitation, String idEmployee);
}
