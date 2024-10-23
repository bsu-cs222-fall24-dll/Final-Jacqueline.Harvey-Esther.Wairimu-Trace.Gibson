package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryControllerTest {
    @Test
    public void testGetBookCount() {
        LibraryModel catalog = new LibraryModel();
        LibraryController controller = new LibraryController(catalog);
        assertEquals(0, controller.getBookCount());
        controller.addBook(new Book("Clean Code", "Robert C. Martin", "Programming", 2012));
        assertEquals(1, controller.getBookCount());
    }
    @Test
    public void testGetUserRecommendations() {
        LibraryModel catalog = new LibraryModel();
        LibraryController controller = new LibraryController(catalog);
        User user = new User("Bill Graham", "password123");

        Book favoriteBook = new Book("Clean Code", "Robert C. Martin", "Programming", 2012);
        user.addFavouriteBooks(favoriteBook);
        controller.addBook(favoriteBook);
        controller.addBook(new Book("The Clean Coder", "Robert C. Martin", "Programming", 2011));
        assertTrue(controller.getUserRecommendations(user).stream()
                .anyMatch(book -> book.title().equals("The Clean Coder")));
    }
}
