package org.skypro.skyshop;

import java.sql.SQLOutput;
import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap = new HashMap<>();

    void addProduct(Product product) {
        if (product == null) return;

        String name = product.getName();
        if (!productsMap.containsKey(name)) {
            productsMap.put(name, new ArrayList<>());
        }
        productsMap.get(name).add(product);
    }

    List<Product> removeProductsByName(String name) {
        List<Product> removed = productsMap.remove(name);
        if (removed == null) {
            return new ArrayList<>();
        }
        return removed;
    }

    void printBasket() {
        System.out.println("Содержимое корзины");
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                System.out.println("- " + product.getName() + "-" + product.getPrice() + " рублей.");
            }
        }
    }

    Collection<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        for (List<Product> productList : productsMap.values()) {
            allProducts.addAll(productList);
        }
        return allProducts;
    }
}