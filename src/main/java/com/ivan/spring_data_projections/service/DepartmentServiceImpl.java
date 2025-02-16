package com.ivan.spring_data_projections.service;

import com.ivan.spring_data_projections.entity.Department;
import com.ivan.spring_data_projections.repository.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Department> findAll() {
        return repository.findAll();
    }

    @Override
    public Department findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Такого отдела нет в системе!"));
    }

    @Override
    public void save(Department dep) {
        repository.save(dep);
    }

    @Override
    public void update(Department dep) {
        repository.save(dep);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
