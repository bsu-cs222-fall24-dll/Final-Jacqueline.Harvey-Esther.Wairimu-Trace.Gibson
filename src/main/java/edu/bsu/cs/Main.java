package edu.bsu.cs;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryModel libraryModel = new LibraryModel();
        User loggedInUser; // Represents the currently logged-in user

        // Simulate Account Creation
        String username = "user123";
        String password = "password"; // This is hashed in a real app
        if (libraryModel.createAccount(username, password)) {
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account creation failed (username exists).");
        }
        // Simulate Login
        loggedInUser = libraryModel.login(username, password);
        if (loggedInUser != null) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed.");
        }
        // Only allow book search and recommendations if logged in
        if (loggedInUser != null) {
            // Perform Book Search
            List<Book> booksFrom2002 = libraryModel.searchBooks(null, null, null, 2002);
            if (!booksFrom2002.isEmpty()) {
                System.out.println("Books found from 2002:");
                for (Book book : booksFrom2002) {
                    System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
                }
            } else {
                System.out.println("No books found from 2002.");
            }
            List<Book> christianLivingBooks = libraryModel.searchBooks(null, null, "Christian Living", null);
            if (!christianLivingBooks.isEmpty()) {
                System.out.println("Christian Living books found:");
                for (Book book : christianLivingBooks) {
                    System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
                }
            } else {
                System.out.println("No Christian Living books found.");
            }
            List<Book> recommendations = libraryModel.getRecommendations();
            if (!recommendations.isEmpty()) {
                System.out.println("Recommended Books:");
                for (Book book : recommendations) {
                    System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
                }
            } else {
                System.out.println("No recommendations available.");
            }
        }
    }
}
