package com.alevel.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory = null;

    static {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(com.alevel.models.Employee.class);
        configuration.addAnnotatedClass(com.alevel.models.Dish.class);
        configuration.addAnnotatedClass(com.alevel.models.Order.class);
        sessionFactory = configuration.configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
