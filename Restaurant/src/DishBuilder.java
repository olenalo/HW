public class DishBuilder {

    public String id;
    public String title;
    public String environment;
    public String ingredients;
    public String technology;
    public String utensil;
    public String design;

    public DishBuilder(String id) {
        this.id = id;
        this.title = "title"; // TODO: should be taken from `Reference`
    }

    public DishBuilder environment(String environment) {
        System.out.println(environment);
        this.environment = environment;
        return this;
    }

    public DishBuilder ingredients(String ingredients) {
        System.out.println(ingredients);
        this.ingredients = ingredients;
        return this;
    }

    public DishBuilder technology(String technology) {
        System.out.println(technology);
        this.technology = technology;
        return this;
    }

    public DishBuilder utensil(String utensil) {
        System.out.println(utensil);
        this.utensil = utensil;
        return this;
    }

    public DishBuilder design(String design) {
        System.out.println(design);
        this.design = design;
        return this;
    }

    public Dish createDish() {
        return new Dish(this.id,
                this.title,
                this.environment,
                this.ingredients,
                this.technology,
                this.utensil,
                this.design);
    }

}
