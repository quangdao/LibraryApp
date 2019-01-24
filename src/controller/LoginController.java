package controller;

import java.util.List;

import business.User;
import dataccess.ObjectReader;
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
       
        System.out.println(user);
        

        Alert alert;
       
        
        if (user != null) {
        	 alert = new Alert(Alert.AlertType.INFORMATION);
        	 alert.initOwner(main.getPrimaryStage());
             alert.setTitle("Message");
             alert.setHeaderText("Login");
             alert.setContentText("Logged in successfully!");
             alert.showAndWait();
             loginStage.close();
             
             primaryStage.show();
		}
       else {
    	   	alert = new Alert(Alert.AlertType.WARNING);
	    	alert.initOwner(main.getPrimaryStage());
	        alert.setTitle("Message");
	        alert.setHeaderText("Login");
	        alert.setContentText("Invalid username and password, please try again");
	        alert.showAndWait();           
		}
        
        return user;
        
    }

    public void cancel() {
        loginStage.close();
        primaryStage.close();
    }
    
    
}