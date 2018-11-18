package BackToSchool;

import BackToSchool.constants.Gender;
import BackToSchool.models.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.util.ArrayList;

public class SerializeDeserializeDemo {

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        Person person = new Person("Ella", 25, Gender.FEMALE);
        persons.add(person); // TODO at least 5 objects!

        try(FileOutputStream fileOut = new FileOutputStream("hw19_persons.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
            System.out.println("Serialized data is saved in hw19_persons.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

        Person deserializedPerson = null;
        try(FileInputStream fileIn = new FileInputStream("hw19_persons.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            deserializedPerson = (Person) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
        }
        System.out.println("Deserialized personal data: " + deserializedPerson);

    }
}
