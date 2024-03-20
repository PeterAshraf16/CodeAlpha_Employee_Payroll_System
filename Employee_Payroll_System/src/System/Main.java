package System;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        PayrollGUI gui = new PayrollGUI(payrollSystem);
        gui.setVisible(true);
    }
}
