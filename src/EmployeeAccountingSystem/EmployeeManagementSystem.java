package EmployeeAccountingSystem;

import EmployeeAccountingSystem.Enum.Department;
import EmployeeAccountingSystem.Enum.Gender;
import EmployeeAccountingSystem.Enum.Position;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Класс, представляющий систему учета сотрудников
class EmployeeManagementSystem {
    private List<Employee> employees;
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    // Конструктор
    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    // Метод для принятия нового сотрудника на работу
    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    // Метод для увольнения сотрудника
    public void fireEmployee(Employee employee) {
        employees.remove(employee);
    }

    // Метод для изменения информации о сотруднике
    public void updateEmployee(Employee employee, String attribute, String value) {
        switch (attribute) {
            case "fullName":
                employee.setFullName(value);
                break;
            case "dateOfBirth":
                try {
                    Date date = formatter.parse(value);
                    employee.setDateOfBirth(date);
                } catch (ParseException e) {
                    e.getStackTrace();
                }
                break;
            case "gender":
                employee.setGender(Gender.valueOf(value));
                break;
            case "contactNumber":
                employee.setContactNumber(value);
                break;
            case "position":
                employee.setPosition(Position.valueOf(value));
                break;
            case "department":
                employee.setDepartment(Department.valueOf(value));
                break;
            case "supervisor":
                employee.setSupervisor(value);
                break;
            case "hireDate":
                try {
                    Date date = formatter.parse(value);
                    employee.setHireDate(date);
                } catch (ParseException e) {
                    e.getStackTrace();
                }
                break;
            case "salary":
                employee.setSalary(Double.valueOf(value));
                break;
            default:
                System.out.println("Неверный атрибут!");
        }
    }

    // Метод для поиска сотрудников по различным параметрам
    public List<Employee> searchEmployees(String attribute, String value) {
        List<Employee> searchResults = new ArrayList<>();

        for (Employee employee : employees) {
            switch (attribute) {
                case "fullName":
                    if (employee.getFullName().equals(value))
                        searchResults.add(employee);
                    break;
                case "position":
                    // Поиск по должности
                    break;
                case "department":
                    // Поиск по отделу
                    break;
                case "supervisor":
                    // Поиск по начальнику
                    break;
                default:
                    System.out.println("Неверный атрибут!");
            }
        }

        return searchResults;
    }

    // Метод для создания отчета со структурой организации
    public void generateOrganizationStructureReport() {
        // Генерация отчета о структуре организации
    }

    // Метод для создания отчета со средней зарплатой по организации и отделам
    public void generateAverageSalaryReport() {
        // Генерация отчета со средней зарплатой
    }

    // Метод для создания отчета с ТОП-10 самых дорогих сотрудников по зарплате
    public void generateTopSalaryReport() {
        // Генерация отчета с ТОП-10 самых дорогих сотрудников
    }

    // Метод для создания отчета с ТОП-10 самых преданных сотрудников по количеству лет работы
    public void generateTopSeniorityReport() {
        // Генерация отчета с ТОП-10 самых преданных сотрудников
    }
}
