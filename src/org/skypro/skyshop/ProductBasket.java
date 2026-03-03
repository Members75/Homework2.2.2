package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
    }

    List<Product> removeProductsByName(String name) {
        List<Product> removed = new ArrayList<>();
        var iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removed.add(product);
                iterator.remove();
            }
        }
        return removed;
    }

    void printBasket() {
        System.out.println("Содержимое корзины:");
        for (Product product : products) {
            System.out.println(" " + product.getName() + " - " + product.getPrice() + " рублей.");
        }
    }
}
