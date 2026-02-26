package org.skypro.skyshop;

abstract class Product implements Searchable {
    private String name;
    public int cost;

    abstract boolean isSpecial();

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract int getPrice();

    @Override
    public String getSearchTerm() {
        return getName();
    }
    @Override
    public String getContentType() {
        return "PRODUCT";
    }
    }

