package edu.bsu.cs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryControllerTest {

    @Test
    public void addBookIncreasesBookCount() {
        LibraryModel catalog = new LibraryModel();
        LibraryController controller = new LibraryController(catalog);
        controller.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925));
        assertEquals(1, controller.getBookCount());
    }
}
