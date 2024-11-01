package edu.bsu.cs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadingList {
    private final DatabaseManager dbManager;
    private final Map<String, List<Book>> categories;

    public ReadingList(DatabaseManager dbManager) {
        this.dbManager = dbManager;
        this.categories = new HashMap<>();
    }

    public void addBook(Book book, String category) {
        dbManager.addBook(book);
        categories.computeIfAbsent(category, k -> new ArrayList<>()).add(book);
    }

    public List<Book> getBooksByCategory(String category) {
        return categories.getOrDefault(category, new ArrayList<>());
    }
}
