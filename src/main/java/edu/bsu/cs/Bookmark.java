package edu.bsu.cs;

import java.util.List;

public class Bookmark {
    private final DatabaseManager dbManager;

    public Bookmark(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public void addBookmark(int bookId) {
        dbManager.addBookmark(bookId);
    }

    public List<Integer> getBookmarks() {
        return dbManager.getBookmarks();
    }
}