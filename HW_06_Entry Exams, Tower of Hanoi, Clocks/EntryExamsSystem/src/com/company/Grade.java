package com.company;

public class Grade {
    int grade;
    String gradeLevel; // A, B, C, D

    public Grade (int grade) {
        this.grade = grade;
        if (grade >= 87 && grade < 100) {
            this.gradeLevel = "A";
        } else if (grade >= 83 && grade < 86) {
            this.gradeLevel = "B";
        } else if (grade >= 73 && grade < 76) {
            this.gradeLevel = "C";
        } else if(grade >= 65 && grade < 66) {
            this.gradeLevel = "D";
        } else {
            this.gradeLevel = "A"; // TODO what is better than A for default? raising an exception?
        }
    }

}
