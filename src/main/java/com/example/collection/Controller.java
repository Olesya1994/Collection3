package com.example.collection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collection")
public class Controller {
    private final EmployeeService service;

    public Controller(EmployeeService service) {
        this.service = service;
    }
}
