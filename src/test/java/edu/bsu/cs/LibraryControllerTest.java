package edu.bsu.cs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryControllerTest {
    @Test
    public void testAddBook() {
        LibraryModel catalog = new LibraryModel();
        LibraryController controller = new LibraryController(catalog);
        Book book = new Book("Clean Code", "Robert C. Martin", "Programming", 2012);
        controller.addBook(book);
        assertEquals(1, controller.getBookCount());
        assertTrue(controller.searchByTitle("Clean Code").contains(book));  }
    @Test
    public void testSearchByAuthor() {
        LibraryModel catalog = new LibraryModel();
        LibraryController controller = new LibraryController(catalog);
        Book book = new Book("Clean Code", "Robert C. Martin", "Programming", 2012);
        controller.addBook(book);
        assertTrue(controller.searchByAuthor("Robert C. Martin").contains(book));
    }
    @Test
    public void testSearchByGenre() {
        LibraryModel catalog = new LibraryModel();
        LibraryController controller = new LibraryController(catalog);
        Book book = new Book("Clean Code", "Robert C. Martin", "Programming", 2012);
        controller.addBook(book);
        assertTrue(controller.searchByGenre("Programming").contains(book));
    }
    @Test
    public void testSearchByYear() {
        LibraryModel catalog = new LibraryModel();
        LibraryController controller = new LibraryController(catalog);
        Book book = new Book("Clean Code", "Robert C. Martin", "Programming", 2012);
        controller.addBook(book);
        assertTrue(controller.searchByYear(2012).contains(book));
    }


}
