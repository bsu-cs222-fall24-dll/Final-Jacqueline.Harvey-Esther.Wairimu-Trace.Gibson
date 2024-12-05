package edu.bsu.cs;

import java.util.List;

public class Bookmark {
    private final DatabaseManager dbManager;

    public Bookmark(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public List<Integer> getBookmarks() {
        return dbManager.getBookmarks();
    }
}