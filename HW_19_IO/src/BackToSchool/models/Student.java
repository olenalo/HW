package BackToSchool.models;

import BackToSchool.constants.Gender;
import BackToSchool.Utils;

public class Student extends Person {
    private static final int MIN_GPA = 0;
    private static final int MAX_GPA = 5;
    private static final String REGEX = "[A-Z]{2,4}\\d{3,5}";
    private String idNumber;
    private double gpa;

    public void setGpa(double gpa) {
        Utils.validate(gpa, MIN_GPA, MAX_GPA);
        this.gpa = gpa;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public double getGpa() {
        return gpa;
    }

    public Student(String name, int age, Gender gender, String idNumber, double gpa) {
        super(name, age, gender);
        Utils.validate(gpa, MIN_GPA, MAX_GPA);
        Utils.validateString(REGEX, idNumber);
        this.idNumber = idNumber;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", gender=" +getGender() +
                ", idNumber='" + idNumber + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
