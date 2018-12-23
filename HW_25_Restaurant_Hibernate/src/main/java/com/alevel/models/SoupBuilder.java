package com.alevel.models;

public class SoupBuilder extends DishBuilder {

    public SoupBuilder(Long id) {
        super(id);
    }

    @Override
    public Soup createDish() {
        return new Soup(
                this.id,
                this.menuId,
                this.title,
                this.environment,
                this.ingredients,
                this.technology,
                this.utensil,
                this.design);
    }

    public DishBuilder ingredients(String ingredients, Order order, Cook cook) {
        System.out.println("Preparing ingredients specific to " + this.title);
        System.out.println("Preparing vegetables");
        return super.ingredients(ingredients, order, cook);
    }

    public DishBuilder technology(String technology, Order order, Cook cook) {
        System.out.println("Following the recipe of " + this.title);
        System.out.println("Cooking vegetables");
        System.out.println("Cooking meat");
        return super.technology(ingredients, order, cook);
    }
}
