package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryControllerTest {
    private LibraryController controller;
    LibraryModel catalog;

    @BeforeEach
    public void setUp() {
        catalog = new LibraryModel();
        controller = new LibraryController(catalog);
    }

    @Test
    public void testAddBook() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925);
        controller.addBook(book);
        assertEquals(1, controller.getBookCount());
    }
}
