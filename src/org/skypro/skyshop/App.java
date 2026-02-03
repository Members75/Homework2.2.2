package org.skypro.skyshop;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        Product notebook = new Product("Ноутбук", 34000);
        Product fridge = new Product("Холодильник", 56400);
        Product hairDryer = new Product("Фен", 5600);
        Product phone = new Product("Смартфон", 34000);
        Product tv = new Product("Телевизор", 89000);

        System.out.println("1. Добавление продуктов в корзину: ");
        basket.addProduct(notebook);
        basket.addProduct(fridge);
        basket.addProduct(hairDryer);
        basket.addProduct(phone);
        basket.addProduct(notebook);
        System.out.println("\n2. Попытка добавление лишнего: ");
        basket.addProduct(tv);
        System.out.println("\n3. Печать содержимого в корзине: ");
        basket.printBasketContents();
        System.out.println("\n4. Получение стоимости корзины: ");
        int totalCost = basket.getTotalCost();
        System.out.println("Общая стоимость: " + totalCost);
        System.out.println("\n5. Поиск товара в корзине: ");
        boolean hasPhone = basket.containsProduct("Смартфон");
        System.out.println("Есть ли сматрфон в корзине? + " + hasPhone);
        System.out.println("\n6. Поиск отсутствующего товара: ");
        boolean hasTv = basket.containsProduct("Телевизор");
        System.out.println("Есть ли телевизор в корзине? + " + hasTv);
        System.out.println("\n7. Очистка корзины: ");
        basket.clearBasket();
        System.out.println("\n8. Печать содержимого пустой корзины: ");
        basket.printBasketContents();
        System.out.println("\n9. Стоимость пустой корзины: " + totalCost);
        System.out.println("\n10. Поиск в пустой корзине: ");
        boolean hasFridge = basket.containsProduct("Холодильник");
        System.out.println("Есть ли холодильник в корзине? + " + hasFridge);
    }
}