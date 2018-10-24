public class SoupBuilder extends DishBuilder {

    public SoupBuilder(String id) {
        super(id);
    }

    @Override
    public Soup createDish() {
        return new Soup(this.id,
                this.title,
                this.environment,
                this.ingredients,
                this.technology,
                this.utensil,
                this.design);
    }
}
