package com.company;

import java.util.Date;


public class Instructor extends Person {
    String status;  // "Professor", "Associate Professor"

    public Instructor(int id, String name, String surname, Date dateOfBirth, String degree) {
        super(id, name, surname, dateOfBirth);
        this.status = degree;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.status + " " + this.name + " " + this.surname;
    }

    public void evaluateExam(Enrollee enrollee, Exam exam, Grade grade) {
        enrollee.addGrade(exam, grade);
    }

}
