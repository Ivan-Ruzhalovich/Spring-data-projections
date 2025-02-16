package com.ivan.spring_data_projections.controller;

import com.ivan.spring_data_projections.entity.Employee;
import com.ivan.spring_data_projections.projections.EmployeeProjection;
import com.ivan.spring_data_projections.service.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeServiceImpl service;

    public EmployeeController(EmployeeServiceImpl service){
        this.service = service;
    }

    @GetMapping("/employees/departments/{id}")
    public List<EmployeeProjection> getInfoByDepartment(@PathVariable Long id){
        return service.getInfoByDepartment(id);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmps(){
        return service.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable Long id){
        service.findById(id);
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/employees/new")
    public ResponseEntity<String> addNewEmp(@RequestBody Employee emp){
        service.save(emp);
        return new ResponseEntity<>("Новый работник зарегистрирован в системе!", HttpStatus.OK);
    }

    @PutMapping("/employees")
    public ResponseEntity<String> updateInfoAboutEmp(@RequestBody Employee emp){
        service.update(emp);
        return new ResponseEntity<>("Информация о работнике обновлена!", HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>("Работник исключен из системы!", HttpStatus.OK);
    }
}
