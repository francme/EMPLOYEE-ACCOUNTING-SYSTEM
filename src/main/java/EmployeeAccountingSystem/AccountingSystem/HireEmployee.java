package EmployeeAccountingSystem.AccountingSystem;

import EmployeeAccountingSystem.Enum.Department;
import EmployeeAccountingSystem.Enum.Gender;
import EmployeeAccountingSystem.Enum.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static EmployeeAccountingSystem.ConsoleColors.Ansi.*;
import static EmployeeAccountingSystem.Input.dateInput;
import static EmployeeAccountingSystem.Input.digitInput;

public class HireEmployee {

    static EmployeeManagementSystem system = new EmployeeManagementSystem();


    // Метод для принятия нового сотрудника на работу
    public static void hireEmployee() throws IOException {

        ArrayList<Employee> employees = system.uploadEmployeeInformation();

        System.out.println(ANSI_PURPLE + "~ HIRE NEW EMPLOYEE ~" + ANSI_RESET);

        System.out.println("Input full name of employee: ");
        String fullName = new Scanner(System.in).nextLine().trim();

        System.out.println("Input Date of Birth <yyyy-mm-dd>: ");
        String dateOfBirth = String.valueOf(dateInput());

        Gender gender = null;
        while (gender == null) {
            System.out.println("Input gender: " +
                    "\n[1] - MALE\n[2] - FEMALE");
            switch (digitInput()) {
                case 1 -> gender = Gender.MALE;
                case 2 -> gender = Gender.FEMALE;
                default -> System.out.println(ANSI_RED + "Invalid input!" + ANSI_RESET);
            }
        }

        System.out.println("Input contact number (only digits): ");
        String contactNumber = new Scanner(System.in).nextLine().trim();

        Department department = null;
        while (department == null) {
            System.out.println("Input department:" +
                    "\n[1] - CEO\n[2] - ACCOUNTING\n[3] - PRODUCTION\n[4] - SALES");
            switch (digitInput()) {
                case 1 -> department = Department.CEO;
                case 2 -> department = Department.ACCOUNTING;
                case 3 -> department = Department.PRODUCTION;
                case 4 -> department = Department.SALES;
                default -> System.out.println(ANSI_RED + "Invalid input!" + ANSI_RESET);
            }
        }

        Position position = null;
        while (position == null) {
            System.out.println("Input position:" +
                    "\n[1] - CEO\n[2] - CHIEF_ACCOUNTANT\n[3] - ACCOUNTANT" +
                    "\n[4] - DEPARTMENT_MANAGER\n[5] - MANAGER" +
                    "\n[6] - MASTER\n[7] - OTHER_STAFF");
            switch (digitInput()) {
                case 1 -> position = Position.CEO;
                case 2 -> position = Position.CHIEF_ACCOUNTANT;
                case 3 -> position = Position.ACCOUNTANT;
                case 4 -> position = Position.DEPARTMENT_MANAGER;
                case 5 -> position = Position.MANAGER;
                case 6 -> position = Position.MASTER;
                case 7 -> position = Position.OTHER_STAFF;
                default -> System.out.println(ANSI_RED + "Invalid input!" + ANSI_RESET);
            }
        }

        System.out.println("Input supervisor: ");
        system.generateSupervisorsReport();
        String supervisor = new Scanner(System.in).nextLine().trim();

        System.out.println("Input Date of hire <yyyy-mm-dd>: ");
        String dateOfHire = String.valueOf(dateInput());

        System.out.println("Input salary: ");
        double salary = digitInput();

        employees.add(new Employee
                (fullName,
                        dateOfBirth,
                        gender,
                        contactNumber,
                        position,
                        department,
                        supervisor,
                        dateOfHire,
                        salary));

        System.out.println(WHITE_BRIGHT + "New employee is added." + ANSI_RESET);
        system.safeEmployeeInformationToFile();
    }
}
