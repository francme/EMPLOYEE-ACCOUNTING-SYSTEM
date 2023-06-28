package EmployeeAccountingSystem.AccountingSystem;

import EmployeeAccountingSystem.Enum.Department;
import EmployeeAccountingSystem.Enum.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static EmployeeAccountingSystem.ConsoleColors.Ansi.*;
import static EmployeeAccountingSystem.Input.digitInput;

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
                    System.out.println(WHITE_BRIGHT + "Input Position for search:\n" +
                            ANSI_RESET + Arrays.asList(Position.values()));
                    String value = new Scanner(System.in).nextLine().trim();
                    for (Employee employee : employees) {
                        if (employee.getPosition().equals(Position.valueOf(value))) {
                            searchResults.add(employee);
                            System.out.println(employee);
                        }
                    }
                }
                case 3 -> {
                    System.out.println(WHITE_BRIGHT + "Input Department for search:\n" +
                            ANSI_RESET + Arrays.asList(Department.values()));
                    String value = new Scanner(System.in).nextLine().trim();
                    for (Employee employee : employees) {
                        if (employee.getDepartment().equals(Department.valueOf(value))) {
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
