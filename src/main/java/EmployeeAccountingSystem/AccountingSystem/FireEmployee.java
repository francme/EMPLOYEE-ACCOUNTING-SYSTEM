package EmployeeAccountingSystem.AccountingSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static EmployeeAccountingSystem.ConsoleColors.Ansi.*;

public class FireEmployee {
    static EmployeeManagementSystem system = new EmployeeManagementSystem();

    // Метод для увольнения сотрудника
    public static void fireEmployee() throws IOException {

        ArrayList<Employee> employees = system.uploadEmployeeInformation();

        System.out.println(ANSI_PURPLE + "~ FIRE A EMPLOYEE ~" + ANSI_RESET);
        System.out.println("Input full name of employee: ");
        String input = new Scanner(System.in).nextLine().trim();

//        for (Employee employee : employees) {
//            if (employee.getFullName().equalsIgnoreCase(input)) {
//                employees.remove(employee);
//            }
//        }
        employees.removeIf(employee -> employee.getFullName().equalsIgnoreCase(input));

        System.out.println(WHITE_BRIGHT + "Employee " + input + " is fired." + ANSI_RESET);
        system.safeEmployeeInformationToFile();
    }
}
