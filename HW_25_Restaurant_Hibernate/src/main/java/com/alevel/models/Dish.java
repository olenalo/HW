package com.alevel.models;

import com.alevel.constants.DishType;

import javax.persistence.*;

@Entity
@Table(name = "dishes")
public class Dish implements DishInterface {

    private DishType type;
    private Long id;
    private String menuId;  // TODO get rid of it
    private String title;
    private String environment; // e.g. stove of proper temperature
    private String ingredients;
    private String technology;
    private String utensil;  // utensil preparation to serve the order
    private String design;

    public Dish(
            Long id,
            String menuId,
            String title,
            String environment,
            String ingredients,
            String technology,
            String utensil,
            String design) {
        this.id = id;
        this.menuId = menuId;
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

    @Column(name = "id")
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "environment")
    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Column(name = "ingredients")
    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Column(name = "technology")
    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Column(name = "utensil")
    public String getUtensil() {
        return utensil;
    }

    public void setUtensil(String utensil) {
        this.utensil = utensil;
    }

    @Column(name = "design")
    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    @Column(name = "type")
    public String getType() {
        String type = null;
        switch (this.type) {
            case MAIN_DISH:
                type = "Main Dish";
                break;
            case DESSERT:
                type = "Dessert";
                break;
            case SOUP:
                type = "Soup";
                break;
        }
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
