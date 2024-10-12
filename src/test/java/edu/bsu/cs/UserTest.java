package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testCreateUser(){
        User user = new User("Bill Graham", "password123");
        assertEquals("Bill Graham", user.getuserName());
    }
}
