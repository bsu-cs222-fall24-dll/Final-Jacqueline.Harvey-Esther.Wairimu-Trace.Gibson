package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class BookmarkTest {
    private Bookmark bookmark;
    @BeforeEach
    public void setUp() {
        bookmark = new Bookmark(new DatabaseManager("test.db"));
    }

    @Test
    public void testAddBookmark() {
        bookmark.addBookmark(1);
        assertNotEquals(List.of(1), bookmark.getBookmarks());
    }

    @Test
    public void testGetBookmarksEmpty() {
        assertFalse(bookmark.getBookmarks().isEmpty());
    }
}
