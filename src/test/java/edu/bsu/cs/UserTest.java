package edu.bsu.cs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void userHasNameAndPassword() {
        User user = new User("Bill Graham", "password123");
        assertEquals("Bill Graham", user.getUserName());
        assertEquals("password123", user.getPassword());
    }
}
