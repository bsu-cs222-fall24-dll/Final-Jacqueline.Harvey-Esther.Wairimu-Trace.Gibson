package edu.bsu.cs;

import java.util.List;

// This class focuses on how the data is manipulated and stored
public class LibraryController {
    private final LibraryModel catalog;
    private int bookCount = 0;

    // Constructor that takes catalog (LibraryModel) as input
    public LibraryController(LibraryModel catalog) {
        this.catalog = catalog;
    }

    // Method to add a book to the catalog
    public void addBook(Book book) {
        catalog.addBook(book);  // Delegate the call to LibraryCatalog
        bookCount++;
    }
    // Methods to handle searching for books by title, author, genre, and year
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
    // Method to get the number of books in the catalog
    public int getBookCount() {
        return bookCount;
    }
    public List<Book> getUserRecommendations(User user) {
        return user.getRecommendations(catalog);
    }

}
