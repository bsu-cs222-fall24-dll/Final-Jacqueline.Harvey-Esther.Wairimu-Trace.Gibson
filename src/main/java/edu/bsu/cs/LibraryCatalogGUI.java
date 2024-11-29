package edu.bsu.cs;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LibraryCatalogGUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        // UI Components for Account Creation (as before)
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button createAccountButton = new Button("Create Account");
        Button searchBooksButton = new Button("Search Books"); // New Button for Book Search

        Label statusLabel = new Label();
        createAccountButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (username.isEmpty() || password.isEmpty()) {
                statusLabel.setText("Please fill out all fields.");
            } else {
                System.out.println("Account Created: Username = " + username + ", Password = " + password);
                statusLabel.setText("Account created successfully!");
            }
        });

        searchBooksButton.setOnAction(event -> {
            showSearchBooksScreen(); // Switch to the Search Books screen
        });

        // Layout for the main screen
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(createAccountButton, 1, 2);
        grid.add(searchBooksButton, 1, 3); // Add the new button
        grid.add(statusLabel, 1, 4);

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setTitle("Library Catalog");
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
                // Simulate book search (real logic would query a database)
                resultLabel.setText("Results for '" + query + "': [Example Book]");
            }
        });

        VBox searchLayout = new VBox(10, searchLabel, searchField, searchButton, resultLabel);
        searchLayout.setPadding(new Insets(10));

        Scene searchScene = new Scene(searchLayout, 300, 200);
        searchStage.setTitle("Search Books");
        searchStage.setScene(searchScene);
        searchStage.show();
    }
    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }}