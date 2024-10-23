package edu.bsu.cs;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LibraryModelTest {
   @Test
    public void testAddBook() {
        LibraryModel catalog = new LibraryModel();
        Book book = new Book("Clean Code", "Robert C. Martin", "Programming", 2012);
        catalog.addBook(book);
        List<Book> books = catalog.searchByTitle("Clean Code");
        assertTrue(books.contains(book));
    }
    @Test
    public void testSearchByTitle() {
        LibraryModel catalog = new LibraryModel();
        Book book = new Book ("Clean code", "Robert C. Martin", "Programming", 2012);
        catalog.addBook(book);
        List<Book> books = catalog.searchByTitle("Clean Code");
        assertTrue(books.contains(book));
    }
    @Test
    public void testSearchByAuthor(){
        LibraryModel catalog = new LibraryModel();
        Book book = new Book ("Clean code", "Robert C. Martin", "Programming", 2012);
        catalog.addBook(book);
        List<Book> books = catalog.searchByAuthor("Robert C. Martin");
        assertTrue(books.contains(book));

    }  @Test
    public void testSearchByGenre(){
        LibraryModel catalog = new LibraryModel();
        Book book = new Book ("Clean code", "Robert C. Martin", "Programming", 2012);
        catalog.addBook(book);
        List<Book> books = catalog.searchByGenre("Programming");
        assertTrue(books.contains(book));
    }
    @Test
    public void testSearchByYear(){
        LibraryModel catalog = new LibraryModel();
        Book book = new Book ("Clean code", "Robert C. Martin", "Programming", 2012);
        catalog.addBook(book);
        List<Book> books = catalog.searchByYear(2012);
        assertTrue(books.contains(book));
    }
   }