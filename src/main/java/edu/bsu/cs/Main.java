package edu.bsu.cs;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryModel libraryModel = new LibraryModel();

        // Test search by year
        List<Book> booksFrom1960 = libraryModel.searchBooks(null, null, null, 2002);
        if (!booksFrom1960.isEmpty()) {
            System.out.println("Books found from 2002:");
            for (Book book : booksFrom1960) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
            }
        } else {
            System.out.println("No books found from 2002.");
        }

        // Test search by genre
        List<Book> christianLivingBooks = libraryModel.searchBooks(null, null, "Christian Living", null);
        if (!christianLivingBooks.isEmpty()) {
            System.out.println("Christian Living books found:");
            for (Book book : christianLivingBooks) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
            }
        } else {
            System.out.println("No Christian Living books found.");
        }
    }
}
