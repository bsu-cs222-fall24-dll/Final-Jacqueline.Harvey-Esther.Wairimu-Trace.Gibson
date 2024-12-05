package edu.bsu.cs;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.List;

public class LibraryCatalogGUI extends Application {
    private final LibraryModel libraryModel = new LibraryModel();
    private TextField titleField, authorField, genreField, yearField, usernameField, passwordField;
    private ListView<String> searchResults;
    private ListView<String> recommendedBooks;
    private User loggedInUser = null;
    private Label totalBooksLabel;

    @Override
    public void start(Stage primaryStage) {

        TextField newUsernameField = new TextField();
        newUsernameField.setPromptText("New Username");

        PasswordField newPasswordField = new PasswordField();
        newPasswordField.setPromptText("New Password");

        Button createNewAccountButton = new Button("Create New Account");
        styleButton(createNewAccountButton, Color.GREEN);

        usernameField = new TextField();
        usernameField.setPromptText("Username");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        styleButton(loginButton, Color.DARKBLUE);

        titleField = new TextField();
        titleField.setPromptText("Search by title");

        authorField = new TextField();
        authorField.setPromptText("Search by author");

        genreField = new TextField();
        genreField.setPromptText("Search by genre");

        yearField = new TextField();
        yearField.setPromptText("Search by year");

        Button searchButton = new Button("Search");
        styleButton(searchButton, Color.ORANGE);

        Button exitButton = new Button("Exit");
        styleButton(exitButton, Color.RED);
        exitButton.setOnAction(e -> Platform.exit());

        searchResults = new ListView<>();
        recommendedBooks = new ListView<>();
        totalBooksLabel = new Label("Total Books: 0");

        Button viewReadingListButton = new Button("View Reading List");
        styleButton(viewReadingListButton, Color.CORAL);

        Button viewBookmarksButton = new Button("View Bookmarks");
        styleButton(viewBookmarksButton, Color.CYAN);

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            loggedInUser = libraryModel.login(username, password);
            if (loggedInUser != null) {
                showAlert("Success", "Logged in successfully!");
                clearLoginFields();
            } else {
                showAlert("Error", "Invalid login credentials!");
            }
        });

        createNewAccountButton.setOnAction(e -> {
            String username = newUsernameField.getText();
            String password = newPasswordField.getText();
            boolean success = libraryModel.createAccount(username, password);
            if (success) {
                showAlert("Success", "Account created successfully!");
            } else {
                showAlert("Error", "Username already exists!");
            }
        });

        searchButton.setOnAction(e -> {
            if (loggedInUser == null) {
                showAlert("Error", "Please log in first.");
                return;
            }

            Integer year = null;
            try {
                if (!yearField.getText().isEmpty()) {
                    year = Integer.parseInt(yearField.getText());
                }
            } catch (NumberFormatException ex) {
                showAlert("Error", "Year must be a valid number.");
                return;
            }

            List<Book> results = libraryModel.searchBooks(titleField.getText(), authorField.getText(), genreField.getText(), year);
            searchResults.getItems().clear();
            if (results.isEmpty()) {
                searchResults.getItems().add("Book not found.");
            } else {
                for (Book book : results) {
                    searchResults.getItems().add(book.getTitle() + " by " + book.getAuthor());
                }
            }
            displayRecommendations();
            updateBookCount();
        });

        viewReadingListButton.setOnAction(e -> {
            if (loggedInUser != null) {
                List<String> readingList = libraryModel.getReadingList(loggedInUser);
                if (readingList.isEmpty()) {
                    showAlert("Info", "Your reading list is empty.");
                } else {
                    showAlert("Reading List", String.join("\n", readingList));
                }
            } else {
                showAlert("Error", "Please log in to view your reading list.");
            }
        });

        viewBookmarksButton.setOnAction(e -> {
            if (loggedInUser != null) {
                List<String> bookmarks = libraryModel.getBookmarks(loggedInUser);
                if (bookmarks.isEmpty()) {
                    showAlert("Info", "You have no bookmarks.");
                } else {
                    showAlert("Bookmarks", String.join("\n", bookmarks));
                }
            } else {
                showAlert("Error", "Please log in to view your bookmarks.");
            }
        });

        VBox layout = new VBox(15);
        layout.setStyle("-fx-background-color: #F4F4F4;");
        layout.getChildren().addAll(newUsernameField, newPasswordField, createNewAccountButton,
                usernameField, passwordField, loginButton,
                titleField, authorField, genreField, yearField, searchButton, searchResults, recommendedBooks,
                totalBooksLabel, viewReadingListButton, viewBookmarksButton, exitButton);

        Scene scene = new Scene(layout, 900, 700);
        primaryStage.setTitle("Library Catalog");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void styleButton(Button button, Color backgroundColor) {
        button.setTextFill(Color.WHITE);
        button.setStyle("-fx-background-color: " + toHexString(backgroundColor) + "; -fx-font-size: 14px; -fx-border-radius: 5;");
        button.setPrefHeight(25);
        button.setPrefWidth(250);
    }

    private String toHexString(Color color) {
        return String.format("#%02X%02X%02X", (int) (color.getRed() * 255), (int) (color.getGreen() * 255), (int) (color.getBlue() * 255));
    }

    private void displayRecommendations() {
        List<Book> recommendations = libraryModel.getRecommendations();
        recommendedBooks.getItems().clear();
        for (Book book : recommendations) {
            recommendedBooks.getItems().add(book.getTitle() + " by " + book.getAuthor());
        }
    }

    private void updateBookCount() {
        int totalBooks = libraryModel.getTotalBooks();
        totalBooksLabel.setText("Total Books: " + totalBooks);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearLoginFields() {
        usernameField.clear();
        passwordField.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
