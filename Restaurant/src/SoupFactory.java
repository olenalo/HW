public class SoupFactory extends DishFactory {

    @Override
    public Dish cook() {

        return new Soup();

    }
}
