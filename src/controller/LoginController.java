package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField userIdTextField;
    @FXML
    private PasswordField passwordTextField;

    private Stage loginStage;
    private Stage primaryStage;

    public void setLoginStage(Stage primaryStage, Stage loginStage) {
        this.primaryStage = primaryStage;
        this.loginStage = loginStage;
    }

    @FXML
    public void close() {
        loginStage.close();
        primaryStage.show();
    }

    public void cancel() {
        loginStage.close();
        primaryStage.close();
    }
}