package System;

public class Employee {
    private int id;
    private String name;
    private double hourlyRate;
    private double hoursWorked;
    private boolean isSalaried;

    // Constructors
    public Employee(int id, String name, double hourlyRate, double hoursWorked, boolean isSalaried) {
        this.id = id;
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.isSalaried = isSalaried;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public boolean isSalaried() {
        return isSalaried;
    }

    public void setSalaried(boolean salaried) {
        isSalaried = salaried;
    }

    // Method to calculate salary
    public double calculateSalary() {
        if (isSalaried) {
            // Implement logic for salaried employee
            return 0; // Placeholder, implement actual logic
        } else {
            // Hourly employee
            return hourlyRate * hoursWorked;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", hoursWorked=" + hoursWorked +
                ", isSalaried=" + isSalaried +
                '}';
    }
}

