package models;

import configs.Gender;

import java.util.Date;

public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date birthDate;
    private Date hireDate;

    private double totalSalaryEarned;
    private String title;
    private String department; // TODO could be of `Department` type

    public Employee(String firstName,
                    String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender.equals("F") ? Gender.FEMALE : Gender.MALE;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getTotalSalaryEarned() {
        return totalSalaryEarned;
    }

    public void setTotalSalaryEarned(double totalSalaryEarned) {
        this.totalSalaryEarned = totalSalaryEarned;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "}\n";
    }

    public String toStringSalaryTitle() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", total salary earned='" + totalSalaryEarned + '\'' +
                "}\n";
    }

    public String toStringHireDateDept() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", hire date='" + hireDate + '\'' +
                "}\n";
    }


}
