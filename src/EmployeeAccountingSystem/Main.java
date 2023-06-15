package EmployeeAccountingSystem;

import EmployeeAccountingSystem.ConsoleColors.Ansi;
import EmployeeAccountingSystem.Enum.Department;
import EmployeeAccountingSystem.Enum.Gender;
import EmployeeAccountingSystem.Enum.Position;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Создание объекта системы учета сотрудников
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        // Пример добавления сотрудника
        Employee employee1 = new Employee("John Doe", new Date(), Gender.MALE, "+1234567890",
                Position.CEO, Department.CEO, "-", new Date(), 10_000.0);
        system.hireEmployee(employee1);

        Employee employee2 = new Employee("Kara Black", new Date(), Gender.FEMALE, "+1237770077",
                Position.CHIEF_ACCOUNTANT, Department.ACCOUNTING, "John Doe", new Date(), 8_000.0);
        system.hireEmployee(employee2);

        Employee employee3 = new Employee("Sarah Wong", new Date(), Gender.FEMALE, "+1237770066",
                Position.ACCOUNTANT, Department.ACCOUNTING, "Kara Black", new Date(), 5_000.0);
        system.hireEmployee(employee3);

        Employee employee4 = new Employee("Jane Smith", new Date(), Gender.FEMALE, "+1235550055",
                Position.DEPARTMENT_MANAGER, Department.SALES, "John Doe", new Date(), 7_000.0);
        system.hireEmployee(employee4);

        Employee employee5 = new Employee("Jack Li", new Date(), Gender.MALE, "+1235550066",
                Position.MANAGER, Department.SALES, "Jane Smith", new Date(), 3_000.0);
        system.hireEmployee(employee5);

        Employee employee6 = new Employee("Alex White", new Date(), Gender.MALE, "+1232220022",
                Position.DEPARTMENT_MANAGER, Department.PRODUCTION, "John Doe", new Date(), 7_000.0);
        system.hireEmployee(employee6);

        Employee employee7 = new Employee("Yan Young", new Date(), Gender.MALE, "+1232220066",
                Position.MASTER, Department.PRODUCTION, "Alex White", new Date(), 3_000.0);
        system.hireEmployee(employee7);

        Employee employee8 = new Employee("Anna Frank", new Date(), Gender.FEMALE, "+1233333333",
                Position.OTHER_STAFF, Department.SALES, "John Doe", new Date(), 8_000.0);
        system.hireEmployee(employee8);


        System.out.println(Ansi.PURPLE_BRIGHT + "\n *** EMPLOYEE ACCOUNTING SYSTEM ***" +
                ("\nWelcome to Employee Accounting System").toUpperCase(Locale.ROOT) +
                Ansi.ANSI_RESET);

        if(LoginPassword.userIdentification()) {
            while (true) {
                System.out.println(Ansi.WHITE_BRIGHT +
                        "\n* CHOOSE SOME OF THE OPTIONS *" +
                        Ansi.ANSI_RESET +
                        "\n[1] - Add employee" +
                        "\n[2] - Fire employee" +
                        "\n[3] - Change employee information" +
                        "\n[4] - Search employee" +
                        "\n[5] - Create a report" +
                        "\n[6] - Safe employee information to file" +
                        "\n[6] - Upload employee information from file" +
                        "\n[0] - Complete.");
                int choose = new Scanner(System.in).nextInt();
                switch (choose) {
//                    case 1 ->
//                    case 2 ->
//                    case 3 ->
//                    case 4 ->
//                    case 5 ->
//                    case 6 ->
//                    case 0 ->
                }
            }
        }



        // Пример изменения информации о сотруднике
        system.updateEmployee(employee1, "position", String.valueOf(Position.DEPARTMENT_MANAGER));


        // Пример поиска сотрудников
        List<Employee> searchResults = system.searchEmployees("position", "Manager");

        // Пример создания отчетов
        system.generateOrganizationStructureReport();
        system.generateAverageSalaryReport();
        system.generateTopSalaryReport();
        system.generateTopSeniorityReport();

        // Пример сохранения и загрузки информации об организации из файлов
        // ...
    }
}