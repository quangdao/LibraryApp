package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import business.Address;
import business.Author;
import business.Member;
import business.Person;
import business.Role;
import business.User;
import dataccess.ObjectReader;
import dataccess.ObjectWriter;
import dataccess.ObjectReader;

public class AddNewLibraryMemberController {
    private MainController main;

    private Stage addMemberStage;
    private Stage primaryStage;

    public void setAddMemberStage(Stage primaryStage, Stage addMemberStage) {
		this.primaryStage = primaryStage;
		this.addMemberStage = addMemberStage;
	}
    @FXML
    private TextField idTextField;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField streetTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private TextField stateTextField;
    @FXML
    private TextField zipTextField;

    public void setMain(MainController mainController) {
        this.main = mainController;
    }


    public static Address createAddress(String street, String city, String state, String zip) {
		return new Address(street, city, state, zip);
	}

	public static Person createAuthor(String id,String firstname, String lastname, String phone, Address address, String credendtials, String bio) {
		//LocalDateTime currentTime = LocalDateTime.now();
		//String id = ""+currentTime.getYear() + currentTime.getMonth() + currentTime.getDayOfMonth() +currentTime.getHour() +currentTime.getMinute()+currentTime.getSecond();
		Person person = new Author(id, firstname, lastname, phone, address, credendtials,bio);
		return person;
	}

	public static Member createMember(String id, String firstname, String lastname, String phone, Address address) {
		//LocalDateTime currentTime = LocalDateTime.now();
		//String id = ""+currentTime.getYear() + currentTime.getMonth() + currentTime.getDayOfMonth() +currentTime.getHour() +currentTime.getMinute()+currentTime.getSecond();
		return new Member(id, firstname, lastname, phone, address);
	}

//	public static User createUser (Member member, String username, String password, Role role) {
//		return new User(member, username, password, role);
//	}

	public  void ShowMessage(String content) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		 alert.initOwner(main.getPrimaryStage());
	     alert.setTitle("Member");
	     alert.setHeaderText("Add New Member");
	     alert.setContentText(content);
	     alert.showAndWait();
	}

    @FXML
    public void addNewMember() {
    	List<Member> members = (List<Member>)ObjectReader.getObjectByFilename("members");
    	if (idTextField.getText().isEmpty() || firstNameTextField.getText().isEmpty() || lastNameTextField.getText().isEmpty() || phoneTextField.getText().isEmpty() || streetTextField.getText().isEmpty() || cityTextField.getText().isEmpty() || stateTextField.getText().isEmpty() ||zipTextField.getText().isEmpty() ) {
    		ShowMessage("Please fill out all fields");
		}
    	else {
    		members.add(createMember(idTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText(), phoneTextField.getText(), createAddress(streetTextField.getText(), cityTextField.getText(), stateTextField.getText(), zipTextField.getText())));
        	ObjectWriter.Output("members", members);
        	for (Member member : members) {
    			System.out.println(member);
    		}
    		ShowMessage("Member created successfully");
        	this.addMemberStage.close();
		}



    }

    @FXML
    public void cancel() {
    	this.addMemberStage.close();
    }


}
