package edu.bsu.cs;
import javafx.application.Application;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Application.launch(LibraryCatalogGUI.class, args);
        // Database manager for reading list, notifications, and bookmarks
        DatabaseManager dbManager = new DatabaseManager("books.db");
        ReadingList readingList = new ReadingList(dbManager);
        Notification notification = new Notification(dbManager);
        Bookmark bookmark = new Bookmark(dbManager);

        // Library model and controller for managing the book catalog
        LibraryModel catalog = new LibraryModel();
        LibraryController controller = new LibraryController(catalog);

        // Adding books to the catalog
        controller.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960));
        controller.addBook(new Book("1984", "George Orwell", "Dystopian", 1949));
        controller.addBook(new Book("Moby Dick", "Herman Melville", "Adventure", 1851));

        // Display total number of books in the catalog
        int totalBooks = controller.getBookCount();
        System.out.println("Total number of books in the catalog: " + totalBooks);

        // Display all books in the catalog
        List<Book> allBooks = catalog.getAllBooks();
        System.out.println("\nBooks in the catalog:");
        for (Book book : allBooks) {
            System.out.println("Title: " + book.title() + ", Author: " + book.author() +
                    ", Genre: " + book.genre() + ", Year: " + book.year());
        }

        // User management
        User user = new User("Bill Graham", "password123");
        user.addFavouriteBook(new Book("1984", "George Orwell", "Dystopian", 1949));

        // Get recommendations based on favorite books
        List<Book> recommendations = controller.getUserRecommendations(user);
        System.out.println("\nRecommended books:");
        for (Book recBook : recommendations) {
            System.out.println("Title: " + recBook.title() + ", Author: " + recBook.author());
        }

        // Adding a book to the reading list
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925);
        readingList.addBook(book1, "Classics");

        // Add a notification
        notification.addNotification(1, "2024-01-01"); // Assuming ID is 1 for the example

        // Bookmark a book
        bookmark.addBookmark(1); // Assuming ID is 1 for the example

        // Display results from the reading list and notifications
        System.out.println("Books in Classics: " + readingList.getBooksByCategory("Classics"));
        System.out.println("Notifications: " + notification.getNotifications());
        System.out.println("Bookmarks: " + bookmark.getBookmarks());
    }
}



