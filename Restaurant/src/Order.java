public class Order {

    public static int MAX_DISHES_NUMBER = 10;
    public static int ORDERED_DISH_DESCRIPTORS_NUMBER = 3; // index, title, and type
    public String[][] dishes; // TODO make it private

    public Order() {
        this.dishes = new String[MAX_DISHES_NUMBER][ORDERED_DISH_DESCRIPTORS_NUMBER];
    }

}
