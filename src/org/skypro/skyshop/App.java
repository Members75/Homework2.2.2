package org.skypro.skyshop;

import java.util.Set;


 class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product simple = new SimpleProduct("Обычный товар", 34000);
        Product discounted = new DiscountedProduct("Товар со скидкой", 56400, 30);
        Product fixPrice = new FIxPriceProduct("Фиксировананя цена");

        basket.addProduct(simple);
        basket.addProduct(discounted);
        basket.addProduct(fixPrice);

        basket.printBasket();

        Article article1 = new Article("Обзор телевизора", "Телевизор с большой диагональю, поддежркой SmartTV и высоким разрешением.");
        Article article2 = new Article("Как выбрать смартфон", "Смартфон с высокой производительностью или профессиональной камерой.");
        Article article3 = new Article("Новинки одежды", "Показ последних вышедших брендов одежды.");

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(simple);
        searchEngine.add(discounted);
        searchEngine.add(fixPrice);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        System.out.println("=== Поиск по запросу 'товар'===");
        Set<Searchable> temp1 = searchEngine.search("товар");
        Searchable[] results1 = temp1.toArray(new Searchable[0]);
        printSearchResult(results1);

        System.out.println("=== Поиск по запросу 'телевизор'===");
        Set<Searchable> temp2 = searchEngine.search("телевизор");
        Searchable[] results2 = temp2.toArray(new Searchable[0]);
        printSearchResult(results2);

        System.out.println("=== Поиск по запросу 'новинки'===");
        Set<Searchable> temp3 = searchEngine.search("новинки");
        Searchable[] results3 = temp3.toArray(new Searchable[0]);
        printSearchResult(results3);
    }

    static void printSearchResult(Searchable[] results) {
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }
    }
}