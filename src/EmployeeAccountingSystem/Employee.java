package EmployeeAccountingSystem;

import EmployeeAccountingSystem.Enum.Department;
import EmployeeAccountingSystem.Enum.Gender;
import EmployeeAccountingSystem.Enum.Position;

import java.util.Date;

// Класс, представляющий информацию о сотруднике
class Employee {
    private String fullName;
    private Date dateOfBirth;
    private Gender gender;
    private String contactNumber;
    private Position position;
    private Department department;
    private String supervisor;
    private Date hireDate;
    private double salary;

    // Конструктор
    public Employee(String fullName, Date dateOfBirth, Gender gender, String contactNumber, Position position,
                    Department department, String supervisor, Date hireDate, double salary) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.position = position;
        this.department = department;
        this.supervisor = supervisor;
        this.hireDate = hireDate;
        this.salary = salary;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee: " + fullName +
                "| department " + department +
                "| position " + position +
                "| supervisor " + supervisor +
                "| hireDate " + hireDate +
                "| salary " + salary +
                "| contactNumber " + contactNumber +
                "| dateOfBirth " + dateOfBirth +
                "| gender " + gender;
    }
}
