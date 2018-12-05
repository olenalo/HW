package com.company;

public class Faculty {

    String facultyIndex;
    String facultyName;
    Exam[] exams;
    Enrollee[] enrollees;
    int currentEnrolleeIndex;  // TODO use data structure other than array to avoid this; see, here, below, and in other classes
    int currentExamIndex;

    public Faculty(String facultyIndex, String facultyName) {
        this.facultyIndex = facultyIndex;
        this.facultyName = facultyName;
        this.exams = new Exam[Config.maxEntryExamsNumber];
        this.enrollees = new Enrollee[Config.maxEnrolleesNumber];
        this.currentEnrolleeIndex = 0;
        this.currentExamIndex = 0;
    }

    @Override
    public String toString() {
        return this.facultyIndex + " " + this.facultyName;
    }

    public void addExam(Exam exam) {
        if (this.currentExamIndex < Config.maxEntryExamsNumber) {
            this.exams[currentExamIndex] = exam;
            this.currentExamIndex++;
        } else {
            System.out.println("Cannot add any more exams: " +
                    "the max number of exams has been reached.");
        }
    }

    public void addEnrollment(Enrollee enrollee) {
        if (this.currentEnrolleeIndex <= Config.maxEnrolleesNumber) {
            this.enrollees[currentEnrolleeIndex] = enrollee;
            this.currentEnrolleeIndex++;
        } else {
            System.out.println("Cannot accept enrollments anymore: " +
                    "the max number of enrollments has been reached.");
        }
    }

    public Enrollee[] selectSuccessfulEnrollees() {
        Enrollee[] students = new Enrollee[Config.maxEnrolleesNumber];  // TODO max students number, not enrollees?
        int currentStudentIndex = 0;
        for (Enrollee enrollee: this.enrollees) {
            if (enrollee != null) {  // TODO: replace array with other data structure to avoid this
                double avgGrade = enrollee.getAverageGrade();
                // System.out.println("Average grade of " + enrollee + " is " + avgGrade);
                if (avgGrade >= Config.passAverageGradeLevel) {
                    enrollee.averageGrade = avgGrade;
                    students[currentStudentIndex] = enrollee;
                    currentStudentIndex++;
                }

            }
        }
        return students;
    }

}
