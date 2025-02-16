package com.ivan.spring_data_projections.repository;

import com.ivan.spring_data_projections.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
