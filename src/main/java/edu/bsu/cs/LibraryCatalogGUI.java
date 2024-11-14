//package edu.bsu.cs;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//public class LibraryCatalogGUI extends Application {
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Account setup fields
//        TextField usernameField = new TextField();
//        usernameField.setPromptText("Enter Username");
//
//        PasswordField passwordField = new PasswordField();
//        passwordField.setPromptText("Enter Password");
//
//        Button createAccountButton = new Button("Create Account");
//
//        // Layout to add components
//        VBox layout = new VBox(10, usernameField, passwordField, createAccountButton);
//        Scene scene = new Scene(layout, 300, 200);
//
//        // Window settings
//        primaryStage.setTitle("Library Catalog - Account Setup");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
