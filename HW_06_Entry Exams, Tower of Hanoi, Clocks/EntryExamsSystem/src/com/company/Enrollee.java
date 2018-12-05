package com.company;

import java.util.Date;


public class Enrollee extends Person {
    Grade[] grades;  // TODO: consider adding dictionary-like structure {Exam: Grade} or so; now we go exam agnostic
    int currentGradeIndex;  // TODO use data structure other than array to avoid this
    double averageGrade;

    public Enrollee(int id, String name, String surname, Date dateOfBirth) {
        super(id, name, surname, dateOfBirth);
        this.grades = new Grade[Config.maxEntryExamsNumber];  // So a student can only apply to a single faculty...
        this.currentGradeIndex = 0;
    }

    public void apply(Faculty faculty) {
        faculty.addEnrollment(this);
    }

    public void takeExam(Exam exam) {
        /*
        System.out.println("Faculty " + exam.faculty + ": student " + this + " has just taken the " + exam + " exam; " +
                "submitting the work for the instructor " + exam.instructor + " to evaluate... ");
        */
        exam.submitForEvaluation(this);
    }

    // TODO: store exam data (see TODO above)
    public void addGrade(Exam exam, Grade grade) {
        if (this.currentGradeIndex < Config.maxEntryExamsNumber) {
            this.grades[currentGradeIndex] = grade;
            this.currentGradeIndex++;
        } else {
            System.out.println("Cannot add any more grades: " +
                    "the max number of grades has been reached.");
        }

    }

    public double getAverageGrade() {
        int sum = 0;
        int len = 0;
        for (Grade grade: this.grades) {
            if (grade != null) {
                sum += grade.grade;
                len++;
            }
        }
        return (double) sum / len;
    }

}
