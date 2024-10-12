package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testCreateUser(){
        User user = new User("Bill Graham", "password123");
        assertEquals("Bill Graham", user.getuserName());

        assertEquals("password123", user.getpassword());
        Assertions.assertNotEquals(null, user);
    }@Test
    //asserts that the  favourite books list contains added book
    public void testAddFavouriteBook(){
        User user = new User("Bill Graham", "password123");
        Assertions.assertNotNull(user);
        Book book = new Book ("Clean code", "Robert C. Martin", "Programming", 2012);
        user.addfavouriteBooks(book);
       assertTrue(user.getfavouriteBooks().contains(book));
    }@Test
    // Asserts that the continue reading list contains the book being read
    public void testAddContinueReading(){
        User user = new User("Bill Graham", "password123");
        Assertions.assertNotNull(user);
        Book book = new Book("Clean code", "Robert C. Martin", "Programming", 2012);
        user.continueReading(book);
        assertTrue(user.getcontinueReading().contains(book));
    }@Test
    public void testAddRecommendedBooks(){
        User user = new User ("Bill Graham", "password123");
        Assertions.assertNotNull(user);
        Book book = new Book("Clean code", "Robert C. Martin", "Programming", 2012);
        user.addrecommendedBooks(book);
        assertTrue(user.getrecommendedBooks().contains(book));
    }
}
