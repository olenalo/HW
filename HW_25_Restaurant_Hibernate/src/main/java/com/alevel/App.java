package com.alevel;

import com.alevel.constants.Menu;
import com.alevel.models.*;
import com.alevel.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.Scanner;

/**
 * Restaurant application (continuation of HW12).
 */
public class App {

    private static DishFactory dishFactory;

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Iva");
        employee.setSurname("Ivanovich");

        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employee);
        //session.getTransaction().commit();
        //session.close();

        System.out.println("The menu:");
        for (Menu dish : Menu.values()) {
            System.out.printf("Dish #%s: %s\n", dish.getDishDescriptors()[0], dish.getDishDescriptors()[1]);
        }
        System.out.println("--------------------------------");

        Order order = new Order();
        session.save(order); // TODO make it work (`orders` table to be created and populated)

        session.getTransaction().commit();  // TODO refactor (per transaction?)
        session.close();

        Scanner sc = new Scanner(System.in);
        int orderedDishesNumber = 0;
        while (orderedDishesNumber <= Order.MAX_DISHES_NUMBER) {
            System.out.println("Please select the dish (enter the number): ");
            String orderedDishIndex = sc.next();
            order.addDish(orderedDishIndex);  // TODO DB: assign dishId to Order entry once the dish is created
            orderedDishesNumber++;
            System.out.println("Would you like to order more dishes? y/n ");
            String continueOrderDecision = sc.next();
            if (continueOrderDecision.equals("n") || continueOrderDecision.equals("N")) {
                break;
            }
        }
        System.out.println("--------------");

        Waiter waiter = new Waiter("Mila", "Jovovich");
        // TODO: figure out how to assign to the order (using factory below? really?)
        Cook cook1 = new Cook("Marylin", "Manson");
        Cook cook2 = new Cook("Vanya", "Tomych");
        DishWasher dishwasher = new DishWasher("Tina", "Tinova");

        waiter.takeOrder(order);  // TODO DB: assign waiterId to Order entry
        System.out.println("You ordered: ");
        for (String[] dishDescr : order.getDishes()) {
            System.out.println(dishDescr[1]);
        }
        System.out.println("Thank you! Your order will be ready soon.");
        System.out.println("--------------------------------");

        if (order.getDishes() != null) {
            // TODO: move the logic to the `Order` class
            for (String[] orderedMenuItem : order.getDishes()) {
                System.out.println("Working on " + orderedMenuItem[1]);
                if (orderedMenuItem[2] != null) {
                    switch (orderedMenuItem[2]) {
                        case "Soup":
                            dishFactory = new SoupFactory();
                            break;
                        case "MainDish":
                            dishFactory = new MainDishFactory();
                            break;
                        case "Dessert":
                            dishFactory = new DessertFactory();
                            break;
                    }
                }

                // FIXME
                /*
                if (dishFactory != null) {
                    DishBuilder dishBuilder = dishFactory.cook(orderedMenuItem[0]);

                    dishBuilder
                            .environment(DishPreparationStep.valueOf("ENVIRONMENT").getDescription(), order, cook1)
                            .ingredients(DishPreparationStep.valueOf("INGREDIENTS").getDescription(), order, cook1)
                            .technology(DishPreparationStep.valueOf("TECHNOLOGY").getDescription(), order, cook2)
                            .utensil(DishPreparationStep.valueOf("UTENSIL").getDescription(), order, dishwasher)
                            .design(DishPreparationStep.valueOf("DESIGN").getDescription(), order, cook2);

                    System.out.println("--------------");
                    Dish dish = dishBuilder.createDish();
                    waiter.serveDish(order, dish);
                    System.out.println("--------------");
                }
                */

                System.out.println("===================================");

            }
        }

        System.out.println("Information on the order: ");
        for (Cook cook : order.getResponsibleCooks()) {
            System.out.println("Responsible cook: " + cook);
        }
        for (DishWasher dwasher : order.getResponsibleDishwashers()) {
            System.out.println("Responsible dishwasher: " + dwasher);
        }
        for (Waiter wter : order.getResponsibleWaiters()) {
            System.out.println("Responsible waiter: " + wter);
        }


    }

}
