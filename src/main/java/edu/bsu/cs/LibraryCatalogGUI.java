package edu.bsu.cs;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;

public class LibraryCatalogGUI extends Application {
     Label messageLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Library GUI");
        primaryStage.show();

        VBox layout = new VBox(10);

        TextField inputField = new TextField();
        inputField.setPromptText("Enter item name");

        Button addButton = new Button("Add Item");
        // Initialize the ListView to display items
        ListView<String> listView = new ListView<>();

        // Add event handler to the button
        addButton.setOnAction(event -> {
            String item = inputField.getText();
            if (item != null && !item.equals("")) {
                listView.getItems().add(item);  // Add item to list
                inputField.clear();  // Clear input field
                messageLabel.setText("Item added successfully!");
            } else {
                messageLabel.setText("Please enter an item.");
            }
        });

        layout.getChildren().addAll(inputField, addButton, listView, messageLabel);
        // Add TextField, Button, and ListView to the layout
        layout.getChildren().addAll(inputField, addButton, listView);

        layout.getChildren().addAll(inputField, addButton);
        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
