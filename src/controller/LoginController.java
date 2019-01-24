package controller;

import java.util.List;

import business.Role;
import business.User;
import dataaccess.ObjectReader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    private MainController main;

    @FXML
    private TextField userIdTextField;
    @FXML
    private PasswordField passwordTextField;

    private Stage loginStage;
    private Stage primaryStage;

    public void setMain(MainController mainController) {
        this.main = mainController;
    }

    public void setLoginStage(Stage primaryStage, Stage loginStage) {
        this.primaryStage = primaryStage;
        this.loginStage = loginStage;
    }

    public User doLogin(String username, String password) {
        List<User> users = (List<User>) ObjectReader.getObjectByFilename("users");
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @FXML
    public void login() {
        String username = userIdTextField.getText();
        String password = passwordTextField.getText();
        User user = doLogin(username, password);

        if (user != null) {
            loginStage.close();
            primaryStage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Message");
            alert.setHeaderText("Login");
            alert.setContentText("Invalid username and password, please try again");
            alert.showAndWait();
        }
    }

    public Role getLoginRole() {
        String username = userIdTextField.getText();
        String password = passwordTextField.getText();
        User user = doLogin(username, password);
        return user.getRole();
    }
}