package org.skypro.skyshop;

import java.util.*;

 class SearchEngine {
    private final Set<Searchable> items = new HashSet<>();

     void add(Searchable item) {
        if (item == null) {
            System.out.println("Ошибка: нельзя добавлять null-элемент в поисковую строку.");
            return;
        }
        items.add(item);
    }

     Set<Searchable> search(String query) {
        if (query == null) {
            throw new IllegalArgumentException("Поисковой запрос не может быть null");
        }

        Set<Searchable> results = new TreeSet<>(createComparator());
        String queryLower = query.toLowerCase();

        for (Searchable item : items) {
            if (item == null) continue;

            String searchTerm = item.getSearchTerm().toLowerCase();
            if (searchTerm.contains(queryLower)) {
                results.add(item);
            }
        }
        return results;
    }

     Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Поисковая строка не может быть null или пустой.");
        }

        Searchable bestMatch = null;
        int maxOccurrences = 0;
        String searchLower = search.toLowerCase();

        for (Searchable item : items) {
            if (item == null) continue;

            String searchTerm = item.getSearchTerm().toLowerCase();

            int occurrences = 0;
            int index = 0;
            while ((index = searchTerm.indexOf(searchLower, index)) != -1) {
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

    private Comparator<Searchable> createComparator() {
        return (item1, item2) -> {
            int lengthComparison = Integer.compare(
                    item2.getName().length(),
                    item1.getName().length()
            );

            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return item1.getName().compareTo(item2.getName());
        };
    }
}