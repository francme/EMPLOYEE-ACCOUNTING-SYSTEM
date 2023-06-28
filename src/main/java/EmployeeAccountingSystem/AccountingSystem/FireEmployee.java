package EmployeeAccountingSystem.AccountingSystem;

import java.io.IOException;
import java.util.ArrayList;

import static EmployeeAccountingSystem.AccountingSystem.Input.Input.digitInput;
import static EmployeeAccountingSystem.ConsoleColors.Ansi.ANSI_PURPLE;
import static EmployeeAccountingSystem.ConsoleColors.Ansi.ANSI_RESET;

public class FireEmployee {
    static EmployeeManagementSystem system = new EmployeeManagementSystem();

    // Метод для увольнения сотрудника
    public static void fireEmployee() throws IOException {

        ArrayList<Employee> employees = system.uploadEmployeeInformation();

        System.out.println(ANSI_PURPLE + "~ FIRE A EMPLOYEE ~" + ANSI_RESET);
        System.out.println("Input number of employee: ");
        int index = (digitInput() - 1);

        try {
            employees.remove(employees.get(index));
            System.out.println("is fired");
            system.safeEmployeeInformationToFile();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("This employees number not found!");
        }


    }
}
