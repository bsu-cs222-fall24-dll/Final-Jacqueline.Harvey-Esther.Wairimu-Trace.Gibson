package edu.bsu.cs;

import java.util.List;

public class User {
    private final String username;
    private final String passwordHash;

    public User(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public List<Book> getRecommendations(LibraryModel catalog) {

        return List.of();
    }

    public String getUserName() {

        return "";
    }

    public String getPassword() {

        return "";
    }
}
