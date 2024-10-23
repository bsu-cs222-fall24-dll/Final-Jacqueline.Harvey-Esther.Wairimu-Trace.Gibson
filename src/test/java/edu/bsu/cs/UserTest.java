package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testCreateUser(){
        User user = new User("Bill Graham", "password123");
        assertEquals("Bill Graham", user.getUserName());

        assertEquals("password123", user.getPassword());
        Assertions.assertNotEquals(null, user);
    }@Test
    public void testAddFavouriteBook(){
        User user = new User("Bill Graham", "password123");
        Assertions.assertNotNull(user);
        Book book = new Book ("Clean code", "Robert C. Martin", "Programming", 2012);
        user.addFavouriteBooks(book);
        assertTrue(user.getFavouriteBooks().contains(book));
    }@Test
    public void testAddContinueReading(){
        User user = new User("Bill Graham", "password123");
        Assertions.assertNotNull(user);
        Book book = new Book("Clean code", "Robert C. Martin", "Programming", 2012);
        user.continueReading(book);
        assertTrue(user.getContinueReading().contains(book));
    }@Test
    public void testAddRecommendedBooks(){
        User user = new User ("Bill Graham", "password123");
        Assertions.assertNotNull(user);
        Book book = new Book("Clean code", "Robert C. Martin", "Programming", 2012);
        user.addRecommendedBooks(book);
        assertTrue(user.getRecommendedBooks().contains(book));
    }
}