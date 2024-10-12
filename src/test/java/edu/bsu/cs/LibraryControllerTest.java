package edu.bsu.cs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryControllerTest {
    @Test
    public void testAddBook() {
        LibraryModel catalog = new LibraryModel();
        LibraryController controller = new LibraryController(catalog);
        Book book = new Book("Clean Code", "Robert C. Martin", "Programming", 2012);
        controller.addBook(book);
        assertEquals(1, controller.getBookCount());  // Check if the book count is correct
        assertTrue(controller.searchByTitle("Clean Code").contains(book));  // Check if the book is found by title
    }

}
