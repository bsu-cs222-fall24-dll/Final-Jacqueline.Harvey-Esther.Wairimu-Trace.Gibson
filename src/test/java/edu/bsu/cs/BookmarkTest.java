package edu.bsu.cs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookmarkTest {

    @Test
    public void testGetBookmarksEmpty() {
        DatabaseManager dbManager = new DatabaseManager("test.db");
        Bookmark bookmark = new Bookmark(dbManager);
        assertFalse(bookmark.getBookmarks().isEmpty());
    }
}
