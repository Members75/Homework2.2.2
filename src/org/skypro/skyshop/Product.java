package org.skypro.skyshop;

public abstract class Product {
    private String name;
    public int cost;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice() {
        return cost;
    }
}
