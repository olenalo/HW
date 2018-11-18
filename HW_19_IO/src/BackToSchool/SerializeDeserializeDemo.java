package BackToSchool;

import BackToSchool.constants.Gender;
import BackToSchool.models.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import java.util.Scanner;

public class SerializeDeserializeDemo {

    private static String getUserDefinedData() {
        System.out.println("Please enter: the name of an input file, " +
                "e.g. 'hw19_persons_empty_input.txt', 'hw19_persons_input.txt'.");
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.next();
        }
    }

    public static void serializePersons(ArrayList<Person> persons, String toFileName) {
        try(FileOutputStream fileOut = new FileOutputStream(toFileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(persons);
            System.out.println("Serialized data is saved in " + toFileName);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static ArrayList<Person> deserializePersons(String fromFileName) {
        ArrayList<Person> deserializedPersons = null;
        try(FileInputStream fileIn = new FileInputStream(fromFileName);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            deserializedPersons = (ArrayList<Person>) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
        }
        System.out.println("Deserialized personal data: " + deserializedPersons);
        return deserializedPersons;
    }

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        Person person1 = new Person("Ella", 25, Gender.FEMALE);
        Person person2 = new Person("Ihor", 30, Gender.MALE);
        Person person3 = new Person("Mary", 25, Gender.FEMALE);
        Person person4 = new Person("Olga", 27, Gender.FEMALE);
        Person person5 = new Person("Felix", 22, Gender.MALE);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);

        // TODO consider externalization
       serializePersons(persons, "hw19_persons.ser");
        deserializePersons("hw19_persons.ser");

    }
}
