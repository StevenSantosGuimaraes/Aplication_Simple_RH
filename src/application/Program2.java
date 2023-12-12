package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program2 {

    public static void main(String[] args) {
        
        limparTerminal();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> listEmployee = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEmployee #" + (i + 1) + " data:");
            System.out.print("Outsourced (y/n)? ");
            char isOutsourced = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.next();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            if (isOutsourced == 'y' || isOutsourced == 'Y') {
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();
                Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                listEmployee.add(emp);
            } else {
                Employee emp = new Employee(name, hours, valuePerHour);
                listEmployee.add(emp);
            }
        }

        System.out.println("\nPAYMENTS:");

        for (Employee emp : listEmployee) {
            System.out.println(emp.getName() + " - $" + String.format("%.2f", emp.payment()));
        }

        System.out.println("\n");

        sc.close();

    }
    
    public static void limparTerminal() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
