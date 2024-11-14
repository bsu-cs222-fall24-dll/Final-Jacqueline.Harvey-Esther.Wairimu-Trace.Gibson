package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryControllerTest {

    @Test
    public void addBookIncreasesBookCount() {
        LibraryModel catalog = new LibraryModel();
        LibraryController controller = new LibraryController(catalog);
        controller.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925));
        assertEquals(1, controller.getBookCount());
    }
    @Test
    public void testGetBookCountAfterMultipleAdds() {
        LibraryModel catalog = new LibraryModel();
        LibraryController controller = new LibraryController(catalog);
        controller.addBook(new Book("1984", "George Orwell", "Dystopian", 1949));
        controller.addBook(new Book("Brave New World", "Aldous Huxley", "Dystopian", 1932));
        assertEquals(2, controller.getBookCount(), "Book count should reflect the total number of added books");
    }
    @Test
    public void testGetUserRecommendations() {
        LibraryModel catalog = new LibraryModel();
        LibraryController controller = new LibraryController(catalog);
        User user = new User("Jane Doe", "password123");
        Book recommendedBook = new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960);
        controller.addBook(recommendedBook);
        user.addFavouriteBook(recommendedBook);
        List<Book> recommendations = controller.getUserRecommendations(user);
        assertTrue(recommendations.contains(recommendedBook), "Recommendations should include the user's favorite book");
    }
}
