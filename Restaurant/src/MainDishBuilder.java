public class MainDishBuilder extends DishBuilder {

    public MainDishBuilder(String id) {
        super(id);
    }

    public MainDish createDish() {
        return new MainDish(this.id,
                this.title,
                this.environment,
                this.ingredients,
                this.technology,
                this.utensil,
                this.design);
    }
}
