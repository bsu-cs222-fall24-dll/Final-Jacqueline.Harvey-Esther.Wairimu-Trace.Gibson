package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LibraryModelTest {
    private LibraryModel library;

    @BeforeEach
    public void setUp() {
        library = new LibraryModel();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Moby Dick", "Herman Melville", "Adventure", 1851);
        library.addBook(book);
        List<Book> allBooks = library.getAllBooks();
        assertEquals(1, allBooks.size());
        assertEquals(book, allBooks.get(0));
    }

    @Test
    public void testSearchByAuthor() {
        library.addBook(new Book("1984", "George Orwell", "Dystopian", 1949));
        List<Book> results = library.searchByAuthor("George Orwell");
        assertEquals(1, results.size());
        assertEquals("1984", results.get(0).title());
    }
}
