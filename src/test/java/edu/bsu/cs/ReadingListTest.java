package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ReadingListTest {
    DatabaseManager dbManager;
    private ReadingList readingList;

    @BeforeEach
    public void setUp() {
        dbManager = new DatabaseManager("test.db");
        readingList = new ReadingList(dbManager);
    }

    @Test
    public void testAddBook() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925);
        readingList.addBook(book, "Classics");
        List<Book> classics = readingList.getBooksByCategory("Classics");
        assertEquals(1, classics.size());
        assertEquals(book, classics.get(0));
    }
}
