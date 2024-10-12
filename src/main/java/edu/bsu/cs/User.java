package edu.bsu.cs;
import java.util.List;
import java.util.ArrayList;

public class User {
    private String userName;
    private String password;
    private List<Book> favouriteBooks;
    private List<Book> continueReading;
    private List<Book> recommendedBooks;

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
        this.favouriteBooks = new ArrayList<>();
        this.continueReading = new ArrayList<>();
        this.recommendedBooks = new ArrayList<>();
        //method to add a book to the user's favourite list
    } public String getuserName(){
        return userName;
    } public String getPassword(){
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
}
