package com.ivan.spring_data_projections.repository;

import com.ivan.spring_data_projections.entity.Employee;
import com.ivan.spring_data_projections.projections.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<EmployeeProjection> findByDepartment_Id(Long id);
}
