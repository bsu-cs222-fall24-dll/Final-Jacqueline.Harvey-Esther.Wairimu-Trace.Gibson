package edu.bsu.cs;

public record Book(String title, String author, String genre, int year) {
    @Override
    public String author() {
        return author;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String genre() {
        return genre;
    }

    @Override
    public int year() {
        return year;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }    public String getGenre() {
        return genre;
    }
    public int getYear(){
        return year;
    }
    }