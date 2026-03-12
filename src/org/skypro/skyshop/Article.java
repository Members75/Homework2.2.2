package org.skypro.skyshop;

import java.util.Objects;

class Article implements Searchable {
    private final String title;
    private final String text;

     Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

     String getTitle() {
        return title;
    }

     String getText() {
        return text;
    }

    @Override
     public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Article article = (Article) obj;
        return Objects.equals(title, article.title);
    }

    @Override
     public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
     public String toString() {
        return title + "\n" + text;
    }

    @Override
     public String getSearchTerm() {
        return toString();
    }

    @Override
     public String getContentType() {
        return "ARTICLE";
    }

    @Override
     public String getName() {
        return title;
    }
}