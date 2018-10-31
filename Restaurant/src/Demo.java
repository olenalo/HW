import java.util.Scanner;

public class Demo {

    private static DishFactory dishFactory;

    public static void main(String[] args) {
        System.out.println("The menu:");
        for (Menu dish: Menu.values()) {
            System.out.printf("Dish #%s: %s\n", dish.dishDescriptors[0], dish.dishDescriptors[1]);
        }
        System.out.println("--------------------------------");

        Scanner sc = new Scanner(System.in);
        System.out.println("Please select the dish (enter the number): ");
        // TODO: make it possible for multiple items to be chosen
        String orderedDishIndex = sc.next();
        Order order = new Order();
        order.addDish(orderedDishIndex);
        System.out.println("--------------");

        Waiter waiter = new Waiter("Mila", "Jovovich");

        // TODO: figure out how to assign to the order (using factory below? really?)
        Cook cook1 = new Cook("Marylin", "Manson");
        Cook cook2 = new Cook("Vanya", "Tomych");
        DishWasher dishwasher = new DishWasher("Tina", "Tinova");

        waiter.takeOrder(order);

        for (String[] orderedMenuItem: order.getDishes()) {
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
        }

        if (dishFactory != null) {
            DishBuilder dishBuilder = dishFactory.cook(orderedDishIndex);

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

            System.out.println("Information on the order: ");
            for (Cook cook : order.getResponsibleCooks()) {
                System.out.println("Responsible cook: " + cook);
            }
            System.out.println("Responsible dishwasher: " + order.getResponsibleDishwasher());
            System.out.println("Responsible waiter: " + order.getResponsibleWaiter());
        }


    }

}
