package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseManagerTest {

    @Test
    void testAddAndRetrieveBook() {
        DatabaseManager dbManager = new DatabaseManager("test_books.db");
        Book book = new Book("Test Title", "Test Author", "Test Genre", 2023);

        dbManager.addBook(book);
        List<Book> books = dbManager.getAllBooks();

        assertTrue(books.contains(book), "Book should be added and retrievable from database");
    }

    @Test
    void testAddAndRetrieveBookmark() {
        DatabaseManager dbManager = new DatabaseManager("test_books.db");
        int bookId = 1;

        dbManager.addBookmark(bookId);
        List<Integer> bookmarks = dbManager.getBookmarks();

        assertTrue(bookmarks.contains(bookId), "Bookmark should be added and retrievable from database");
    }

    @Test
    void testAddAndRetrieveNotification() {
        DatabaseManager dbManager = new DatabaseManager("test_books.db");
        int bookId = 1;
        String releaseDate = "2024-01-01";

        dbManager.addNotification(bookId, releaseDate);
        List<String> notifications = dbManager.getNotifications();

        assertTrue(notifications.contains(releaseDate), "Notification should be added and retrievable from database");
    }
}
