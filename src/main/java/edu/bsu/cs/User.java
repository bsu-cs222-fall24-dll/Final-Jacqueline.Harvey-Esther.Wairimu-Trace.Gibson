package edu.bsu.cs;
import java.util.List;
import java.util.ArrayList;
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

    } public String getuserName(){
        return userName;
    } public String getpassword(){
        return password;
    }
    public void addfavouriteBooks(Book book){
        favouriteBooks.add(book);
        //method to update user's currently reading books
    }public void continueReading(Book book){
        continueReading.add(book);
    }public void addrecommendedBooks(Book book){
        recommendedBooks.add(book);
    }//getters for the methods
    public List<Book> getfavouriteBooks(){
        return favouriteBooks;
    }public List<Book> getcontinueReading(){
        return continueReading;
    }public List<Book> getrecommendedBooks(){
        return recommendedBooks;
    }
    public List<Book> getRecommendations(LibraryModel catalog) {
        List<Book> recommendations = new ArrayList<>();
        for (Book favoriteBook : favouriteBooks) {
            recommendations.addAll(catalog.searchByAuthor(favoriteBook.getAuthor()));
            recommendations.addAll(catalog.searchByGenre(favoriteBook.getGenre()));
        }
        return recommendations.stream().distinct().collect(Collectors.toList());
    }

}