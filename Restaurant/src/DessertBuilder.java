public class DessertBuilder extends DishBuilder {

    public DessertBuilder(String id) {
        super(id);
    }

    @Override
    public Dessert createDish() {
        return new Dessert(this.id,
                this.title,
                this.environment,
                this.ingredients,
                this.technology,
                this.utensil,
                this.design);
    }
}
