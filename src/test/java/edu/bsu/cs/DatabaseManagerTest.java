package edu.bsu.cs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseManagerTest {

    @Test
    public void addBookIncreasesBookCount() {
        DatabaseManager dbManager = new DatabaseManager("test.db");
        dbManager.addBook(new Book("1984", "George Orwell", "Dystopian", 1949));
        assertNotEquals(1, dbManager.getAllBooks().size());
    }
}
