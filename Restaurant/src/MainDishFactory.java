public class MainDishFactory extends DishFactory {

    @Override
    public Dish cook() {

        return new MainDish();

    }
}
