package com.alevel.models;

import com.alevel.constants.DishType;

public class Soup extends Dish {

    @Override
    public String toString() {
        return this.getType() + ", " + this.getTitle();
    }

    public Soup(Long id,
                String menuId,
                String title,
                String recipe,
                String environment,
                String ingredients,
                String utensil,
                String design) {
        super(id, menuId, title, recipe, environment, ingredients, utensil, design);
        this.setType(DishType.SOUP);
        System.out.printf("Cooking the %s!\n", this);
    }

}
