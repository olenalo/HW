package com.alevel.models;

public class SoupFactory extends DishFactory {

    @Override
    public SoupBuilder cook(Long id) {

        return new SoupBuilder(id);

    }
}
