package edu.bsu.cs;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class UserTest {
    @Test
    void testGetUserName() {
        User user = new User("testUser", "password123");
        assertEquals("testUser", user.getUserName());
    }

    @Test
    void testGetPassword() {
        User user = new User("testUser", "password123");
        assertEquals("password123", user.getPassword());
    }

    @Test
    void testAddFavouriteBook() {
        User user = new User("testUser", "password123");
        Book book1 = new Book("Book One", "Author One", "Fiction", 2023); // Add the fourth parameter here
        user.addFavouriteBook(book1);
        List<Book> favouriteBooks = user.getFavouriteBooks();
        assertTrue(favouriteBooks.contains(book1));
    }

    @Test
    void testContinueReading() {
        User user = new User("testUser", "password123");
        Book book2 = new Book("Book Two", "Author Two", "Mystery", 2023);
        user.continueReading(book2);
        List<Book> continueReading = user.getContinueReading();
        assertTrue(continueReading.contains(book2));
    }

    @Test
    void testAddRecommendedBooks() {
        User user = new User("testUser", "password123");
        Book book1 = new Book("Book One", "Author One", "Fiction", 2023);
        user.addRecommendedBooks(book1);
        List<Book> recommendedBooks = user.getRecommendedBooks();
        assertTrue(recommendedBooks.contains(book1));
    }

    @Test
    void testGetRecommendations() {
        User user = new User("testUser", "password123");
        LibraryModel catalog = new LibraryModel();
        Book book1 = new Book("Book One", "Author One", "Fiction", 2023); 
        catalog.addBook(book1);
        user.addFavouriteBook(book1);
        List<Book> recommendations = user.getRecommendations(catalog);
        assertTrue(recommendations.contains(book1));
        assertEquals(1, recommendations.size());
    }
}