package com.alevel.models;

import com.alevel.constants.DishType;

public class Dessert extends Dish {

    @Override
    public String toString() {
        return this.getType() + ", " + this.getTitle();
    }

    public Dessert(Long id,
                   String menuId,
                   String title,
                   String recipe,
                   String environment,
                   String ingredients,
                   String utensil,
                   String design) {
        super(id, menuId, title, recipe, environment, ingredients, utensil, design);
        this.setType(DishType.DESSERT);
        System.out.printf("Cooking the %s!\n", this);
    }

}
