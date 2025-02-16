package com.ivan.spring_data_projections.service;

import com.ivan.spring_data_projections.entity.Employee;
import com.ivan.spring_data_projections.projections.EmployeeProjection;

import java.util.List;

public interface EmployeeService {
    List<EmployeeProjection> getInfoByDepartment(Long id);

    List<Employee> findAll();

    Employee findById(Long id);

    void save(Employee emp);

    void update(Employee emp);

    void delete(Long id);
}
