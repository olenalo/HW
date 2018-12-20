package com.alevel;

import com.alevel.models.Employee;
import org.hibernate.Session;

/**
 * Restaurant application (continuation of HW12).
 */
public class App {
    public static void main(String[] args) {
        Employee student = new Employee();
        student.setName("Iva");
        student.setSurname("Ivanovich");

        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }
}
