package com.alevel.models;

public abstract class DishFactory {

    public abstract DishBuilder cook(String id);

}