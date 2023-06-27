package EmployeeAccountingSystem;

import EmployeeAccountingSystem.Enum.Department;
import EmployeeAccountingSystem.Enum.Gender;
import EmployeeAccountingSystem.Enum.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static EmployeeAccountingSystem.ConsoleColors.Ansi.*;
import static EmployeeAccountingSystem.Input.*;

// Класс, представляющий систему учета сотрудников
class EmployeeManagementSystem {
    private List<Employee> employees;

    // Конструктор
    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    // Метод для выгрузки информации о сотрудниках из файла
    public void uploadEmployeeInformation() throws IOException {
        System.out.println(ANSI_PURPLE + "UPLOAD EMPLOYEE INFORMATION FROM FILE" + ANSI_RESET);
        String path = "data/employees";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<String> employeesLines = new ArrayList<>();
        String line = bufferedReader.readLine();
        employees = new ArrayList<>();

        while (line != null) {
            employeesLines.add(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();

        for (int i = 0; i < employeesLines.size(); i++) {

            String[] stringEmployee = employeesLines.get(i).split(", ");

            String fullName = stringEmployee[0].trim();
            String department = stringEmployee[1].trim().substring(12).trim();
            String position = stringEmployee[2].trim().substring(10).trim();
            String supervisor = stringEmployee[3].trim().substring(12).trim();
            String dateOfHire = (stringEmployee[4].trim().substring(10).trim());
            String salary = stringEmployee[5].trim().substring(8).trim();
            String contactNumber = stringEmployee[6].trim().substring(16).trim();
            String dateOfBirth = (stringEmployee[7].trim().substring(15).trim());
            String gender = stringEmployee[8].trim().substring(8).trim();

            employees.add(new Employee(fullName,
                    dateOfBirth,
                    Gender.valueOf(gender),
                    contactNumber,
                    Position.valueOf(position),
                    Department.valueOf(department),
                    supervisor,
                    dateOfHire,
                    Double.valueOf(salary)));
        }
        infoAboutEmployees();
    }

    // Метод для вывода информации о сотрудниках, используется в других методах
    public void infoAboutEmployees() {
        System.out.println(ANSI_PURPLE + "INFORMATION ABOUT EMPLOYEES" + ANSI_RESET);
        int count = 1;
        for (Employee employee : employees) {
            System.out.println(String.format("%2d", count) + ". " + employee);
            count++;
        }
    }

    // Метод для принятия нового сотрудника на работу
    public void hireEmployee() {
        System.out.println(ANSI_PURPLE + "HIRE NEW EMPLOYEE" + ANSI_RESET);

        System.out.println("Input full name of employee: ");
        String fullName = new Scanner(System.in).nextLine().trim();

        System.out.println("Input Date of Birth <yyyy-mm-dd>: ");
        String dateOfBirth = new Scanner(System.in).nextLine().trim();

        System.out.println("Input gender: " +
                "\nMALE or FEMALE");
        String gender = new Scanner(System.in).nextLine().trim().toUpperCase(Locale.ROOT);

        System.out.println("Input contact number: ");
        String contactNumber = new Scanner(System.in).nextLine().trim();

        System.out.println("Input position: " +
                "\nCEO, CHIEF_ACCOUNTANT, ACCOUNTANT, DEPARTMENT_MANAGER, MANAGER, MASTER or OTHER_STAFF");
        String position = new Scanner(System.in).nextLine().trim().toUpperCase(Locale.ROOT);

        System.out.println("Input department: " +
                "\nCEO, ACCOUNTING, PRODUCTION, or SALES");
        String department = new Scanner(System.in).nextLine().trim().toUpperCase(Locale.ROOT);

        System.out.println("Input supervisor: ");
        String supervisor = new Scanner(System.in).nextLine().trim();

        System.out.println("Input Date of hire <yyyy-mm-dd>: ");
        String dateOfHire = new Scanner(System.in).nextLine().trim();

        System.out.println("Input salary: ");
        double salary = new Scanner(System.in).nextDouble();

        employees.add(new Employee(fullName,
                dateOfBirth,
                Gender.valueOf(gender),
                contactNumber,
                Position.valueOf(position),
                Department.valueOf(department),
                supervisor,
                dateOfHire,
                salary));

        System.out.println(WHITE_BRIGHT + "New employee is added." + ANSI_RESET);
        safeEmployeeInformationToFile();
    }

    // Метод для увольнения сотрудника
    public void fireEmployee() {
        System.out.println(ANSI_PURPLE + "FIRE A EMPLOYEE" + ANSI_RESET);
        System.out.println("Input full name of employee: ");
        String input = new Scanner(System.in).nextLine().trim();
        for (Employee employee : employees) {
            if (employee.getFullName().equals(input))
                employees.remove(employee);
        }
        System.out.println(WHITE_BRIGHT + "Employee" + input + "is fired." + ANSI_RESET);
        safeEmployeeInformationToFile();
    }

    // Метод для изменения информации о сотруднике
    public void updateEmployee() {
        System.out.println(ANSI_PURPLE + "UPDATE A EMPLOYEE" + ANSI_RESET);
        infoAboutEmployees();

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
            System.out.println(WHITE_BRIGHT + "CHOOSE ATTRIBUTE FOR CHANGE" +
                    ANSI_RESET +
                    "\n[1] - fullName" +
                    "\n[2] - dateOfBirth" +
                    "\n[3] - gender" +
                    "\n[4] - contactNumber" +
                    "\n[5] - position" +
                    "\n[6] - department" +
                    "\n[7] - supervisor" +
                    "\n[8] - hireDate" +
                    "\n[9] - salary" +
                    WHITE_BRIGHT +
                    "\n[0] - Return" +
                    ANSI_RESET);

            switch (digitOfChoose()) {
                case 1:
                    employees.get(input - 1).setFullName(inputValue());
                    break;
                case 2:
                    System.out.println("Input format <yyyy-mm-dd>!");
                    employees.get(input - 1).setDateOfBirth(inputValue());
                    break;
                case 3:
                    System.out.println("Input format <MALE> or <FEMALE>!");
                    employees.get(input - 1).setGender(Gender.valueOf(inputValue()));
                    break;
                case 4:
                    employees.get(input - 1).setContactNumber(inputValue());
                    break;
                case 5:
                    System.out.println("Input format <CEO>, <CHIEF_ACCOUNTANT>, " +
                            "\n<ACCOUNTANT>, <DEPARTMENT_MANAGER>, " +
                            "\n<MANAGER>, <MASTER> or <OTHER_STAFF>!");
                    employees.get(input - 1).setPosition(Position.valueOf(inputValue()));
                    break;
                case 6:
                    System.out.println("Input format <CEO>, " +
                            "\n<ACCOUNTING>, <PRODUCTION> or <SALES>!");
                    employees.get(input - 1).setDepartment(Department.valueOf(inputValue()));
                    break;
                case 7:
                    employees.get(input - 1).setSupervisor(inputValue());
                    break;
                case 8:
                    System.out.println("Input format <yyyy-mm-dd>!");
                    employees.get(input - 1).setHireDate(inputValue());
                    break;
                case 9:
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
            safeEmployeeInformationToFile();
        }
    }

    // Метод для поиска сотрудников по различным параметрам
    public List<Employee> searchEmployees() {
        infoAboutEmployees();
        System.out.println(ANSI_PURPLE + "SEARCH EMPLOYEE" + ANSI_RESET);
        List<Employee> searchResults = new ArrayList<>();
        boolean menu = true;
        while (menu) {
            System.out.println(WHITE_BRIGHT + "CHOOSE ATTRIBUTE FOR SEARCH" +
                    ANSI_RESET +
                    "\n[1] - fullName" +
                    "\n[2] - position" +
                    "\n[3] - department" +
                    "\n[4] - supervisor" +
                    WHITE_BRIGHT +
                    "\n[0] - Return" +
                    ANSI_RESET);

            switch (digitOfChoose()) {
                case 1 -> {
                    System.out.println("Input Full Name for search: ");
                    String value = new Scanner(System.in).nextLine().trim();
                    for (Employee employee : employees) {
                        if (employee.getFullName().equals(value)) {
                            searchResults.add(employee);
                            System.out.println(employee);
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Input Position for search: " +
                            "\nCEO, CHIEF_ACCOUNTANT, ACCOUNTANT, DEPARTMENT_MANAGER," +
                            "\nMANAGER, MASTER or OTHER_STAFF");
                    String value = new Scanner(System.in).nextLine().trim();
                    for (Employee employee : employees) {
                        if (employee.getPosition().equals(Position.valueOf(value))) {
                            searchResults.add(employee);
                            System.out.println(employee);
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Input Department for search:" +
                            "\nCEO, ACCOUNTING, PRODUCTION, SALES");
                    String value = new Scanner(System.in).nextLine().trim();
                    for (Employee employee : employees) {
                        if (employee.getDepartment().equals(Department.valueOf(value))) {
                            searchResults.add(employee);
                            System.out.println(employee);
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Input full name of Supervisor for search: ");
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

    // Метод выбора отчета
    public void chooseGenerateReport() {
        System.out.println(ANSI_PURPLE + "REPORTS" + ANSI_RESET);
        boolean menu = true;
        while (menu) {
            System.out.println(WHITE_BRIGHT +
                    "\nCHOOSE REPORT:" +
                    ANSI_RESET +
                    "\n[1] - Organization Structure Report" +
                    "\n[2] - Average Salary Report" +
                    "\n[3] - Top Salary Report" +
                    "\n[4] - Top Seniority Report" +
                    WHITE_BRIGHT +
                    "\n[0] - Return" +
                    ANSI_RESET);

            switch (digitOfChoose()) {
                case 1 -> generateOrganizationStructureReport();
                case 2 -> generateAverageSalaryReport();
                case 3 -> generateTopSalaryReport();
                case 4 -> generateTopSeniorityReport();
                case 0 -> menu = false;
                default -> System.out.println(ANSI_RED + "Invalid input!" + ANSI_RESET);
            }
        }
    }

    // Метод для создания отчета со структурой организации
    public void generateOrganizationStructureReport() {
        // Генерация отчета о структуре организации
        StringBuilder stringBuilder = new StringBuilder();

        System.out.println(WHITE_BRIGHT + "\nCEO:" + ANSI_RESET);
        stringBuilder.append("\nCEO:");
        for (Employee employee : employees) {
            if (employee.getPosition().equals(Position.CEO)) {
                System.out.println("\t" + employee.getFullName());
                stringBuilder.append("\n" + employee.getFullName());
            }
        }
        System.out.println(WHITE_BRIGHT + "\nCHIEF ACCOUNTANT:" + ANSI_RESET);
        stringBuilder.append("\n\nCHIEF ACCOUNTANT:");
        for (Employee employee : employees) {
            if (employee.getPosition().equals(Position.CHIEF_ACCOUNTANT)) {
                System.out.println("\t" + employee.getFullName());
                stringBuilder.append("\n" + employee.getFullName());
            }
        }
        System.out.println(WHITE_BRIGHT + "\nDepartment CEO:" + ANSI_RESET);
        stringBuilder.append("\n\nDepartment CEO:");
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(Department.CEO)) {
                System.out.println("\t" + employee.getFullName() + " - " + employee.getPosition());
                stringBuilder.append("\n" + employee.getFullName() + " - " + employee.getPosition());
            }
        }
        System.out.println(WHITE_BRIGHT + "\nDepartment ACCOUNTING:" + ANSI_RESET);
        stringBuilder.append("\n\nDepartment ACCOUNTING:");
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(Department.ACCOUNTING)) {
                System.out.println("\t" + employee.getFullName() + " - " + employee.getPosition());
                stringBuilder.append("\n" + employee.getFullName() + " - " + employee.getPosition());
            }
        }
        System.out.println(WHITE_BRIGHT + "\nDepartment SALES:" + ANSI_RESET);
        stringBuilder.append("\n\nDepartment SALES:");
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(Department.SALES)) {
                System.out.println("\t" + employee.getFullName() + " - " + employee.getPosition());
                stringBuilder.append("\n" + employee.getFullName() + " - " + employee.getPosition());
            }
        }
        System.out.println(WHITE_BRIGHT + "\nDepartment PRODUCTION:" + ANSI_RESET);
        stringBuilder.append("\n\nDepartment PRODUCTION:");
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(Department.PRODUCTION)) {
                System.out.println("\t" + employee.getFullName() + " - " + employee.getPosition());
                stringBuilder.append("\n" + employee.getFullName() + " - " + employee.getPosition());
            }
        }

        // Сохранение отчета с организационной структурой
        String path = "data/OrganizationStructureReport";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write("Organization Structure Report\n" + String.valueOf(stringBuilder));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(WHITE_BRIGHT +
                "Organization Structure Report saved to file with path: " + path +
                ANSI_RESET);
    }

    // Метод для создания отчета со средней зарплатой по организации и отделам
    public void generateAverageSalaryReport() {
        // Генерация отчета со средней зарплатой
        double allSalaries = 0;
        int count = 1;
        for (Employee employee : employees) {
            allSalaries += employee.getSalary();
            count++;
        }
        StringBuilder averageSalary = new StringBuilder();
        averageSalary.append("\nCount of employees: " + (count - 1) +
                "\nWage fund:          " + allSalaries +
                "\nAverage salary:     " + (Math.round(allSalaries / count)));
        System.out.println(WHITE_BRIGHT + averageSalary + ANSI_RESET);

        // Сохранение отчета по средней зарплате
        String path = "data/AverageSalaryReport";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);

                fileWriter.write("Average Salary Report\n" + averageSalary);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(WHITE_BRIGHT +
                "Average Salary Report saved to file with path: " + path +
                ANSI_RESET);
    }

    // Метод для создания отчета с ТОП-10 самых дорогих сотрудников по зарплате
    public void generateTopSalaryReport() {
        // Генерация отчета с ТОП-5 самых дорогих сотрудников
        List<Employee> sortedBySalary =
                employees.stream()
                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .limit(5)
                        .collect(Collectors.toList());
        for (int i = 0; i < 5; i++) {
            System.out.println(WHITE_BRIGHT + (i + 1) + ". " + sortedBySalary.get(i).getSalary() +
                    ANSI_RESET + " :: " + sortedBySalary.get(i));
        }
        // Сохранение отчета с ТОП-5 самых высокооплачиваемых сотрудников
        String path = "data/TopSalaryReport";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write("Top-5 Salary Report\n\n");
            for (Employee employee : sortedBySalary)
                fileWriter.write(employee + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(WHITE_BRIGHT +
                "Top-5 Salary Report saved to file with path: " + path +
                ANSI_RESET);
    }

    // Метод для создания отчета с ТОП-5 самых преданных сотрудников по количеству лет работы
    public void generateTopSeniorityReport() {
        // Генерация отчета с ТОП-5 самых преданных сотрудников
        List<Employee> sortedByHireDate =
                employees.stream()
                        .sorted(Comparator.comparing(Employee::getHireDate))
                        .limit(5)
                        .collect(Collectors.toList());
        for (int i = 0; i < 5; i++) {
            System.out.println(WHITE_BRIGHT + (i + 1) + ". " +
                    sortedByHireDate.get(i).getHireDate() +
                    ANSI_RESET + " :: " + sortedByHireDate.get(i));
        }

        // Сохранение отчета с ТОП-5 самых преданных сотрудников
        String path = "data/TopSeniorityReport";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write("Top-5 Seniority Report\n\n");
            for (Employee employee : sortedByHireDate)
                fileWriter.write(employee + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(WHITE_BRIGHT +
                "Top-5 Seniority Report saved to file with path: " + path +
                ANSI_RESET);
    }

    // Метод для сохранения информации о сотрудниках в файл, используется в других методах
    public void safeEmployeeInformationToFile() {

        String path = "data/employees";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            for (Employee employee : employees)
                fileWriter.write(employee + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(WHITE_BRIGHT + "Employee information saved to file with path: " + ANSI_RESET + path);
    }
}
