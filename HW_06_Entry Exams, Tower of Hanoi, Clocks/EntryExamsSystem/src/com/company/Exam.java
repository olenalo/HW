package com.company;

public class Exam {

    String examId;
    String courseName;
    Instructor instructor;
    Faculty faculty;
    Enrollee sumbissions[];
    int currentSubmissionIndex;  // TODO use data structure other than array to avoid this

    public Exam(String examId, String courseName, Instructor instructor, Faculty faculty) {
        this.examId = examId;
        this.courseName = courseName;  // TODO: Exam should better be linked to Faculty through Course (consider)
        this.instructor = instructor;
        this.sumbissions = new Enrollee[Config.maxEnrolleesNumber];
        this.currentSubmissionIndex = 0;

        this.faculty = faculty;
        faculty.addExam(this);
    }

    public void submitForEvaluation(Enrollee enrollee) {
        this.sumbissions[currentSubmissionIndex] = enrollee;
        this.currentSubmissionIndex++;
    }

    @Override
    public String toString() {
        return this.examId + " " + this.courseName;
    }

}
