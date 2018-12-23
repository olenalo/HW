package com.alevel.models;

public class DessertBuilder extends DishBuilder {

    public DessertBuilder(Long id) {
        super(id);
    }

    @Override
    public Dessert createDish() {
        return new Dessert(
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
        System.out.println("Preparing the form for the dessert...");
        return super.ingredients(ingredients, order, cook);
    }

    public DishBuilder technology(String technology, Order order, Cook cook) {
        System.out.println("Following the recipe of " + this.title);
        System.out.println("Cooking the base for the dessert...");
        return super.technology(ingredients, order, cook);
    }

}
