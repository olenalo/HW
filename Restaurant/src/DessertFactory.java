public class DessertFactory extends DishFactory {

    @Override
    public Dish cook() {

        return new Dessert();

    }
}
