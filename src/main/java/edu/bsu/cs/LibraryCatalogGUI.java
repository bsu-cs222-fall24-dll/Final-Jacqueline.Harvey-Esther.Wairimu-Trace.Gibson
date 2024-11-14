package edu.bsu.cs;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LibraryCatalogGUI extends Application {
    private TextField usernameField;
    private PasswordField passwordField;
    private Button createAccountButton;

    @Override
    public void start(Stage primaryStage) {
        // Account setup fields
        usernameField = new TextField();
        usernameField.setPromptText("Enter Username");

        passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        createAccountButton = new Button("Create Account");

        // Layout to add components
        VBox layout = new VBox(10, usernameField, passwordField, createAccountButton);
        Scene scene = new Scene(layout, 300, 200);

        // Window settings
        primaryStage.setTitle("Library Catalog - Account Setup");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
