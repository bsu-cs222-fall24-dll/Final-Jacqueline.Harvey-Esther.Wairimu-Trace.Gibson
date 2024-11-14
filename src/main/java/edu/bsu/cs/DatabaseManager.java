package edu.bsu.cs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@SuppressWarnings("ALL")
public class DatabaseManager {
    private final Connection conn;

    public DatabaseManager(String databasePath) {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + databasePath);
            createTables();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Database initialization error", e);
        }
    }

    private void createTables() {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS books (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, author TEXT NOT NULL, genre TEXT NOT NULL, year INTEGER NOT NULL)");
            stmt.execute("CREATE TABLE IF NOT EXISTS bookmarks (id INTEGER PRIMARY KEY AUTOINCREMENT, book_id INTEGER NOT NULL)");
            stmt.execute("CREATE TABLE IF NOT EXISTS notifications (id INTEGER PRIMARY KEY AUTOINCREMENT, book_id INTEGER NOT NULL, release_date TEXT NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book) {
        String sql = "INSERT INTO books(title, author, genre, year) VALUES(?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.title());
            pstmt.setString(2, book.author());
            pstmt.setString(3, book.genre());
            pstmt.setInt(4, book.year());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                books.add(new Book(rs.getString("title"), rs.getString("author"), rs.getString("genre"), rs.getInt("year")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void addBookmark(int bookId) {
        String sql = "INSERT INTO bookmarks(book_id) VALUES(?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getBookmarks() {
        List<Integer> bookmarks = new ArrayList<>();
        String sql = "SELECT book_id FROM bookmarks";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                bookmarks.add(rs.getInt("book_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookmarks;
    }

    public void addNotification(int bookId, String releaseDate) {
        String sql = "INSERT INTO notifications(book_id, release_date) VALUES(?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            pstmt.setString(2, releaseDate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getNotifications() {
        List<String> notifications = new ArrayList<>();
        String sql = "SELECT release_date FROM notifications";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                notifications.add(rs.getString("release_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifications;
    }
}