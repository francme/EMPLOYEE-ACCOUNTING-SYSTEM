package EmployeeAccountingSystem;

import EmployeeAccountingSystem.Enum.Department;
import EmployeeAccountingSystem.Enum.Gender;
import EmployeeAccountingSystem.Enum.Position;


// Класс, представляющий информацию о сотруднике
class Employee {
    private String fullName;
    private String dateOfBirth;
    private Gender gender;
    private String contactNumber;
    private Position position;
    private Department department;
    private String supervisor;
    private String hireDate;
    private double salary;

    // Конструктор
    public Employee(String fullName, String dateOfBirth, Gender gender, String contactNumber, Position position,
                    Department department, String supervisor, String hireDate, double salary) {
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

    public String getDateOfBirth() {
        return String.valueOf(dateOfBirth);
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
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
        return String.format("%-13s", fullName) +
                ", Department: " + String.format("%-11s", department) +
                ", Position: " + String.format("%-19s",position) +
                ", Supervisor: " + String.format("%-12s", supervisor) +
                ", HireDate: " +  hireDate +
                ", Salary: " + String.format("%7d", (int)salary) +
                ", Contact Number: " + String.format("%-13s",contactNumber) +
                ", Date Of Birth: " + dateOfBirth +
                ", Gender: " + gender;
    }
}
