package com.example.demo;

import com.example.demo.interfaces.*;

public class SalaryCalculator {
    
    private SalaryService salaryService;

    public SalaryCalculator(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    public double calculateSalary(String name) {
        return salaryService.calculateSalary(name);
    }
}
