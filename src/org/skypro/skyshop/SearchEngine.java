package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> searchableItems = new ArrayList<>();

    SearchEngine() {

    }

    void add(Searchable item) {
        if (item == null) {
            System.out.println("Ошибка: нельзя добавлять null - элемент в поисковую строку.");
            return;
        }
        searchableItems.add(item);
    }

    public Map<String, Searchable> search(String query) {
        if (query == null) {
            throw new IllegalArgumentException("Поисковой запрос не может быть null");
        }
        Map<String, Searchable> results = new TreeMap<>();
        for (Searchable item : searchableItems) {
            if (item == null) continue;

            String searchTerm = item.getSearchTerm().toLowerCase();
            String queryLower = query.toLowerCase();

            if (searchTerm.contains(queryLower))
                results.put(item.getSearchTerm(), item);
        }
        return results;
    }

    Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Поисковая строка не может быть null или пустой.");
        }
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable item : searchableItems) {
            if (item == null) continue;

            String searchTerm = item.getSearchTerm().toLowerCase();
            String searchLower = search.toLowerCase();

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
}
