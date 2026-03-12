package org.skypro.skyshop;

import java.util.Objects;

abstract class Product implements Searchable {
    protected String name;
    protected int cost;

    abstract boolean isSpecial();

     Product(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть null или пустой строкой, а также пустыми пробелами");
        }
        this.name = name;
    }

    @Override
     public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(name, product.name);
    }

    @Override
     public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
     public String getName() {
        return name;
    }

    abstract  int getPrice();

    @Override
     public String getSearchTerm() {
        return getName();
    }

    @Override
     public String getContentType() {
        return "PRODUCT";
    }
}