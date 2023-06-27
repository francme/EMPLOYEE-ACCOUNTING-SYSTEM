package EmployeeAccountingSystem;

import java.io.IOException;
import java.text.ParseException;

import java.util.Locale;
import java.util.Scanner;

import static EmployeeAccountingSystem.ConsoleColors.Ansi.*;


public class Main {

    public static void main(String[] args) throws ParseException, IOException {

        // Создание объекта системы учета сотрудников
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        System.out.println(PURPLE_BRIGHT + "\n *** EMPLOYEE ACCOUNTING SYSTEM ***" +
                ("\nWelcome to Employee Accounting System").toUpperCase(Locale.ROOT) +
                ANSI_RESET);

        if (LoginPassword.userIdentification()) {
            System.out.println(ANSI_RED + "\n!!!Upload employee information from file, please!!!" + ANSI_RESET);
            while (true) {
                System.out.println(WHITE_BRIGHT +
                        "\n* CHOOSE SOME OF THE OPTIONS *" +
                        ANSI_RESET +
                        "\n[1] - Upload employee information from file" +
                        "\n[2] - Add employee" +
                        "\n[3] - Fire employee" +
                        "\n[4] - Change employee information" +
                        "\n[5] - Search employees by attribute" +
                        "\n[6] - Create a report" +
                        WHITE_BRIGHT +
                        "\n[0] - Complete" + ANSI_RESET);

                Scanner scanner = new Scanner(System.in);
                while (!scanner.hasNext("[0-9]+")) {
                    System.out.println("You're input not a digit." +
                            "\nInput some digit as your choose from menu:");
                    scanner.next();
                }
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1 -> system.uploadEmployeeInformation();
                    case 2 -> system.hireEmployee();
                    case 3 -> system.fireEmployee();
                    case 4 -> system.updateEmployee();
                    case 5 -> system.searchEmployees();
                    case 6 -> system.chooseGenerateReport();
                    case 0 -> {
                        System.out.println(ANSI_RED + "Completed." + ANSI_RESET);
                        return;
                    }
                    default -> System.out.println(ANSI_RED + "Invalid input!" + ANSI_RESET);
                }
            }
        }
    }
}