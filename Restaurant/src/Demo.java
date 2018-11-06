import java.util.Arrays;
import java.util.Scanner;

public class Demo {

    private static DishFactory dishFactory;

    public static void main(String[] args) {
        System.out.println("The menu:");
        for (Menu dish: Menu.values()) {
            System.out.printf("Dish #%s: %s\n", dish.dishDescriptors[0], dish.dishDescriptors[1]);
        }
        System.out.println("--------------------------------");

        Order order = new Order();
        Scanner sc = new Scanner(System.in);
        int orderedDishesNumber = 0;
        while (orderedDishesNumber <= Order.MAX_DISHES_NUMBER) {
            System.out.println("Please select the dish (enter the number): ");
            String orderedDishIndex = sc.next();
            order.addDish(orderedDishIndex);
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

        waiter.takeOrder(order);
        System.out.println("You ordered: ");
        for (String[] dishDescr: order.getDishes()) {
            System.out.println(dishDescr[1]);
        }
        System.out.println("Thank you! Your order will be ready soon.");
        System.out.println("--------------------------------");

        if (order.getDishes() != null) {
            // TODO: move it all to Order
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

                if (dishFactory != null) {
                    DishBuilder dishBuilder = dishFactory.cook(orderedMenuItem[0]);

                    dishBuilder
                            .environment(DishPreparationStep.valueOf("ENVIRONMENT").description, order, cook1)
                            .ingredients(DishPreparationStep.valueOf("INGREDIENTS").description, order, cook1)
                            .technology(DishPreparationStep.valueOf("TECHNOLOGY").description, order, cook2)
                            .utensil(DishPreparationStep.valueOf("UTENSIL").description, order, dishwasher)
                            .design(DishPreparationStep.valueOf("DESIGN").description, order, cook2);

                    System.out.println("--------------");
                    Dish dish = dishBuilder.createDish();
                    waiter.serveDish(order, dish);
                    System.out.println("--------------");
                }

                System.out.println("===================================");

            }
        }

        System.out.println("Information on the order: ");
        for (Cook cook: order.getResponsibleCooks()) {
            System.out.println("Responsible cook: " + cook);
        }
        for (DishWasher dwasher: order.getResponsibleDishwashers()) {
            System.out.println("Responsible dishwasher: " + dwasher);
        }
        for (Waiter wter: order.getResponsibleWaiters()) {
            System.out.println("Responsible waiter: " + wter);
        }


    }

}
