package org.skypro.skyshop;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class main {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        Product product1 = new SimpleProduct("Компьютер", 87400);
        Product product2 = new SimpleProduct("Клавиатура", 3500);
        Product product3 = new SimpleProduct("Игровое кресло", 12300);
        Product product4 = new SimpleProduct("Мышь", 2700);

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);

        System.out.println("---- Изначально содержимое корзины ----");
        basket.printBasket();

        System.out.println("\n---- Удаляем продукт 'Клавиатура' ----");
        List<Product> removedProducts = basket.removeProductsByName("Клавиатура");

        System.out.println("Удаленные продукты: ");
        for (Product product : removedProducts) {
            System.out.println("- " + product.getName());
        }
        System.out.println("\n---- Содержимое корзины после удаления ----");
        basket.printBasket();

        System.out.println("\n---- Пытаемся удалить несуществующий продукт 'Системный блок' ----");
        List<Product> emptyRemoved = basket.removeProductsByName("Системный блок");

        if (emptyRemoved.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удалено продуктов: " + emptyRemoved.size());
        }
        System.out.println("\n---- Последнее содержимое корзины ----");
        basket.printBasket();

        System.out.println("\n---- Поиск в SearchEngine ----");
        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);

        try {
            Searchable best = searchEngine.findBestMatch("Компьютер");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
        Map<String, Searchable> allResults = searchEngine.search("игровое кресло");
        System.out.println("Все результаты поиска по 'игровое кресло' (отсортировано по имени): ");
        for (Map.Entry<String, Searchable> entry : allResults.entrySet()) {
            System.out.println("- " + entry.getKey() + ":" + entry.getValue().getStringRepresentation());
        }
    }
}


