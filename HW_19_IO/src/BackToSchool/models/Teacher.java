package BackToSchool.models;

import BackToSchool.constants.Gender;
import BackToSchool.constants.Subject;

import java.util.Arrays;

public class Teacher extends Person {
    private static final int MAX_SUBJECTS = 4;
    private double salary;
    private Subject[] subjects;
    private int subjectsCount;


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Subject[] getSubject() {
        return subjects;
    }

    public void setSubject(Subject[] subjects) {
        this.subjects = subjects;
    }

    public Teacher(String name, int age, Gender gender, double salary, Subject... subjects) {
        super(name, age, gender);
        this.salary = salary;
        this.subjects = generateSubjectsArray(subjects);
    }

    private Subject[] generateSubjectsArray(Subject... subjectSequence) {
        if (subjectSequence.length > 5) {
            throw new IllegalArgumentException("Too many workload");
        }
        subjectsCount = subjectSequence.length - 1;
        Subject[] subjects = new Subject[5];
        for (int i = 0; i < subjectSequence.length; i++) {
            subjects[i] = subjectSequence[i];
        }
        return subjects;
    }

    public boolean addSubject(Subject subject) {
        if (subjectsCount < MAX_SUBJECTS) {
            subjects[++subjectsCount] = subject;
            return true;
        }
        return false;
    }

    public boolean removeSubject(Subject subject) {
        String[] subjectsTitles = new String[subjects.length];
        int nonNullElsNumber = 0;
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                nonNullElsNumber++;
                subjectsTitles[i] = subjects[i].getName();
            }
        }
        String[] nonNullSubjectsTitles = new String[nonNullElsNumber];
        for (int i = 0; i < subjectsTitles.length; i++) {
            if (subjectsTitles[i] != null) {  // better double check
                nonNullSubjectsTitles[i] = subjectsTitles[i];
            }
        }
        int index = Arrays.binarySearch(nonNullSubjectsTitles, subject.getName());
        // int index = Arrays.binarySearch(subjects, subject);

        if (index < 0) {
            return false;
        }

        if(index != subjectsCount) {
            subjects[index] = subjects[subjectsCount];
        }
        subjects[subjectsCount] = null;
        subjectsCount--;
        return true;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "salary=" + salary +
                ", subjects count=" + subjectsCount +
                "} " + super.toString();
    }

}
