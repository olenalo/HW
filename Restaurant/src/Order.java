public class Order {

    public static int MAX_DISHES_NUMBER = 10;
    public static int ORDERED_DISH_DESCRIPTORS_NUMBER = 3; // index, title, and type

    public String[][] dishes;

    private Waiter responsibleWaiter;
    private DishWasher responsibleDishwasher;
    private Cook responsibleCook;

    public Order() {
        this.dishes = new String[MAX_DISHES_NUMBER][ORDERED_DISH_DESCRIPTORS_NUMBER];
    }

    public Waiter getResponsibleWaiter() {
        return this.responsibleWaiter;
    }

    public void setResponsibleWaiter(Waiter responsibleWaiter) {
        this.responsibleWaiter = responsibleWaiter;
    }

    public DishWasher getResponsibleDishwasher() {
        return this.responsibleDishwasher;
    }

    public void setResponsibleDishwasher(DishWasher responsibleDishwasher) {
        this.responsibleDishwasher = responsibleDishwasher;
    }

    public Cook getResponsibleCook() {
        return this.responsibleCook;
    }

    public void setResponsibleCook(Cook responsibleCook) {
        this.responsibleCook = responsibleCook;
    }
}
