package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.interfaces.*;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    
    private List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee(String name, String department) {
        employees.add(new Employee(name, department));
    }

    @Override
    public void removeEmployee(String name) {
        employees.removeIf(employee -> employee.getName().equals(name));
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
