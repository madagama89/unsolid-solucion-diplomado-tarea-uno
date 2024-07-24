package com.example.demo;

import com.example.demo.interfaces.*;
import java.util.Random;

public class SalaryServiceImpl implements SalaryService {
   
    private EmployeeRepository employeeRepository;
    private Random random;

    public SalaryServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.random = new Random();
    }

    @Override
    public double calculateSalary(String name) {
        Employee employee = ((EmployeeRepositoryImpl) employeeRepository).getEmployees().stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (employee != null) {
            // Generar un salario aleatorio entre 1000.0 y 5000.0
            return 1000.0 + (4000.0 * random.nextDouble());
        
        }

        return 0.0;
    }
}
