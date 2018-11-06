public class MainDishFactory extends DishFactory {

    @Override
    public MainDishBuilder cook(String id) {

        return new MainDishBuilder(id);

    }
}
