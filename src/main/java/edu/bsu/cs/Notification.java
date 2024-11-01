package edu.bsu.cs;

import java.util.List;

public class Notification {
    private final DatabaseManager dbManager;

    public Notification(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public void addNotification(int bookId, String releaseDate) {
        dbManager.addNotification(bookId, releaseDate);
    }

    public List<String> getNotifications() {
        return dbManager.getNotifications();
    }
}