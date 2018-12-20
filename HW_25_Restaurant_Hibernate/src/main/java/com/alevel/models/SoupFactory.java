package com.alevel.models;

public class SoupFactory extends DishFactory {

    @Override
    public SoupBuilder cook(String id) {

        return new SoupBuilder(id);

    }
}
