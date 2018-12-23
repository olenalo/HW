package com.alevel.models;

public class MainDishFactory extends DishFactory {

    @Override
    public MainDishBuilder cook(Long id) {

        return new MainDishBuilder(id);

    }
}
