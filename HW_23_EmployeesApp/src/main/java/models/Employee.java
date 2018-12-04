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

    private double salary;
    private String title;

    // TODO: use builder pattern
    public Employee(String id,
                    Date birthDate,
                    String firstName,
                    String lastName,
                    String gender,
                    Date hireDate) {
        this.id = id;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender.equals("F") ? Gender.FEMALE : Gender.MALE;
        this.hireDate = hireDate;
    }

    public Employee(String id,
                    Date birthDate,
                    String firstName,
                    String lastName,
                    String gender,
                    Date hireDate,
                    double salary,
                    String title) {
        this.id = id;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender.equals("F") ? Gender.FEMALE : Gender.MALE;
        this.hireDate = hireDate;
        this.salary = salary;
        this.title = title;
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

    public void setGender(Gender gender) {
        this.gender = gender;
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
}
