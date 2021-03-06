public class MainDish extends Dish {

    private final static String type = "Main Dish";

    @Override
    public String toString() {
        return type + ", " + this.title;
    }

    public MainDish(String id,
                String title,
                String recipe,
                String environment,
                String ingredients,
                String utensil,
                String design) {
        super(id, title, recipe, environment, ingredients, utensil, design);
        System.out.printf("Cooking the %s!\n", this);
    }

}
