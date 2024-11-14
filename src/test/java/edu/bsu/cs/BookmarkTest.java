package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookmarkTest {

    @Test
    public void testGetBookmarksEmpty() {
        DatabaseManager dbManager = new DatabaseManager("test.db");
        Bookmark bookmark = new Bookmark(dbManager);
        assertFalse(bookmark.getBookmarks().isEmpty());
    }
    @Test
    public void testGetBookmarks(){
        Book one = new Book("Fahrenheit 451","Ray Bradbury","Novel",1951);
        Assertions.assertNotEquals(null,one);
    }
}
