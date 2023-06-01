package com.example.collection.controller;

import com.example.collection.Employee;
import com.example.collection.service.DepartmentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
        private final DepartmentService service;
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee max (@RequestParam String department){
        return service.max(department);
    }
    @GetMapping("/min-salary")
    public Employee min (@RequestParam String department){
        return service.max(department);
    }
    @GetMapping("/all")
    public Collection<Employee> allOfDept (@RequestParam String department){
        return service.allOfDept(department);
    }
    @GetMapping("/all")
    public Map<String, List<Employee>>  all (){
        return service.all();
    }
}
