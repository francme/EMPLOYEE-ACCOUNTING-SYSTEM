package EmployeeAccountingSystem.AccountingSystem;

import EmployeeAccountingSystem.AccountingSystem.Enum.Department;
import EmployeeAccountingSystem.AccountingSystem.Enum.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static EmployeeAccountingSystem.ConsoleColors.Ansi.*;
import static EmployeeAccountingSystem.AccountingSystem.Input.Input.digitInput;

public class SearchEmployees {
    static EmployeeManagementSystem system = new EmployeeManagementSystem();

    // Метод для поиска сотрудников по различным параметрам
    public static List<Employee> searchEmployees() throws IOException {

        ArrayList<Employee> employees = system.uploadEmployeeInformation();

        System.out.println(ANSI_PURPLE + "\n~ SEARCH EMPLOYEE ~" + ANSI_RESET);
        List<Employee> searchResults = new ArrayList<>();
        boolean menu = true;
        while (menu) {
            System.out.println(WHITE_BRIGHT + "*CHOOSE ATTRIBUTE FOR SEARCH*" +
                    ANSI_RESET +
                    "\n[1] - fullName" +
                    "\n[2] - position" +
                    "\n[3] - department" +
                    "\n[4] - supervisor" +
                    WHITE_BRIGHT +
                    "\n[0] - Return" +
                    ANSI_RESET);

            switch (digitInput()) {
                case 1 -> {
                    System.out.println(WHITE_BRIGHT + "Input Full Name for search:" +
                            ANSI_RESET);
                    String value = new Scanner(System.in).nextLine().trim();
                    for (Employee employee : employees) {
                        if (employee.getFullName().equals(value)) {
                            searchResults.add(employee);
                            System.out.println(employee);
                        }
                    }
                }
                case 2 -> {
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
                    for (Employee employee : employees) {
                        if (employee.getPosition().equals(position)) {
                            searchResults.add(employee);
                            System.out.println(employee);
                        }
                    }
                }
                case 3 -> {
                    Department department = null;
                    while (department == null) {
                        System.out.println(WHITE_BRIGHT +
                                "Input Department for search:\n" +
                                ANSI_RESET +
                                "\n[1] - CEO\n[2] - ACCOUNTING\n[3] - PRODUCTION\n[4] - SALES");
                        switch (digitInput()) {
                            case 1 -> department = Department.CEO;
                            case 2 -> department = Department.ACCOUNTING;
                            case 3 -> department = Department.PRODUCTION;
                            case 4 -> department = Department.SALES;
                            default -> System.out.println(ANSI_RED + "Invalid input!" + ANSI_RESET);
                        }
                    }
                    for (Employee employee : employees) {
                        if (employee.getDepartment().equals(department)) {
                            searchResults.add(employee);
                            System.out.println(employee);
                        }
                    }
                }
                case 4 -> {
                    System.out.println(WHITE_BRIGHT + "Input full name of Supervisor for search:" +
                            ANSI_RESET);
                    system.generateSupervisorsReport();

                    String value = new Scanner(System.in).nextLine().trim();
                    for (Employee employee : employees) {
                        if (employee.getSupervisor().equals(value)) {
                            searchResults.add(employee);
                            System.out.println(employee);
                        }
                    }
                }
                case 0 -> menu = false;
                default -> System.out.println(ANSI_RED + "Invalid input!" + ANSI_RESET);
            }
        }
        return searchResults;
    }

}
