package edu.bsu.cs;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LibraryCatalogGUI extends Application {

    private boolean isAccountCreated = false; // Tracks account creation

    @Override
    public void start(Stage primaryStage) {
        // UI Components for Account Creation
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button createAccountButton = new Button("Create Account");
        Label statusLabel = new Label();
        Button searchBooksButton = new Button("Search Books");

        createAccountButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (username.isEmpty() || password.isEmpty()) {
                statusLabel.setText("Please fill out all fields.");
            } else {
                isAccountCreated = true; // Mark account as created
                statusLabel.setText("Account created successfully!");
            }
        });

        searchBooksButton.setOnAction(event -> {
            if (isAccountCreated) {
                showSearchBooksScreen(); // Open search screen if account is created
            } else {
                statusLabel.setText("Please create an account first!");
            }
        });

        // Layout for Account Creation Screen
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(20);
        grid.setHgap(20);

        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(createAccountButton, 1, 2);
        grid.add(searchBooksButton, 1, 3);
        grid.add(statusLabel, 1, 4);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Library Catalog - Account Creation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showSearchBooksScreen() {
        Stage searchStage = new Stage();
        Label searchLabel = new Label("Search by Title, Author, or Genre:");
        TextField searchField = new TextField();
        Button searchButton = new Button("Search");
        Label resultLabel = new Label();

        searchButton.setOnAction(event -> {
            String query = searchField.getText();
            if (query.isEmpty()) {
                resultLabel.setText("Please enter a search term.");
            } else {
                // Simulate database lookup
                if (isBookInDatabase(query)) {
                    resultLabel.setText("Book found: " + query);
                } else {
                    resultLabel.setText("Book not found. A notification will be sent to add it.");
                    notifyCreatorToAddBook(query);
                }
            }
        });

        VBox layout = new VBox(10, searchLabel, searchField, searchButton, resultLabel);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 300, 200);
        searchStage.setTitle("Search Books");
        searchStage.setScene(scene);
        searchStage.show();
    }

    private boolean isBookInDatabase(String query) {
        // Mock database check
        return query.equalsIgnoreCase("Moby Dick") || query.equalsIgnoreCase("To Kill a Mockingbird");
    }

    private void notifyCreatorToAddBook(String book) {
        // Simulate sending a notification
        System.out.println("Notification sent to add the book: " + book);
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
