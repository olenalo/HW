import java.util.ArrayList;
import java.util.List;

public class Order {

    public static final int MAX_DISHES_NUMBER = 5;
    private List<String[]> dishes;
    private List<Cook> responsibleCooks;
    private List<Waiter> responsibleWaiters;
    private List<DishWasher> responsibleDishwashers;

    public Order() {
        this.dishes = new ArrayList<>();
        this.responsibleCooks = new ArrayList<>();
        this.responsibleWaiters = new ArrayList<>();
        this.responsibleDishwashers = new ArrayList<>();
    }

    public List<Waiter> getResponsibleWaiters() {
        return this.responsibleWaiters;
    }

    public void addResponsibleWaiter(Waiter responsibleWaiter) {
        if (!this.responsibleWaiters.contains(responsibleWaiter)) {
            this.responsibleWaiters.add(responsibleWaiter);
        }
    }

    public List<DishWasher> getResponsibleDishwashers() {
        return this.responsibleDishwashers;
    }

    public void addResponsibleDishwasher(DishWasher responsibleDishwasher) {
        if (!this.responsibleDishwashers.contains(responsibleDishwasher)) {
            this.responsibleDishwashers.add(responsibleDishwasher);
        }
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
