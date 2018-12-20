package com.alevel;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory = null;

    static {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(com.alevel.models.Employee.class);
        // TODO Add more annotated classes (to complete DB)
        sessionFactory = configuration.configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
