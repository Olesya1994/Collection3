package com.example.collection;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }


    public Employee add(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getName(), employee);
        return employee;
    }

    public Employee delete(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getName())) {
            employees.remove(employee.getName());
            return employee;
        }

        throw new EmployeeNotFoundException();

    }


    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getName())) {
            return employee;
        }

        throw new EmployeeNotFoundException();
    }


    public Collection<Employee> print() {
        return Collections.unmodifiableCollection(employees.values());
    }

}
    
