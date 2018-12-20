package com.alevel.models;

public class Waiter extends Employee {

    public static final String position = "Waiter/Waitress";

    public Waiter(String name, String surname) {
        super(name, surname);
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getSurname() + ", the " + position;
    }

    public void takeOrder(Order order) {
        order.addResponsibleWaiter(this);
    }

    public void serveDish(Order order, Dish dish) {
        // TODO: do something with Order (e.g. assign dish status "Served")
        dish.serve(this);
    }

}
