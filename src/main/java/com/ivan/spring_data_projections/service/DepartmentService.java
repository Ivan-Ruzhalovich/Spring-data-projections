package com.ivan.spring_data_projections.service;

import com.ivan.spring_data_projections.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    Department findById(Long id);

    void save(Department dep);

    void update(Department dep);

    void delete(Long id);
}
