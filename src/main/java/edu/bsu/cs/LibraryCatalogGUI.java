package edu.bsu.cs;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class LibraryCatalogGUI extends Application {
    private LibraryModel libraryModel = new LibraryModel();
    private TextField titleField, authorField, genreField, yearField, usernameField, passwordField;
    private ListView<String> searchResults;
    private ListView<String> recommendedBooks, readingList;
    private User loggedInUser = null;

    @Override
    public void start(Stage primaryStage) {

        TextField newUsernameField = new TextField();
        newUsernameField.setPromptText("New Username");

        PasswordField newPasswordField = new PasswordField();
        newPasswordField.setPromptText("New Password");

        Button createNewAccountButton = new Button("Create New Account");
        createNewAccountButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        // Login UI
        usernameField = new TextField();
        usernameField.setPromptText("Username");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #008CBA; -fx-text-fill: white;");

        // Search UI
        titleField = new TextField();
        titleField.setPromptText("Search by title");

        authorField = new TextField();
        authorField.setPromptText("Search by author");

        genreField = new TextField();
        genreField.setPromptText("Search by genre");

        yearField = new TextField();
        yearField.setPromptText("Search by year");

        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color: #ff9800; -fx-text-fill: white;");

        searchResults = new ListView<>();
        recommendedBooks = new ListView<>();
        readingList = new ListView<>();

        // Login logic
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            loggedInUser = libraryModel.login(username, password);
            if (loggedInUser != null) {
                showAlert("Success", "Logged in successfully!");
                clearLoginFields();
                showCatalogUI();
            } else {
                showAlert("Error", "Invalid login credentials!");
            }
        });

        // Account creation logic
        createNewAccountButton.setOnAction(e -> {
            String username = newUsernameField.getText();
            String password = newPasswordField.getText();
            boolean success = libraryModel.createAccount(username, password);
            if (success) {
                showAlert("Success", "Account created successfully!");
                showLoginUI();
            } else {
                showAlert("Error", "Username already exists!");
            }
        });

        // Book search logic
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
            searchResults.getItems().clear(); // Clear previous search results
            if (results.isEmpty()) {
                showAlert("No Books Found", "No books match your search criteria.");
            } else {
                for (Book book : results) {
                    searchResults.getItems().add(book.getTitle() + " by " + book.getAuthor() + " (" + book.getYear() + ")");
                }
            }
            displayRecommendations();
        });
        GridPane layout = new GridPane();
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new javafx.geometry.Insets(20));

        layout.add(newUsernameField, 0, 0);
        layout.add(newPasswordField, 1, 0);
        layout.add(createNewAccountButton, 2, 0);

        // Login layout
        layout.add(usernameField, 0, 1);
        layout.add(passwordField, 1, 1);
        layout.add(loginButton, 2, 1);

        // Search layout
        layout.add(titleField, 0, 2);
        layout.add(authorField, 1, 2);
        layout.add(genreField, 0, 3);
        layout.add(yearField, 1, 3);
        layout.add(searchButton, 2, 3);

        // Adding list views for search results and recommendations
        layout.add(searchResults, 0, 4, 3, 1);
        layout.add(recommendedBooks, 0, 5, 3, 1);
        layout.add(readingList, 0, 6, 3, 1);

        GridPane.setHalignment(createNewAccountButton, HPos.CENTER);
        GridPane.setHalignment(loginButton, HPos.CENTER);
        GridPane.setHalignment(searchButton, HPos.CENTER);

        // Set up the scene and stage
        Scene scene = new Scene(layout, 800, 700);
        primaryStage.setTitle("Library Catalog");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showCatalogUI() {
        // Clear all previous lists
        searchResults.getItems().clear();
        recommendedBooks.getItems().clear();
        readingList.getItems().clear();

        // Display additional catalog-related sections
        readingList.getItems().add("Reading List: Your current books to read.");
        recommendedBooks.getItems().add("Recommended Books: Books based on your preferences.");
        searchResults.getItems().add("Search for books, authors, and genres here.");
    }

    private void showLoginUI() {
        usernameField.setVisible(true);
        passwordField.setVisible(true);
    }

    private void displayRecommendations() {
        List<Book> recommendations = libraryModel.getRecommendations();
        recommendedBooks.getItems().clear();
        for (Book book : recommendations) {
            recommendedBooks.getItems().add(book.getTitle() + " by " + book.getAuthor());
        }
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
