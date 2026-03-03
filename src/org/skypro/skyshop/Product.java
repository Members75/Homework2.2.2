package org.skypro.skyshop;

abstract class Product implements Searchable {
    public String name;
    public int cost;

    abstract boolean isSpecial();

    public Product(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продкудта не может быть null или пустой строкой, а также пустыми пробелами");
        }
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

