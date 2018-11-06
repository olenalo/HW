public class DessertFactory extends DishFactory {

    @Override
    public DessertBuilder cook(String id) {

        return new DessertBuilder(id);

    }
}
