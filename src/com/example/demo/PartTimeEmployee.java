package com.example.demo;

public class PartTimeEmployee extends Employee {


    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, String department, int hoursWorked, double hourlyRate) {
        super(name, department);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double calculatePartTimeSalary() {
        return hoursWorked * hourlyRate;
    }
}
