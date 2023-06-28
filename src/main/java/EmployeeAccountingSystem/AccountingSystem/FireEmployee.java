package EmployeeAccountingSystem.AccountingSystem;

import java.io.IOException;
import java.util.ArrayList;

import static EmployeeAccountingSystem.ConsoleColors.Ansi.*;
import static EmployeeAccountingSystem.AccountingSystem.Input.Input.inputValue;

public class FireEmployee {
    static EmployeeManagementSystem system = new EmployeeManagementSystem();

    // Метод для увольнения сотрудника
    public static void fireEmployee() throws IOException {

        ArrayList<Employee> employees = system.uploadEmployeeInformation();

        System.out.println(ANSI_PURPLE + "~ FIRE A EMPLOYEE ~" + ANSI_RESET);
        System.out.println("Input full name of employee: ");
        String input = inputValue();

//        for (Employee employee : employees) {
//            if (employee.getFullName().equalsIgnoreCase(input)) {
//                employees.remove(employee);
//            }
//        }
        for (Employee e : employees) {
            if(!e.getFullName().equals(input)) {
                System.out.println("This employee wasn't found!");
                fireEmployee();
            } else {
                employees.removeIf(employee -> employee.getFullName().equalsIgnoreCase(input));
                System.out.println(WHITE_BRIGHT + "Employee " + input + " is fired." + ANSI_RESET);
                system.safeEmployeeInformationToFile();
            }
        }

    }
}
