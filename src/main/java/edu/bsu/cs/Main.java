package edu.bsu.cs;

import java.util.List;

public class Main {
    public static void main(String[] args){
        LibraryModel catalog = new LibraryModel();
        LibraryController controller = new LibraryController(catalog);

        controller.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960));
        controller.addBook(new Book("1984", "George Orwell", "Dystopian", 1949));
        controller.addBook(new Book("Moby Dick", "Herman Melville", "Adventure", 1851));

        int totalBooks = controller.getBookCount();
        System.out.println("Total number of books in the catalog: " + totalBooks);

        List<Book> allBooks = catalog.getAllBooks();
        System.out.println("\nBooks in the catalog:");
        for (Book book : allBooks) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", Genre: " + book.getGenre() + ", Year: " + book.getYear());
        }
        User user = new User("Bill Graham", "password123");
        user.addfavouriteBooks(new Book("1984", "George Orwell", "Dystopian", 1949));

        // Get recommendations based on favorite books
        List<Book> recommendations = controller.getUserRecommendations(user);
        System.out.println("\nRecommended books:");
        for (Book recBook : recommendations) {
            System.out.println("Title: " + recBook.getTitle() + ", Author: " + recBook.getAuthor());
        }
    }
}