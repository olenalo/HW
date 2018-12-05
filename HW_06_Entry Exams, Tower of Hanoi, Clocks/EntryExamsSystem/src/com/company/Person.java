package com.company;

import java.util.Date;


public class Person {

    int id;
    String name;
    String surname;
    Date dateOfBirth;

    public Person(int id, String name, String surname, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.surname;
    }

    // TODO: calculate age...

}
