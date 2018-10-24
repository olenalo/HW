public class Soup extends Dish implements DishInterface {

    private final static String type = "Soup";

    @Override
    public String toString() {
        return type + ", " + this.title;
    }

    public Soup(String id,
                String title,
                String recipe,
                String environment,
                String ingredients,
                String utensil,
                String design) {
        super(id, title, recipe, environment, ingredients, utensil, design);
        System.out.printf("Cooking the %s!\n", this);
    }

    @Override
    public void serve() {
        System.out.printf("Serving the %s!\n", this);
    }

}
