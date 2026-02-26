package org.skypro.skyshop;

class SearchEngine {
    private final Searchable[] searchableItems;
    private int count = 0;

    SearchEngine(int capacity) {
        this.searchableItems = new Searchable[capacity];
    }

    void add(Searchable item) {
        if (count < searchableItems.length) {
            searchableItems[count] = item;
            count++;
        } else {
            System.out.println("Невозможно добавить элемент: массив переполнен");
        }
    }

    Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            Searchable item = searchableItems[i];
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[resultCount] = item;
                resultCount++;
                if (resultCount == 5) {
                    break;
                }
            }
        }
        return results;
    }
}
