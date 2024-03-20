package System;

import java.util.ArrayList;
import java.util.List;

public class PayrollSystem {
    private List<Employee> employees;

    public PayrollSystem() {
        this.employees = new ArrayList<>();
    }

    // Method to add a new employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Method to update an existing employee's information
    public void updateEmployee(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == employee.getId()) {
                employees.set(i, employee);
                return;
            }
        }
        System.out.println("Employee with ID " + employee.getId() + " not found.");
    }

    // Method to remove an employee
    public void removeEmployee(int employeeId) {
        employees.removeIf(e -> e.getId() == employeeId);
    }

    // Method to calculate salary for all employees
    public void calculateSalaries() {
        for (Employee employee : employees) {
            System.out.println("Employee: " + employee.getName() + ", Salary: $" + employee.calculateSalary());
        }
    }

    // Method to generate pay stub for a specific employee
    public void generatePayStub(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                System.out.println("Pay Stub for Employee: " + employee.getName());
                System.out.println("Hours Worked: " + employee.getHoursWorked());
                System.out.println("Hourly Rate: $" + employee.getHourlyRate());
                System.out.println("Total Salary: $" + employee.calculateSalary());
                // Additional details like deductions, taxes, etc., can be added here
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }

    // Method to print all employees' details
    public void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
 // Method to retrieve all employees
    public List<Employee> getEmployees() {
        return employees;
    }
}

