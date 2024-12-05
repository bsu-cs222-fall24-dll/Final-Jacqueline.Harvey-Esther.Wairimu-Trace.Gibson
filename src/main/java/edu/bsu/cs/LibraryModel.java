package edu.bsu.cs;

import java.util.ArrayList;
import java.util.List;

public class LibraryModel {

    private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private List<Notification> notifications = new ArrayList<>();

    public LibraryModel() {
        // Create a test account for debugging
        createAccount("testUser", "testPassword");
    }

    public boolean createAccount(String username, String password) {
        if (users.stream().anyMatch(user -> user.getUsername().equals(username))) {
            System.out.println("DEBUG: Username already exists: " + username);
            return false; // Username already exists
        }
        String hashedPassword = PasswordHasher.hash(password);
        System.out.println("DEBUG: Creating account with username = " + username + ", hashedPassword = " + hashedPassword);
        users.add(new User(username, hashedPassword));
        return true;
    }

    public User login(String username, String password) {
        String hashedPassword = PasswordHasher.hash(password);
        System.out.println("DEBUG: Attempting login for username = " + username + ", hashedPassword = " + hashedPassword);

        for (User user : users) {
            System.out.println("DEBUG: Checking user: " + user.getUsername() + ", storedHashedPassword = " + user.getPasswordHash());
            if (user.getUsername().equals(username) && PasswordHasher.verify(password, user.getPasswordHash())) {
                System.out.println("DEBUG: Login successful for username = " + username);
                return user;
            }
        }
        System.out.println("DEBUG: Login failed for username = " + username);
        return null; // Invalid credentials
    }

    public List<Book> searchBooks(String query, String s, String s1) {

        return List.of();
    }

    public List<Book> getReadingList(User currentUser) {

        return List.of();
    }

    public List<Book> getAllBooks() {

        return List.of();
    }

    public void addBook(Book book) {
    }
}
