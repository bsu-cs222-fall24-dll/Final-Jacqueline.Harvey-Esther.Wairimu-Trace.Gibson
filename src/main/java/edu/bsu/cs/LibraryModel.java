package edu.bsu.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryModel {
    private final List<Book> books;

    public LibraryModel() {
        this.books = new ArrayList<>();
    }//method to add book to the catalog
    public void addBook(Book book) {
        books.add(book);
    }
    public List<Book> searchByTitle(String title) {
        return books.stream() //It creates a sequence of books to work with
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
    public List<Book> searchByAuthor(String author) {
       return books.stream()
            .filter(book -> book.getAuthor().equalsIgnoreCase(author))
            .collect(Collectors.toList());
    }
    public List<Book> searchByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }
    public List<Book> searchByYear(int year) {
        return books.stream()
                .filter(book -> book.getYear() == year)
                .collect(Collectors.toList());
    }

    public List<Book> getAllBooks() {
        return books;
    }
}