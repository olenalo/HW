import java.util.ArrayList;
import java.util.List;

public class Order {

    public static final int MAX_DISHES_NUMBER = 5;
    private List<String[]> dishes;
    private List<Cook> responsibleCooks;
    private Waiter responsibleWaiter;
    private DishWasher responsibleDishwasher;

    public Order() {
        this.dishes = new ArrayList<>();
        this.responsibleCooks = new ArrayList<>();
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

    public List<String[]> getDishes() {
        return dishes;
    }

    public void addDish(String dishIndex) {
        for (Menu dish: Menu.values()) {
            if (dishIndex.equals(dish.dishDescriptors[0]) && this.dishes.size() <= MAX_DISHES_NUMBER){
                this.dishes.add(new String[]{dish.dishDescriptors[0], dish.dishDescriptors[1], dish.dishDescriptors[2]});
                System.out.printf("You ordered '%s', thank you!\n", dish.dishDescriptors[1]);
            }
        }
    }

    public List<Cook> getResponsibleCooks() {
        return responsibleCooks;
    }

    public void addResponsibleCook(Cook cook) {
        if (!this.responsibleCooks.contains(cook)) {
            this.responsibleCooks.add(cook);
        }
    }
}
