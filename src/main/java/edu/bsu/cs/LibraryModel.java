package edu.bsu.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryModel {
    private final List<Book> books;

    public LibraryModel() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.title().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(book -> book.author().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> searchByGenre(String genre) {
        return books.stream()
                .filter(book -> book.genre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public List<Book> searchByYear(int year) {
        return books.stream()
                .filter(book -> book.year() == year)
                .collect(Collectors.toList());
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books); // Return a copy for safety
    }

    public void addBook(String title, String author, String genre, int year) {
    }

    public List<Book> getRecommendedBooks(String selectedGenre) {
        return List.of();
    }

    public List<Book> searchBooks(String title, String author, String genre, int year) {
        return List.of();
    }
}