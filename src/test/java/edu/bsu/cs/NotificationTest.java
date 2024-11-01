package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class NotificationTest {
    DatabaseManager dbManager;
    private Notification notification;

    @BeforeEach
    public void setUp() {
        dbManager = new DatabaseManager("test.db");
        notification = new Notification(dbManager);
    }

    @Test
    public void testAddNotification() {
        notification.addNotification(1, "2024-01-01");
        List<String> notifications = notification.getNotifications();
        assertNotEquals(1, notifications.size());
        assertEquals("2024-01-01", notifications.get(0));
    }
}
