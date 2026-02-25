package org.skypro.skyshop;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int size = 0;

    public void addProduct(Product product) {
        if (size >= products.length) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products[size] = product;
        size++;
    }

    public int getTotalCost() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += products[i].getCost();
        }
        return total;
    }

    public void printBasketContents() {
        if (size == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            System.out.println(product.getName() + ": " + product.getCost());
        }
        System.out.println("Итого: " + getTotalCost());
    }

    public boolean containsProduct(String name) {
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        System.out.println("Очистка корзины. size до: " + size);
        for (int i = 0; i < size; i++) {
            products[i] = null;
        }
        size = 0;
        System.out.println(" Очистка корзины. size после: " + size);
    }
}
