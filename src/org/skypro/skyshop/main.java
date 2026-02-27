package org.skypro.skyshop;

public class main {
    public static void main(String[] args) {
        try {
            new SimpleProduct(null, 0);
            new SimpleProduct("Товар", -1);
            new DiscountedProduct(" ", 100, 10);
            new DiscountedProduct("Товар со скидкой", 100, 20);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при создании продукта: " + e.getMessage());
        }
        Product validProduct = new SimpleProduct("Телевизор", 1000);
        SimpleProduct validSimpleProduct = new SimpleProduct("Колонки", 500);
        DiscountedProduct validDiscountProduct = new DiscountedProduct("Голосовой ассистент", 1000, 10);
        System.out.println("Продукты созданы успешно");

        SearchEngine searchEngine = new SearchEngine(5);
        searchEngine.add(validProduct);
        searchEngine.add(validSimpleProduct);
        searchEngine.add(validDiscountProduct);

        try {
            Searchable result = searchEngine.findBestMatch("Телевизор");
            System.out.println("Наиболее подходящий объект: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка" + e.getMessage());
        }

        try {
            Searchable result = searchEngine.findBestMatch("несуществующий товар");
            System.out.println("Наиболее подходящий объект: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}


