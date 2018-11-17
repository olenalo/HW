package BackToSchool.models;

import BackToSchool.constants.Gender;
import BackToSchool.Utils;

public class Person {
    public static final int MIN_AGE = 0;
    public static final int MAX_AGE = 100;
    private String name;
    private int age;
    private Gender gender;

    public Person(String name, int age, Gender gender) {
        Utils.validate(age, MIN_AGE, MAX_AGE);
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
