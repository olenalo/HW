package com.alevel.constants;

public enum Menu {

    // TODO: come up with a better data structure here
    // Order: menu id, title, dish type

    SOUP_FRIKADELKI(new String[]{"1", "Soup with Frikadelki", "Soup"}),
    BORSCH(new String[]{"2", "Borsch", "Soup"}),
    ZARKOJE(new String[]{"3", "Zarkoje", "MainDish"}),
    TIRAMISU(new String[]{"4", "Tiramisu", "Dessert"});

    private String[] dishDescriptors;

    Menu(String[] dishTypes) {
        this.dishDescriptors = dishTypes;
    }

    public String[] getDishDescriptors() {
        return dishDescriptors;
    }
}
