package com.company;

import java.util.Date;
import java.util.Random;


public class Demo {

    private static int getRandomGrade(int min, int max) {
        if (min >= max) {
            return 90;
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private static void assignGeneratedGrades(Faculty faculty) {
        for (Exam exam: faculty.exams) {
            if (exam != null) {
                int submissionsNumber = 0; // exam.sumbissions.length;
                for (Enrollee submission : exam.sumbissions) {
                    if (submission != null) {
                        submissionsNumber++;
                    }
                }
                int generatedMarks[] = new int[submissionsNumber];
                for (int i = 0; i < submissionsNumber; i++) {
                    generatedMarks[i] = getRandomGrade(50, 100);
                }
                for (int i = 0; i < submissionsNumber; i++) {
                    Grade grade = new Grade(generatedMarks[i]);
                    exam.instructor.evaluateExam(exam.sumbissions[i], exam, grade);
                }
            }
        }
    }

    public static void main(String[] args) {

        // Instantiate entities
        Instructor instructor1 = new Instructor(1, "Lora", "Johnes", new Date(1961, 5, 17), "Professor");
        Instructor instructor2 = new Instructor(1, "Rebecca", "Laurens", new Date(1970, 6, 25), "Associate Professor");

	    Enrollee enrollee1 = new Enrollee(1, "Serge", "Pupkin", new Date(2000, 6, 27));
        Enrollee enrollee2 = new Enrollee(2, "Eleanora", "Lo", new Date(1999, 2, 28));
        Enrollee enrollee3 = new Enrollee(3, "Marylin", "Manson", new Date(1969, 1, 5));
        Enrollee enrollee4 = new Enrollee(4, "Jon", "Snow", new Date(1989, 2, 7));
        Enrollee enrollee5 = new Enrollee(5, "Lora", "Kirienko", new Date(1989, 3, 7));

        Faculty faculty1 = new Faculty("SE101", "Software Engineering");
        Faculty faculty2 = new Faculty("BA101", "Business Administration");

        Exam exam1 = new Exam("EM101a", "Mathematics", instructor1, faculty1);
        Exam exam2 = new Exam("EEN101a", "English", instructor2, faculty1);

        Exam exam3 = new Exam("EM101b", "Mathematics", instructor1, faculty2);
        Exam exam4 = new Exam("EEN101b", "English", instructor2, faculty2);


        // Enroll people
        enrollee1.apply(faculty1);
        enrollee2.apply(faculty1);
        enrollee3.apply(faculty1);
        enrollee4.apply(faculty2);
        enrollee5.apply(faculty2);

        System.out.println("List of people applied for " + faculty1);
        for (Enrollee enrollee: faculty1.enrollees) {
            if (enrollee != null) {  // TODO: replace arrays with other data structure to avoid this (here and below)
                System.out.println(enrollee);
            }
        }
        System.out.println("----------------------");
        System.out.println("List of people applied for " + faculty2);
        for (Enrollee enrollee: faculty2.enrollees) {
            if (enrollee != null) {
                System.out.println(enrollee);
            }
        }
        System.out.println("-------------------------------------------------");

        // Launch exams session
        System.out.println("Exam session launched...");
        for (Exam exam: faculty1.exams) {
            for (Enrollee enrollee: faculty1.enrollees) {
                if (enrollee != null && exam != null) {
                    enrollee.takeExam(exam);
                }
            }
        }
        for (Exam exam: faculty2.exams) {
            for (Enrollee enrollee: faculty2.enrollees) {
                if (enrollee != null && exam != null) {
                    enrollee.takeExam(exam);
                }
            }
        }
        System.out.println("-------------------------------------------------");

        // Evaluate submissions
        System.out.println("Instructors are evaluating submissions...");
        assignGeneratedGrades(faculty1);
        assignGeneratedGrades(faculty2);
        System.out.println("-------------------------------------------------");

        // Run selection process
        // NOTE: we can play with `Configs`
        System.out.println("Selecting the candidates...");
        System.out.println("List of people enrolled to " + faculty1 + " if any: ");
        for (Enrollee student: faculty1.selectSuccessfulEnrollees()) {
            if (student != null) {
                System.out.println(student + ", average grade: " + student.averageGrade);
            }
        }
        System.out.println("----------------------");
        System.out.println("List of people enrolled to " + faculty2 + " if any: ");
        for (Enrollee student: faculty2.selectSuccessfulEnrollees()) {
            if (student != null) {
                System.out.println(student + ", average grade: " + student.averageGrade);
            }
        }

    }

}
