package com.example.collection.service;

import com.example.collection.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee max(String department) {
        return employeeService.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    public Employee min(String department) {
        return employeeService.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    public Collection<Employee> allOfDept(String department) {
        return employeeService.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    public Map<String, List<Employee>> all() {
        return employeeService.getEmployees()
                .stream()
                .collect(groupingBy(Employee::getDepartment));
    }
}
