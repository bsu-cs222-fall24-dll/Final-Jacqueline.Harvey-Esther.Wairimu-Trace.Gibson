package edu.bsu.cs;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LibraryCatalogTest {
    @Test
    public void testAddBook() {
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book ("Clean code", "Robert C. Martin", "Programming", 2012);
        catalog.addBook(book);
        List<Book> books = catalog.searchByTitle("Clean Code");
        assertTrue(books.contains(book));  // Asserts that the book was added to the catalog
    }}