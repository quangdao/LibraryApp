package controller;

import business.Role;
import dataaccess.SampleData;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainController extends Application {
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        String OUTPUT_DIR = System.getProperty("user.dir")
                + "//src//dataaccess//storage//users.txt";
        File userFile = new File(OUTPUT_DIR);
        if (!userFile.exists()) {
            SampleData.createSampleData();
        }

        Parent root = FXMLLoader.load(getClass().getResource("../ui/main/MainView.fxml"));
        primaryStage = stage;
        primaryStage.setTitle("Library App");
        primaryStage.setScene(new Scene(root));

        Button btnAddMember = (Button) root.lookup("#btnAddMember");
        Button btnAddBook = (Button) root.lookup("#btnAddBook");
        Button btnShowCheckoutBook = (Button) root.lookup("#btnShowCheckoutBook");

        Role loginRole = this.showLogin();

        if (loginRole == Role.ADMIN) {
            btnShowCheckoutBook.setVisible(false);
        }
        if (loginRole == Role.LIBRARIAN) {
            btnAddMember.setVisible(false);
            btnAddBook.setVisible(false);
        }
    }

    public Role showLogin() {
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
            controller.setMain(this);
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.getLoginRole();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
            controller.setAddMemberStage(primaryStage, memberStage);
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
            controller.setAddBookStage(primaryStage, memberStage);
            controller.setMain(this);

            // Show the dialog and wait until the user closes it
            memberStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showPrintCheckoutRecord() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class.getResource("../ui/PrintCheckoutRecordsView.fxml"));
            AnchorPane memberPage = loader.load();

            // Create the dialog Stage.
            Stage memberStage = new Stage();
            memberStage.setTitle("Search Book");
            memberStage.initModality(Modality.WINDOW_MODAL);
            memberStage.initOwner(primaryStage);
            Scene scene = new Scene(memberPage);
            memberStage.setScene(scene);

            PrintCheckoutRecordController controller = loader.getController();
            controller.setMain(this);

            // Show the dialog and wait until the user closes it
            memberStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showCheckoutBook() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class.getResource("../ui/CheckoutBookView.fxml"));
            AnchorPane memberPage = loader.load();

            // Create the dialog Stage.
            Stage memberStage = new Stage();
            memberStage.setTitle("Checkout Book");
            memberStage.initModality(Modality.WINDOW_MODAL);
            memberStage.initOwner(primaryStage);
            Scene scene = new Scene(memberPage);
            memberStage.setScene(scene);

            CheckoutBookController controller = loader.getController();
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
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class.getResource("../ui/CheckoutRecordsView.fxml"));
            AnchorPane memberPage = loader.load();

            // Create the dialog Stage.
            Stage memberStage = new Stage();
            memberStage.setTitle("All Checkout Records");
            memberStage.initModality(Modality.WINDOW_MODAL);
            memberStage.initOwner(primaryStage);
            Scene scene = new Scene(memberPage);
            memberStage.setScene(scene);

            CheckoutRecordsController controller = loader.getController();
            controller.setMain(this);

            // Show the dialog and wait until the user closes it
            memberStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showSearchOverDueBook() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class.getResource("../ui/SearchOverdueBook.fxml"));
            AnchorPane memberPage = loader.load();

            // Create the dialog Stage.
            Stage memberStage = new Stage();
            memberStage.setTitle("Overdue Checkout Records");
            memberStage.initModality(Modality.WINDOW_MODAL);
            memberStage.initOwner(primaryStage);
            Scene scene = new Scene(memberPage);
            memberStage.setScene(scene);

            SearchOverdueBookController controller = loader.getController();
            controller.setMain(this);

            // Show the dialog and wait until the user closes it
            memberStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
