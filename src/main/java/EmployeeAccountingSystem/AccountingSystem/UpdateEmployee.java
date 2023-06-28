package EmployeeAccountingSystem.AccountingSystem;

import EmployeeAccountingSystem.AccountingSystem.Enum.Department;
import EmployeeAccountingSystem.AccountingSystem.Enum.Gender;
import EmployeeAccountingSystem.AccountingSystem.Enum.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static EmployeeAccountingSystem.ConsoleColors.Ansi.*;
import static EmployeeAccountingSystem.AccountingSystem.Input.Input.*;

public class UpdateEmployee {
    static EmployeeManagementSystem system = new EmployeeManagementSystem();

    // Метод для изменения информации о сотруднике
    public static void updateEmployee() throws IOException {

        ArrayList<Employee> employees = system.uploadEmployeeInformation();

        System.out.println(ANSI_PURPLE + "~ UPDATE A EMPLOYEE ~" + ANSI_RESET);
        system.infoAboutEmployees();

        System.out.println("Input number of employee: ");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("[0-9]+")) {
            System.out.println("You're input not a digit." +
                    "\nInput some digit as your choose from menu:");
            scanner.next();
        }
        int input = scanner.nextInt();

        boolean menu = true;
        while (menu) {
            System.out.println(WHITE_BRIGHT + "*CHOOSE ATTRIBUTE FOR CHANGE*" +
                    ANSI_RESET +
                    "\n[1] - fullName" +
                    "\n[2] - dateOfBirth" +
                    "\n[3] - gender" +
                    "\n[4] - contactNumber" +
                    "\n[5] - department" +
                    "\n[6] - position" +
                    "\n[7] - supervisor" +
                    "\n[8] - hireDate" +
                    "\n[9] - salary" +
                    WHITE_BRIGHT +
                    "\n[0] - Return" +
                    ANSI_RESET);

            switch (digitInput()) {
                case 1:
                    System.out.println("Input new full name: ");
                    employees.get(input - 1).setFullName(inputValue());
                    break;
                case 2:
                    System.out.println("Input format <yyyy-mm-dd>!");
                    employees.get(input - 1).setDateOfBirth(dateInput());
                    break;
                case 3:
                    System.out.println("Input format <MALE> or <FEMALE>!");
                    employees.get(input - 1).setGender(Gender.valueOf(inputValue()));
                    break;
                case 4:
                    System.out.println("Input new contact number: ");
                    employees.get(input - 1).setContactNumber(inputValue());
                    break;
                case 5:
                    System.out.println("Input format <CEO>, " +
                            "\n<ACCOUNTING>, <PRODUCTION> or <SALES>!");
                    employees.get(input - 1).setDepartment(Department.valueOf(inputValue()));
                    break;
                case 6:
                    System.out.println("Input format <CEO>, <CHIEF_ACCOUNTANT>, " +
                            "\n<ACCOUNTANT>, <DEPARTMENT_MANAGER>, " +
                            "\n<MANAGER>, <MASTER> or <OTHER_STAFF>!");
                    employees.get(input - 1).setPosition(Position.valueOf(inputValue()));
                    break;
                case 7:
                    system.generateSupervisorsReport();
                    System.out.println("Input new Supervisor: ");
                    employees.get(input - 1).setSupervisor(inputValue());
                    break;
                case 8:
                    System.out.println("Input format <yyyy-mm-dd>!");
                    employees.get(input - 1).setHireDate(dateInput());
                    break;
                case 9:
                    System.out.println("Input new salary: ");
                    employees.get(input - 1).setSalary(Double.valueOf(inputValue()));
                    break;
                case 0:
                    menu = false;
                    break;
                default:
                    System.out.println("Неверный атрибут!");
                    break;
            }

            System.out.println(WHITE_BRIGHT + "Employee is changed." + ANSI_RESET);
            system.safeEmployeeInformationToFile();
        }
    }

}
