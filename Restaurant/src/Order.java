import java.util.ArrayList;
import java.util.List;

public class Order {

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

    public List<Cook> getResponsibleCooks() {
        return responsibleCooks;
    }

    public void addResponsibleCook(Cook cook) {
        if (!this.responsibleCooks.contains(cook)) {
            this.responsibleCooks.add(cook);
        }
    }
}
