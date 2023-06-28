package EmployeeAccountingSystem;

import EmployeeAccountingSystem.AccountingSystem.EmployeeManagementSystem;

import java.io.IOException;

import java.util.Locale;

import static EmployeeAccountingSystem.AccountingSystem.FireEmployee.*;
import static EmployeeAccountingSystem.AccountingSystem.SearchEmployees.*;
import static EmployeeAccountingSystem.AccountingSystem.UpdateEmployee.*;
import static EmployeeAccountingSystem.ConsoleColors.Ansi.*;
import static EmployeeAccountingSystem.AccountingSystem.HireEmployee.*;
import static EmployeeAccountingSystem.AccountingSystem.Input.Input.*;


public class Main {

    public static void main(String[] args) throws IOException {

        // Создание объекта системы учета сотрудников
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        System.out.println(PURPLE_BRIGHT + "\n *** EMPLOYEE ACCOUNTING SYSTEM ***" +
                ("\nWelcome to Employee Accounting System :)").toUpperCase(Locale.ROOT) +
                ANSI_RESET);

        if (LoginPassword.userIdentification()) {
            System.out.println(ANSI_RED +
                    ("\n!!! FIRST upload employee information from file, please !!!").toUpperCase() +
                    ANSI_RESET);
            while (true) {
                System.out.println(WHITE_BRIGHT +
                        "\n* CHOOSE SOME OF THE OPTIONS *" + ANSI_RESET +
                        "\n[1] -" + ANSI_RED + " Upload employee information from file" + ANSI_RESET +
                        "\n[2] - Hire employee" +
                        "\n[3] - Fire employee" +
                        "\n[4] - Change employee information" +
                        "\n[5] - Search employees by attribute" +
                        "\n[6] - Create a report" +
                        WHITE_BRIGHT +
                        "\n[0] - Complete" + ANSI_RESET);

                switch (digitInput()) {
                    case 1 -> {
                        system.uploadEmployeeInformation();
                        system.infoAboutEmployees();
                    }
                    case 2 -> hireEmployee();
                    case 3 -> fireEmployee();
                    case 4 -> updateEmployee();
                    case 5 -> searchEmployees();
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