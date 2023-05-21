package com.example.collection;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MAX_SIZE = 10;
    private final List<Employee> employees;

    public EmployeeService() {
        employees = new ArrayList<>(MAX_SIZE);
    }


    public Employee add(String firstName, String lastName) {
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee delete(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        for (Employee empl : employees) {
            if (empl.equals(employee)) {
                employees.remove(employee);
                return employee;
            }
        }

        throw new EmployeeNotFoundException();

    }


    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (Employee empl : employees) {
            if (empl.equals(employee)) {
                return empl;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> print() {
        return Collections.unmodifiableList(employees);
    }

}
    
