public class Order {

    public static int MAX_DISHES_NUMBER = 10;

    public String[] dishesIds; // TODO make it private

    public Order() {
        this.dishesIds = new String[MAX_DISHES_NUMBER];
    }

}
