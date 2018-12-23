package com.alevel.models;

public class DessertFactory extends DishFactory {

    @Override
    public DessertBuilder cook(Long id) {

        return new DessertBuilder(id);

    }
}
