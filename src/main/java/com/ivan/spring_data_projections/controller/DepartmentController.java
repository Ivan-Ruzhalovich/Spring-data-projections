package com.ivan.spring_data_projections.controller;

import com.ivan.spring_data_projections.entity.Department;
import com.ivan.spring_data_projections.service.DepartmentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentController {
    private final DepartmentServiceImpl service;

    public DepartmentController(DepartmentServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/departments")
    public List<Department> getAllDeps(){
        return service.findAll();
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/departments/new")
    public ResponseEntity<String> addNewDep(@RequestBody Department dep){
        service.save(dep);
        return new ResponseEntity<>("Новый отдел зарегистрирован в системе!", HttpStatus.OK);
    }

    @PutMapping("/departments")
    public ResponseEntity<String> updateInfoAboutDep(@RequestBody Department dep){
        service.update(dep);
        return new ResponseEntity<>("Информация об отделе обновлена!", HttpStatus.OK);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<String> deleteDep(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>("Отдел был удален из системы!", HttpStatus.OK);
    }
}
