import java.util.Scanner;

public class Demo {

    private static DishFactory dishFactory;

    public static void main(String[] args) {
        System.out.println("The menu:");
        for (Menu dish: Menu.values()) {
            System.out.printf("Dish #%s: %s\n", dish.dishDescriptors[1], dish.dishDescriptors[2]);
        }
        System.out.println("--------------------------------");

        Scanner sc = new Scanner(System.in);
        System.out.println("Please select the dish (enter the number): ");
        // TODO: make it possible for multiple items to be chosen
        String orderedDishIndex = sc.next();

        if (orderedDishIndex.equals("1") || orderedDishIndex.equals("2")) {
            dishFactory = new SoupFactory();
        } else if (orderedDishIndex.equals("3")) {
            dishFactory = new MainDishFactory();

        } else if (orderedDishIndex.equals("4")) {
            dishFactory = new DessertFactory();
        }  // TODO else throw an exception
        DishBuilder dishBuilder = dishFactory.cook(orderedDishIndex);

        dishBuilder
                .environment(DishPreparationStep.valueOf("ENVIRONMENT").description)   // TODO made by cook1
                .ingredients(DishPreparationStep.valueOf("INGREDIENTS").description)   // TODO made by cook1
                .technology(DishPreparationStep.valueOf("TECHNOLOGY").description)     // TODO made by cook2
                .utensil(DishPreparationStep.valueOf("UTENSIL").description)           // TODO made by dishwasher1
                .design(DishPreparationStep.valueOf("DESIGN").description);            // TODO made by cook2
        System.out.println("--------------");
        Dish dish = dishBuilder.createDish();
        if (orderedDishIndex.equals("1") || orderedDishIndex.equals("2")) {
            ((Soup)dish).serve();
        } else if (orderedDishIndex.equals("3")) {
            ((MainDish)dish).serve();
        } else if (orderedDishIndex.equals("4")) {
            ((Dessert)dish).serve();
        }

        // FIXME: define concrete factories by type; use `Order`
        /*
        Order order = new Order();
        // TODO: check max number of dishes per order isn't exceeded
        int i = 0;
        for (Menu dish: Menu.values()) {
            if (orderedDishIndex.equals(dish.dishDescriptors[0])){
                order.dishes[i] = new String[]{dish.dishDescriptors[0], dish.dishDescriptors[1], dish.dishDescriptors[2]};
                System.out.printf("You ordered '%s', thank you!\n", dish.dishDescriptors[2]);
            }
        }

        for (String[] orderedMenuItem: order.dishes) {
            if (orderedMenuItem != null) {
                System.out.println("--------------------------------");
                switch (orderedMenuItem[2]) {
                    case "Soup":
                        dishFactory = new SoupFactory();
                    case "MainDish":
                        dishFactory = new MainDishFactory();
                    case "Dessert":
                        dishFactory = new DessertFactory();
                }

                DishBuilder dishBuilder = dishFactory.cook(orderedMenuItem[1]);

                dishBuilder
                        .environment(ENVIRONMENT)
                        .ingredients(INGREDIENTS)
                        .technology(TECHNOLOGY)
                        .utensil(UTENSIL)
                        .design(DESIGN);
                System.out.println("--------------");
                Dish dish = dishBuilder.createDish();

                switch (orderedMenuItem[2]) {
                    case "Soup":
                        ((Soup)dish).serve();
                    case "MainDish":
                        ((MainDish)dish).serve();
                    case "Dessert":
                        ((Dessert)dish).serve();
                }

            }
        }
        */

    }

}
