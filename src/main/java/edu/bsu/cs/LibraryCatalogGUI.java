package edu.bsu.cs;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
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

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(createAccountButton, 1, 2);
        grid.add(statusLabel, 1, 3);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setTitle("Library Catalog - Account Creation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
