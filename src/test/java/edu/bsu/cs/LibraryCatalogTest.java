package edu.bsu.cs;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
// Asserts that the book was added to the catalog
public class LibraryCatalogTest {
   @Test
    public void testAddBook() {
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("Clean Code", "Robert C. Martin", "Programming", 2012);
        catalog.addBook(book);
        List<Book> books = catalog.searchByTitle("Clean Code");
        assertTrue(books.contains(book));
    }
    @Test
    public void testSearchByTitle() {
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book ("Clean code", "Robert C. Martin", "Programming", 2012);
        catalog.addBook(book);
        List<Book> books = catalog.searchByTitle("Clean Code");
        assertTrue(books.contains(book));
    }
    @Test
    public void testSearchByAuthor(){
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book ("Clean code", "Robert C. Martin", "Programming", 2012);
        catalog.addBook(book);
        List<Book> books = catalog.searchByAuthor("Robert C. Martin");
        assertTrue(books.contains(book));

    }  @Test
    public void testSearchByGenre(){
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book ("Clean code", "Robert C. Martin", "Programming", 2012);
        catalog.addBook(book);
        List<Book> books = catalog.searchByGenre("Programming");
        assertTrue(books.contains(book));
    }
    @Test
    public void testSearchByYear(){
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book ("Clean code", "Robert C. Martin", "Programming", 2012);
        catalog.addBook(book);
        List<Book> books = catalog.searchByYear(2012);
        assertTrue(books.contains(book));
    }
   }