package edu.bsu.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private final String userName;
    private final String password;
    private final List<Book> favouriteBooks;
    private final List<Book> continueReading;
    private final List<Book> recommendedBooks;

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
        this.favouriteBooks = new ArrayList<>();
        this.continueReading = new ArrayList<>();
        this.recommendedBooks = new ArrayList<>();
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public void addFavouriteBook(Book book){
        favouriteBooks.add(book);
    }

    public void continueReading(Book book){
        continueReading.add(book);
    }

    public void addRecommendedBooks(Book book){
        recommendedBooks.add(book);
    }

    public List<Book> getFavouriteBooks(){
        return new ArrayList<>(favouriteBooks);
    }

    public List<Book> getContinueReading(){
        return new ArrayList<>(continueReading);
    }

    public List<Book> getRecommendedBooks(){
        return new ArrayList<>(recommendedBooks);
    }

    public List<Book> getRecommendations(LibraryModel catalog) {
        List<Book> recommendations = new ArrayList<>();
        for (Book favoriteBook : favouriteBooks) {
            recommendations.addAll(catalog.searchByAuthor(favoriteBook.author()));
            recommendations.addAll(catalog.searchByGenre(favoriteBook.genre()));
        }
        return recommendations.stream().distinct().collect(Collectors.toList());
    }
}