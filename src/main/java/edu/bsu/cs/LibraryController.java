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
    public List<Book> searchByTitle(String title) {
        return catalog.searchByTitle(title);
    }
    public List<Book> searchByAuthor(String author) {
        return catalog.searchByAuthor(author);
    }
    public List<Book> searchByGenre(String genre) {
        return catalog.searchByGenre(genre);
    }
    public List<Book> searchByYear(int year) {
        return catalog.searchByYear(year);
    }

    public int getBookCount() {
        return bookCount;
    }
    public List<Book> getUserRecommendations(User user) {
        return user.getRecommendations(catalog);
    }

}