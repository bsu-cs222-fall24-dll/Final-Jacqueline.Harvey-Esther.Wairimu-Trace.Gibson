package edu.bsu.cs;

import java.util.ArrayList;
import java.util.List;

public class LibraryModel {
    private final List<User> users = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();

    public LibraryModel() {
        addBook(new Book("The Purpose Driven Life", "Rick Warren", "Christian Living", 2002));
        addBook(new Book("Mere Christianity", "C.S. Lewis", "Apologetics", 1952));
        addBook(new Book("The Pilgrim's Progress", "John Bunyan", "Allegory", 1678));
        addBook(new Book("The Case for Christ", "Lee Strobel", "Christian Apologetics", 1998));
        addBook(new Book("Crazy Love", "Francis Chan", "Christian Living", 2008));
        addBook(new Book("Radical", "David Platt", "Christian Living", 2010));
        addBook(new Book("Heaven is for Real", "Todd Burpo", "Memoir", 2010));
        addBook(new Book("God's Not Dead", "Rice Broocks", "Apologetics", 2013));
        addBook(new Book("Jesus Calling", "Sarah Young", "Devotional", 2004));
        addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960));
        addBook(new Book("A Grief Observed", "C.S. Lewis", "Christian Memoir", 1961));
        addBook(new Book("The Power of a Praying Wife", "Stormie Omartian", "Christian Living", 1997));
    }

    public boolean createAccount(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        String hashedPassword = PasswordHasher.hash(password);
        users.add(new User(username, hashedPassword));
        return true;
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) &&
                    PasswordHasher.verify(password, user.getPasswordHash())) {
                return user;
            }
        }
        return null;
    }

    public List<Book> searchBooks(String title, String author, String genre, Integer year) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            boolean matchesTitle = (title == null || title.isEmpty() || book.getTitle().toLowerCase().contains(title.toLowerCase()));
            boolean matchesAuthor = (author == null || author.isEmpty() || book.getAuthor().toLowerCase().contains(author.toLowerCase()));
            boolean matchesGenre = (genre == null || genre.isEmpty() || book.getGenre().toLowerCase().contains(genre.toLowerCase()));
            boolean matchesYear = (year == null || book.getYear() == year);

            if (matchesTitle && matchesAuthor && matchesGenre && matchesYear) {
                results.add(book);
            }
        }
        return results;
    }

    public void addBook(Book book) {
        books.add(book);

    }

    public List<Book> getRecommendations() {
        List<Book> recommendedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > 2000) {
                recommendedBooks.add(book);
            }
        }
        return recommendedBooks;
    }

    public List<String> getReadingList(User loggedInUser) {

        return List.of();
    }

    public List<String> getBookmarks(User loggedInUser) {

        return List.of();
    }

    public int getTotalBooks() {

        return 0;
    }
}
