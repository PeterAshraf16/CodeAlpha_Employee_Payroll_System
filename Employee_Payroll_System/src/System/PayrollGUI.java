package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class PayrollGUI extends JFrame {
    private PayrollSystem payrollSystem;

    // GUI components
    private JTextField idField, nameField, rateField, hoursField;
    private JCheckBox salariedCheckBox;
    private JTextArea outputArea;

    public PayrollGUI(PayrollSystem payrollSystem) {
        super("Payroll System");
        this.payrollSystem = payrollSystem;

        // Initialize GUI components
        idField = new JTextField(10);
        nameField = new JTextField(20);
        rateField = new JTextField(10);
        hoursField = new JTextField(10);
        salariedCheckBox = new JCheckBox("Salaried");
        outputArea = new JTextArea(20, 40);

        // Set layout
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Hourly Rate:"));
        inputPanel.add(rateField);
        inputPanel.add(new JLabel("Hours Worked:"));
        inputPanel.add(hoursField);
        inputPanel.add(new JLabel("Salaried:"));
        inputPanel.add(salariedCheckBox);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addEmployee());
        buttonPanel.add(addButton);
        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> updateEmployee());
        buttonPanel.add(updateButton);
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(e -> removeEmployee());
        buttonPanel.add(removeButton);
        JButton calculateButton = new JButton("Calculate Salaries");
        calculateButton.addActionListener(e -> calculateSalaries());
        buttonPanel.add(calculateButton);
        JButton payStubButton = new JButton("Generate Pay Stub");
        payStubButton.addActionListener(e -> generatePayStub());
        buttonPanel.add(payStubButton);
        JButton printButton = new JButton("Print All Employee Names");
        printButton.addActionListener(e -> printAllEmployeeNames());
        buttonPanel.add(printButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        setContentPane(mainPanel);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800); // Set the size of the window to 800x600 pixels
        setLocationRelativeTo(null);
    }

    // Method to add an employee
    private void addEmployee() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            double rate = Double.parseDouble(rateField.getText());
            double hours = Double.parseDouble(hoursField.getText());
            boolean salaried = salariedCheckBox.isSelected();

            Employee employee = new Employee(id, name, rate, hours, salaried);
            payrollSystem.addEmployee(employee);
            outputArea.setText("Employee added: " + employee + "\n");
        } catch (NumberFormatException ex) {
            outputArea.setText("Invalid input! Please enter numeric values for ID, rate, and hours.\n");
        }
    }

    // Method to update an employee
    private void updateEmployee() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            double rate = Double.parseDouble(rateField.getText());
            double hours = Double.parseDouble(hoursField.getText());
            boolean salaried = salariedCheckBox.isSelected();

            Employee employee = new Employee(id, name, rate, hours, salaried);
            payrollSystem.updateEmployee(employee);
            outputArea.setText("Employee updated: " + employee + "\n");
        } catch (NumberFormatException ex) {
            outputArea.setText("Invalid input! Please enter numeric values for ID, rate, and hours.\n");
        }
    }

    // Method to remove an employee
    private void removeEmployee() {
        try {
            int id = Integer.parseInt(idField.getText());
            payrollSystem.removeEmployee(id);
            outputArea.setText("Employee removed with ID: " + id + "\n");
        } catch (NumberFormatException ex) {
            outputArea.setText("Invalid input! Please enter numeric value for ID.\n");
        }
    }

    // Method to calculate salaries for all employees
    private void calculateSalaries() {
        outputArea.setText(""); // Clear the output area
        StringBuilder output = new StringBuilder("Salaries calculated:\n");
        for (Employee employee : payrollSystem.getEmployees()) {
            output.append("Employee: ").append(employee.getName()).append(", Salary: $").append(employee.calculateSalary()).append("\n");
        }
        outputArea.append(output.toString());
    }

    // Method to generate pay stub for a specific employee
    private void generatePayStub() {
        try {
            int id = Integer.parseInt(idField.getText());
            StringBuilder output = new StringBuilder();
            for (Employee employee : payrollSystem.getEmployees()) {
                if (employee.getId() == id) {
                    output.append("Pay Stub for Employee: ").append(employee.getName()).append("\n");
                    output.append("Hours Worked: ").append(employee.getHoursWorked()).append("\n");
                    output.append("Hourly Rate: $").append(employee.getHourlyRate()).append("\n");
                    output.append("Total Salary: $").append(employee.calculateSalary()).append("\n");
                    // Additional details like deductions, taxes, etc., can be added here
                    break;
                }
            }
            outputArea.setText(output.toString());
        } catch (NumberFormatException ex) {
            outputArea.setText("Invalid input! Please enter numeric value for ID.\n");
        }
    }

    // Method to print all employee names
    private void printAllEmployeeNames() {
        outputArea.setText(""); // Clear the output area
        StringBuilder names = new StringBuilder("Employee Names:\n");
        for (Employee employee : payrollSystem.getEmployees()) {
            names.append(employee.getName()).append("\n");
        }
        outputArea.setText(names.toString());
    }

    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        PayrollGUI gui = new PayrollGUI(payrollSystem);
        gui.setVisible(true);
    }
}

