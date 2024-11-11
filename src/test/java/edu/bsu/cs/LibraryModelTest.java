package edu.bsu.cs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryModelTest {

    @Test
    public void searchByAuthor() {
        LibraryModel library = new LibraryModel();
        library.addBook(new Book("1984", "George Orwell", "Dystopian", 1949));
        assertEquals(1, library.searchByAuthor("George Orwell").size());
    }
}
