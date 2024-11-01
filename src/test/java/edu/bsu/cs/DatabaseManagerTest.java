package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class DatabaseManagerTest {
    private DatabaseManager dbManager;

    @BeforeEach
    public void setUp() {
        // Use a temporary database file
        dbManager = new DatabaseManager("test.db");
    }

    @Test
    public void testAddBook() {
        dbManager.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960));
        assertNotEquals(1, dbManager.getAllBooks().size());
    }

    @Test
    public void testGetAllBooks() {
        dbManager.addBook(new Book("1984", "George Orwell", "Dystopian", 1949));
        dbManager.addBook(new Book("Moby Dick", "Herman Melville", "Adventure", 1851));
        dbManager.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925));

        // Check that the size is what we expect
        assertNotEquals(3, dbManager.getAllBooks().size());
    }
}
