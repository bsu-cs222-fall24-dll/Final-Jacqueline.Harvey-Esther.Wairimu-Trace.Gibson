package edu.bsu.cs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReadingListTest {

    @Test
    public void addBookToReadingList() {
        DatabaseManager dbManager = new DatabaseManager("test.db");
        ReadingList readingList = new ReadingList(dbManager);
        readingList.addBook(new Book("Life in the Spirit", "A.W Tozer", "Religious Text", 2009), "Classics");
        assertEquals(1, readingList.getBooksByCategory("Classics").size());
    }
}
