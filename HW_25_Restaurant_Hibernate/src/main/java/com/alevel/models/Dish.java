package com.alevel.models;

public class Dish implements DishInterface {

    public String id;
    public String title;
    public String environment; // e.g. stove of proper temperature
    public String ingredients;
    public String technology;
    public String utensil;  // utensil preparation to serve the order
    public String design;

    public Dish(
            String id,
            String title,
            String environment,
            String ingredients,
            String technology,
            String utensil,
            String design) {
        this.id = id;
        this.title = title;
        this.environment = environment;
        this.ingredients = ingredients;
        this.technology = technology;
        this.utensil = utensil;
        this.design = design;
    }

    @Override
    public void serve(Waiter waiter) {
        System.out.printf(waiter + ", is serving the %s!\n", this);
    }

}
