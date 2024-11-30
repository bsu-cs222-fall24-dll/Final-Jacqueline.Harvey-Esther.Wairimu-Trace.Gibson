package edu.bsu.cs;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;


public class LibraryCatalogGUI extends Application {

    private LibraryModel libraryModel;
    private User currentUser;
    private Button searchButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        libraryModel = new LibraryModel();
        currentUser = null;

        Button createAccountButton = createButton("Create Account", e -> showCreateAccountScreen());
        searchButton = createButton("Search Books", e -> showSearchScreen());

        // Disable search if no account is created
        searchButton.setDisable(true);

        VBox layout = new VBox(20, createAccountButton, searchButton);
        layout.setAlignment(Pos.CENTER);

        Scene mainScene = new Scene(layout, 400, 400);
        primaryStage.setTitle("Library Catalog");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    private Button createButton(String text, javafx.event.EventHandler<javafx.event.ActionEvent> action) {
        Button button = new Button(text);
        button.setOnAction(action);
        return button;
    }
    private void showCreateAccountScreen() {
        Stage createAccountStage = new Stage();
        createAccountStage.setTitle("Create Account");

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button createButton = new Button("Create Account");

        createButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            currentUser = new User(username, password);
            createAccountStage.close();
            showMessage("Account created successfully!");
            enableSearchButton();
        });

        VBox layout = new VBox(10, usernameLabel, usernameField, passwordLabel, passwordField, createButton);
        layout.setAlignment(Pos.CENTER);
        Scene createAccountScene = new Scene(layout, 400, 400);
        createAccountStage.setScene(createAccountScene);
        createAccountStage.show();
    }
    private void enableSearchButton() {
        searchButton.setDisable(false);
    }
    private void showSearchScreen() {
        if (currentUser == null) {
            showMessage("You must create an account first.");
            return;
        }
        Stage searchStage = new Stage();
        searchStage.setTitle("Search Books");

        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField();
        Label authorLabel = new Label("Author:");
        TextField authorField = new TextField();
        Label genreLabel = new Label("Genre:");
        TextField genreField = new TextField();
        Label yearLabel = new Label("Year:");
        TextField yearField = new TextField();
        Button searchButton = new Button("Search");
        Label resultLabel = new Label("Search results will appear here.");

        searchButton.setOnAction(e -> {
            String title = titleField.getText();
            String author = authorField.getText();
            String genre = genreField.getText();
            String yearText = yearField.getText();
            int year = (yearText.isEmpty()) ? -1 : Integer.parseInt(yearText);

            List<Book> books = libraryModel.searchBooks(title, author, genre, year);
            displaySearchResults(books, resultLabel);
        });

        VBox layout = new VBox(10, titleLabel, titleField, authorLabel, authorField, genreLabel, genreField, yearLabel, yearField, searchButton, resultLabel);
        layout.setAlignment(Pos.CENTER);
        Scene searchScene = new Scene(layout, 400, 400);
        searchStage.setScene(searchScene);
        searchStage.show();
    }
    private void displaySearchResults(List<Book> books, Label resultLabel) {
        if (books.isEmpty()) {
            resultLabel.setText("No books found.");
        } else {
            StringBuilder resultText = new StringBuilder();
            for (Book book : books) {
                resultText.append("Title: ").append(book.getTitle()).append("\n")
                        .append("Author: ").append(book.getAuthor()).append("\n")
                        .append("Genre: ").append(book.getGenre()).append("\n")
                        .append("Year: ").append(book.getYear()).append("\n\n");
            }
            resultLabel.setText(resultText.toString());
        }
    }
    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
