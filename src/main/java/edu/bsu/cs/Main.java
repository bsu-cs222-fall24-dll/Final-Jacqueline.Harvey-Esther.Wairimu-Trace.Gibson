package edu.bsu.cs;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DatabaseManager dbManager = new DatabaseManager("books.db");
        ReadingList readingList = new ReadingList(dbManager);
        Notification notification = new Notification(dbManager);
        Bookmark bookmark = new Bookmark(dbManager);

        LibraryModel catalog = new LibraryModel();
        LibraryController controller = new LibraryController(catalog);

        controller.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960));
        controller.addBook(new Book("1984", "George Orwell", "Dystopian", 1949));
        controller.addBook(new Book("Moby Dick", "Herman Melville", "Adventure", 1851));

        int totalBooks = controller.getBookCount();
        System.out.println("Total number of books in the catalog: " + totalBooks);

        List<Book> allBooks = catalog.getAllBooks();
        System.out.println("\nBooks in the catalog:");
        for (Book book : allBooks) {
            System.out.println("Title: " + book.title() + ", Author: " + book.author() +
                    ", Genre: " + book.genre() + ", Year: " + book.year());
        }
        User user = new User("Bill Graham", "password123");
        user.addFavouriteBook(new Book("1984", "George Orwell", "Dystopian", 1949));

        List<Book> recommendations = controller.getUserRecommendations(user);
        System.out.println("\nRecommended books:");
        for (Book recBook : recommendations) {
            System.out.println("Title: " + recBook.title() + "\nAuthor: " + recBook.author() + "\n");
        }

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925);
        readingList.addBook(book1, "Classics");

        notification.addNotification(1, "2024-01-01");

        bookmark.addBookmark(0);

        System.out.println("Books in Classics: " + readingList.getBooksByCategory("Classics"));
        System.out.println("Notifications: " + notification.getNotifications());
        System.out.println("Bookmarks: " + bookmark.getBookmarks());
    }
}



