package com.alevel.models;

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

    public DishBuilder ingredients(String ingredients, Order order, Cook cook) {
        System.out.println("Preparing ingredients specific to " + this.title);
        System.out.println("Preparing meat");
        return super.ingredients(ingredients, order, cook );
    }

    public DishBuilder technology(String technology, Order order, Cook cook) {
        System.out.println("Following the recipe of " + this.title);
        System.out.println("Cooking meat");
        return super.technology(ingredients, order, cook );
    }

}
