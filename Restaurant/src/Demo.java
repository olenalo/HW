public class Demo {

    private static DishFactory dishFactory;

    private static String SOUP_1_ID = "Soup001SoupWithFrikadelki";
    private static String SOUP_2_ID = "Soup002Borsch";
    private static String MAIN_DISH_1_ZARKOJE = "MainDish001Zarkoje";
    private static String DESSERT_1_TIRAMISU = "Dessert001Tiramisu";

    public static void main(String[] args) {

        Order order = new Order();
        order.dishesIds[0] = SOUP_1_ID;
        order.dishesIds[1] = MAIN_DISH_1_ZARKOJE;
        order.dishesIds[2] = DESSERT_1_TIRAMISU;

        for (String dishId: order.dishesIds) {
            if (dishId != null) {
                if (dishId == SOUP_1_ID) { // TODO replace with adequate comparisons
                    dishFactory = new SoupFactory();
                } else if (dishId == MAIN_DISH_1_ZARKOJE) {
                    dishFactory = new MainDishFactory();
                } else if (dishId == DESSERT_1_TIRAMISU) {
                    dishFactory = new DessertFactory();
                } // TODO else throw an exception

                Dish dish = dishFactory.cook();
                dish.serve(); // TODO serve following some logic (soup first)

            }
        }



    }

}
