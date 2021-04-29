package com.paule.kitprod_api.repository;

import com.paule.kitprod_api.model.Employee;
import java.util.List;

public interface IEmployeeRepositoryCustom {
    public Employee insert(long idExploitation, Employee employee);
    public List<Employee> findAll(long idExploitation);
}
