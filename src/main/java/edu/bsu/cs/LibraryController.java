package edu.bsu.cs;

import java.util.List;

public class LibraryController {
    private final LibraryModel catalog;
    private int bookCount = 0;

    public LibraryController(LibraryModel catalog) {
        this.catalog = catalog;
    }
    public void addBook(Book book) {
        catalog.addBook(book);
        bookCount++;
    }
     public int getBookCount() {
        return bookCount;
    }
    public List<Book> getUserRecommendations(User user) {
        return user.getRecommendations(catalog);
    }

}