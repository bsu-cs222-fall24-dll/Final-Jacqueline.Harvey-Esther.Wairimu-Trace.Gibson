package edu.bsu.cs;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LibraryCatalogGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Library GUI");
        primaryStage.show();
        // Create a VBox layout with spacing of 10
        VBox layout = new VBox(10);
        // Set up the scene and add the layout
        TextField inputField = new TextField();
        inputField.setPromptText("Enter item name");

        // Create a button for adding items
        Button addButton = new Button("Add Item");

        layout.getChildren().addAll(inputField, addButton);
        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
