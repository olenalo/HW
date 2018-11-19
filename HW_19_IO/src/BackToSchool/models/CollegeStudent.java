package BackToSchool.models;

import BackToSchool.constants.Gender;

import BackToSchool.Utils;
import BackToSchool.constants.Major;

public class CollegeStudent extends Student {

    private static final int MIN_YEAR = 1;
    private static final int MAX_YEAR = 5;
    private int year;
    private Major major;


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        Utils.validate(year, MIN_YEAR, MAX_YEAR);
        this.year = year;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public CollegeStudent(String name, int age, Gender gender, String idNumber, double gpa, int year, Major major) {
        super(name, age, gender, idNumber, gpa);
        Utils.validate(year, MIN_YEAR, MAX_YEAR);
        this.year = year;
        this.major = major;
    }

    @Override
    public String toString() {
        return "CollegeStudent{" +
                "year=" + year +
                ", major=" + major +
                "} " + super.toString();
    }
}
