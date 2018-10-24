public class Demo {

    private static DishFactory dishFactory;

    // TODO: move to `Menu` and `Reference`
    private static String SOUP_1_ID = "Soup001";
    private static String SOUP_2_ID = "Soup002";
    private static String MAIN_DISH_1_ZARKOJE = "MainDish001";
    private static String DESSERT_1_TIRAMISU = "Dessert001";

    private static String SOUP_1_TITLE = "Soup with Frikadelki";
    private static String SOUP_2_TITLE = "Borsch";
    private static String MAIN_DISH_1_TITLE = "Zarkoje";
    private static String DESSERT_1_TITLE = "Tiramisu";

    // TODO: move to `Reference`
    private static String ENVIRONMENT = "Setting up the environment, heating the stove...";
    private static String INGREDIENTS = "Preparing the ingredients, washing and slicing them...";
    private static String TECHNOLOGY = "Preparing the dish with respect to the technology..";
    private static String UTENSIL = "Putting the dish to plates, serving other utensil...";
    private static String DESIGN = "Working on the dish design before to serve it to a customer...";

    public static void main(String[] args) {

        Order order = new Order();
        order.dishesIds[0] = SOUP_1_ID;
        order.dishesIds[1] = MAIN_DISH_1_ZARKOJE;
        order.dishesIds[2] = DESSERT_1_TIRAMISU;

        for (String dishId: order.dishesIds) {
            if (dishId != null) {
                System.out.println("--------------------------------");
                if (dishId == SOUP_1_ID) { // TODO replace with adequate comparisons, here and below
                    dishFactory = new SoupFactory();
                } else if (dishId == MAIN_DISH_1_ZARKOJE) {
                    dishFactory = new MainDishFactory();
                } else if (dishId == DESSERT_1_TIRAMISU) {
                    dishFactory = new DessertFactory();
                } // TODO else throw an exception

                DishBuilder dishBuilder = dishFactory.cook(dishId);

                dishBuilder.environment(ENVIRONMENT);  // TODO made by cook1
                dishBuilder.ingredients(INGREDIENTS);  // TODO made by cook1
                dishBuilder.technology(TECHNOLOGY);  // TODO made by cook2
                dishBuilder.utensil(UTENSIL);  // TODO made by dishwasher1
                dishBuilder.design(DESIGN);  // TODO made by cook2
                Dish dish = dishBuilder.createDish();

                 // TODO serve following some logic (soup first)
                if (dishId == SOUP_1_ID) { // TODO replace with adequate comparisons
                    ((Soup)dish).serve(); // TODO handle `ClassCastException`
                } else if (dishId == MAIN_DISH_1_ZARKOJE) {
                    ((MainDish)dish).serve(); // TODO handle `ClassCastException`
                } else if (dishId == DESSERT_1_TIRAMISU) {
                    ((Dessert)dish).serve(); // TODO handle `ClassCastException`
                } // TODO else throw an exception

            }
        }



    }

}
