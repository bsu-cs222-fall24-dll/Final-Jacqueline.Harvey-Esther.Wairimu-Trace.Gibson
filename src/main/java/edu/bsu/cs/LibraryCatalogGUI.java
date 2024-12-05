package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class LibraryCatalogGUI extends Application {
    private LibraryModel libraryModel = new LibraryModel();
    private TextField titleField, authorField, genreField, yearField, usernameField, passwordField;
    private ListView<String> searchResults;
    private User loggedInUser = null;

    @Override
    public void start(Stage primaryStage) {
        // Login UI
        usernameField = new TextField();
        usernameField.setPromptText("Username");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");

        // Account creation UI
        TextField newUsernameField = new TextField();
        newUsernameField.setPromptText("New Username");

        PasswordField newPasswordField = new PasswordField();
        newPasswordField.setPromptText("New Password");

        Button createNewAccountButton = new Button("Create New Account");

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

        searchResults = new ListView<>();

        // Login logic
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

        // Account creation logic
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
                searchResults.getItems().add("No results found.");
            } else {
                for (Book book : results) {
                    searchResults.getItems().add(book.getTitle() + " by " + book.getAuthor());
                }
            }
        });

        // Layout the UI elements
        VBox layout = new VBox(10);
        layout.getChildren().addAll(usernameField, passwordField, loginButton,
                newUsernameField, newPasswordField, createNewAccountButton,
                titleField, authorField, genreField, yearField, searchButton, searchResults);

        // Set up the stage and scene
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setTitle("Library Catalog");
        primaryStage.setScene(scene);
        primaryStage.show();
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
