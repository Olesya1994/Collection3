package com.example.collection;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MAX_SIZE = 10;
    private List<Employee> employees = new ArrayList<>(MAX_SIZE);


    private Employee add(String firstName, String lastName) {
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

    private void delete(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        for (Employee empl:employees){
            if (empl.equals(employee)){
                employees.remove(empl);
                                return ;
            }
        }
    }

    private Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        for (Employee empl:employees){
            if (empl.equals(employee)){
                return empl;
            }
        }
        throw new EmployeeNotFoundException();
    }

}
