package org.skypro.skyshop;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
 class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        Product simple = new SimpleProduct("Обычный товар", 34000);
        Product discounted = new DiscountedProduct("Товар со скидкой", 56400, 30);
        Product fixPrice = new FIxPriceProduct("Фиксировананя цена");

        basket.addProduct(simple);
        basket.addProduct(discounted);
        basket.addProduct(fixPrice);

        basket.printBasketContents();

    }
}