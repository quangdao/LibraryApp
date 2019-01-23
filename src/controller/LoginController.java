package controller;

import java.util.List;

import business.User;
import dataccess.ObjectReader;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdk.management.resource.internal.inst.UnixAsynchronousSocketChannelImplRMHooks;

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
    
    public User doLogin(String username, String password) {
    	List<User> users = (List<User>)ObjectReader.getObjectByFilename("users");
    	for (User user : users) {
			if (user.getUsername().equals(username) == true && user.getPassword().equals(password) == true) {
				return user;
			}	
    		
    	}    	
		return null;	
    }

    @FXML
    public User login() {
    //public void login() {
    	String username = userIdTextField.getText();
    	String password = passwordTextField.getText();
    	User user = doLogin(username, password);
    	
    	
        loginStage.close();
        primaryStage.show();
        System.out.println(user);
        return user;
    }

    public void cancel() {
        loginStage.close();
        primaryStage.close();
    }
    
    
}