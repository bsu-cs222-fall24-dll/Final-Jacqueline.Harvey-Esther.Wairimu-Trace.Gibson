package edu.bsu.cs;

import java.util.ArrayList;
import java.util.List;

public class LibraryModel {
    private List<Book> books;

    public LibraryModel() {
        // Sample books added to the catalog
        books = new ArrayList<>();
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925));
        books.add(new Book("1984", "George Orwell", "Dystopian", 1949));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960));
    }

    public List<Book> searchBooks(String query, String author, String genre, String year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            // Convert the year to a string
            String yearStr = String.valueOf(book.getYear());

            // Search by title, author, genre, or year based on input
            boolean matches = (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                    book.getGenre().toLowerCase().contains(query.toLowerCase()) ||
                    yearStr.contains(year));  // Compare year as a String

            // Check if any specific filters (author, genre, year) match
            if (!author.isEmpty() && !book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                continue;
            }
            if (!genre.isEmpty() && !book.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                continue;
            }
            if (!year.isEmpty() && !yearStr.contains(year)) {  // Compare year as a String
                continue;
            }

            // If a match is found, add the book to the result list
            if (matches) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to get all books in the catalog
    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
    }
}
