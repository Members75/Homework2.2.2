package org.skypro.skyshop;

public class SearchEngine {
    private final Searchable[] searchableItems;
    private int count = 0;

    SearchEngine(int capacity) {
        this.searchableItems = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (item == null) {
            System.out.println("Нельзя добавлять null - элемент в поисковую строку");
            return;
        }
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

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Поисковая строка не может быть null или пустой");
        }

        Searchable bestMatch = null;
        int maxOccurrences = 0;
        for (Searchable item : searchableItems) {
            String searchTerm = item.getSearchTerm().toLowerCase();
            String searchLower = search.toLowerCase();

            int occurrences = 0;
            int index = 0;
            while ((index = searchTerm.indexOf((searchLower), index)) != -1) {
                occurrences++;
                index += searchLower.length();
            }
            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = item;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено совпадений для поискового запроса: " + search);
        }
        return bestMatch;
    }

}
