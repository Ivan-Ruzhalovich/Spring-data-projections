package com.ivan.spring_data_projections.service;

import com.ivan.spring_data_projections.entity.Employee;
import com.ivan.spring_data_projections.projections.EmployeeProjection;
import com.ivan.spring_data_projections.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository){
        this.repository = repository;
    }

    @Override
    public List<EmployeeProjection> getInfoByDepartment(Long id) {
        return repository.findByDepartment_Id(id);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Работник не зарегистрирован в системе!"));
    }

    @Override
    public void save(Employee emp) {
        repository.save(emp);

    }

    @Override
    public void update(Employee emp) {
        repository.save(emp);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
