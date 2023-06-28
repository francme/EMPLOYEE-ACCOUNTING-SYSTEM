package EmployeeAccountingSystem.AccountingSystem;

import EmployeeAccountingSystem.AccountingSystem.Enum.Department;
import EmployeeAccountingSystem.AccountingSystem.Enum.Gender;
import EmployeeAccountingSystem.AccountingSystem.Enum.Position;

import java.io.IOException;
import java.util.ArrayList;

import static EmployeeAccountingSystem.ConsoleColors.Ansi.*;
import static EmployeeAccountingSystem.AccountingSystem.Input.Input.*;

public class HireEmployee {

    static EmployeeManagementSystem system = new EmployeeManagementSystem();


    // Метод для принятия нового сотрудника на работу
    public static void hireEmployee() throws IOException {

        ArrayList<Employee> employees = system.uploadEmployeeInformation();

        System.out.println(ANSI_PURPLE + "~ HIRE NEW EMPLOYEE ~" + ANSI_RESET);

        System.out.println("Input full name of employee: ");
        String fullName = inputValue();

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
        String contactNumber = inputValue();

        Department department = null;

        Position position = null;
        String supervisor = null;
        while (position == null) {
            System.out.println("Input position:" +
                    "\n[1] - CEO\n[2] - CHIEF_ACCOUNTANT\n[3] - ACCOUNTANT" +
                    "\n[4] - DEPARTMENT_MANAGER\n[5] - MANAGER" +
                    "\n[6] - MASTER\n[7] - OTHER_STAFF");
            switch (digitInput()) {
                case 1 -> {
                    position = Position.CEO;
                    department = Department.CEO;
                    supervisor = "not";
                }
                case 2 -> {
                    position = Position.CHIEF_ACCOUNTANT;
                    department = Department.ACCOUNTING;
                    for (Employee employee : employees) {
                        if (employee.getPosition().equals(Position.CEO)) {
                            supervisor = employee.getFullName();
                        }
                    }
                }
                case 3 -> {
                    position = Position.ACCOUNTANT;
                    department = Department.ACCOUNTING;
                    for (Employee employee : employees) {
                        if (employee.getPosition().equals(Position.CHIEF_ACCOUNTANT)) {
                            supervisor = employee.getFullName();
                        }
                    }
                }
                case 4 -> {
                    position = Position.DEPARTMENT_MANAGER;
                    department = Department.CEO;
                    for (Employee employee : employees) {
                        if (employee.getPosition().equals(Position.CEO)) {
                            supervisor = employee.getFullName();
                        }
                    }
                }
                case 5 -> {
                    position = Position.MANAGER;
                    department = Department.SALES;
                    for (Employee employee : employees) {
                        if (employee.getDepartment().equals(Department.SALES) &&
                                employee.getPosition().equals(Position.DEPARTMENT_MANAGER)) {
                            supervisor = employee.getFullName();
                        }
                    }
                }
                case 6 -> {
                    position = Position.MASTER;
                    department = Department.PRODUCTION;
                    for (Employee employee : employees) {
                        if (employee.getDepartment().equals(Department.PRODUCTION) &&
                                employee.getPosition().equals(Position.DEPARTMENT_MANAGER)) {
                            supervisor = employee.getFullName();
                        }
                    }
                }
                case 7 -> {
                    position = Position.OTHER_STAFF;
                    department = Department.CEO;
                    for (Employee employee : employees) {
                        if (employee.getPosition().equals(Position.CEO)) {
                            supervisor = employee.getFullName();
                        }
                    }
                }
                default -> System.out.println(ANSI_RED + "Invalid input!" + ANSI_RESET);
            }
        }

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
