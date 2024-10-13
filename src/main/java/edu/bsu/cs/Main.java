package edu.bsu.cs;

import java.util.List;

public class Main {
    public static void main(String[] args){
    LibraryModel catalog = new LibraryModel();
    LibraryController controller = new LibraryController(catalog);
    // Add sample books to the catalog
        controller.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960));
        controller.addBook(new Book("1984", "George Orwell", "Dystopian", 1949));
        controller.addBook(new Book("Moby Dick", "Herman Melville", "Adventure", 1851));
        // Get the total book count
        int totalBooks = controller.getBookCount();
        System.out.println("Total number of books in the catalog: " + totalBooks);
        // Get and print all books
        List<Book> allBooks = catalog.getAllBooks(); // Assuming you have a method to retrieve all books
        System.out.println("Books in the catalog:");
        for (Book book : allBooks) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                            ", Genre: " + book.getGenre() + ", Year: " + book.getYear());
        }
    }
}
