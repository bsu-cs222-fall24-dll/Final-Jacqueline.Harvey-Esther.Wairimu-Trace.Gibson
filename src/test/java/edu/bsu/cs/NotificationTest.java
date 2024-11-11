package edu.bsu.cs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationTest {

    @Test
    public void addNotification() {
        DatabaseManager dbManager = new DatabaseManager("test.db");
        Notification notification = new Notification(dbManager);
        notification.addNotification(1, "2024-01-01");
        assertTrue(notification.getNotifications().contains("2024-01-01"));
    }
}
