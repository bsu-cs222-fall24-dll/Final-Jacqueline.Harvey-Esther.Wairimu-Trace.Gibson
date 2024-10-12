package edu.bsu.cs;

public class Book {
	private final String title;
	private final String author;
	private final String genre;
	private final int year;

	public Book(String title, String author, String genre, int year){
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.year = year;
	}//Getters
	public String getTitle(){
		return title;
	}public String getAuthor(){
		return author;
	}public String getGenre(){
		return genre;
	}public int getYear(){
		return year;
	}

}
