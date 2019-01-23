package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends Application {
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../ui/main/MainView.fxml"));
        primaryStage = stage;
        primaryStage.setTitle("Library App");
        primaryStage.setScene(new Scene(root, 300, 275));
        // primaryStage.show();
        this.showLogin();
    }

    public void showLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class.getResource("../ui/LoginView.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Login...");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            LoginController controller = loader.getController();
            controller.setLoginStage(primaryStage, dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showAddNewMember() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class.getResource("../ui/AddNewLibraryMemberView.fxml"));
            AnchorPane memberPage = loader.load();

            // Create the dialog Stage.
            Stage memberStage = new Stage();
            memberStage.setTitle("Library Member");
            memberStage.initModality(Modality.WINDOW_MODAL);
            memberStage.initOwner(primaryStage);
            Scene scene = new Scene(memberPage);
            memberStage.setScene(scene);

            AddNewLibraryMemberController controller = loader.getController();
            controller.setMain(this);

            // Show the dialog and wait until the user closes it
            memberStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showAddNewBook() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class.getResource("../ui/AddNewBookView.fxml"));
            AnchorPane memberPage = loader.load();

            // Create the dialog Stage.
            Stage memberStage = new Stage();
            memberStage.setTitle("New Book");
            memberStage.initModality(Modality.WINDOW_MODAL);
            memberStage.initOwner(primaryStage);
            Scene scene = new Scene(memberPage);
            memberStage.setScene(scene);

            AddNewBookController controller = loader.getController();
            controller.setMain(this);

            // Show the dialog and wait until the user closes it
            memberStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showSearchBook() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class.getResource("../ui/SearchBookView.fxml"));
            AnchorPane memberPage = loader.load();

            // Create the dialog Stage.
            Stage memberStage = new Stage();
            memberStage.setTitle("Search Book");
            memberStage.initModality(Modality.WINDOW_MODAL);
            memberStage.initOwner(primaryStage);
            Scene scene = new Scene(memberPage);
            memberStage.setScene(scene);

            SearchBookController controller = loader.getController();
            controller.setMain(this);

            // Show the dialog and wait until the user closes it
            memberStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showCopyBook() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class.getResource("../ui/AddBookCopyView.fxml"));
            AnchorPane memberPage = loader.load();

            // Create the dialog Stage.
            Stage memberStage = new Stage();
            memberStage.setTitle("Copy Book");
            memberStage.initModality(Modality.WINDOW_MODAL);
            memberStage.initOwner(primaryStage);
            Scene scene = new Scene(memberPage);
            memberStage.setScene(scene);

            AddBookCopyController controller = loader.getController();
            controller.setMain(this);

            // Show the dialog and wait until the user closes it
            memberStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showCheckoutRecords() {

    }
}
