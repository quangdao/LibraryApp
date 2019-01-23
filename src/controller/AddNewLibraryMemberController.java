package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
	
	public static Person createAuthor(String firstname, String lastname, String phone, Address address, String credendtials, String bio) {		
		LocalDateTime currentTime = LocalDateTime.now();
		String id = ""+currentTime.getYear() + currentTime.getMonth() + currentTime.getDayOfMonth() +currentTime.getHour() +currentTime.getMinute()+currentTime.getSecond();
		Person person = new Author(id, firstname, lastname, phone, address, credendtials,bio); 
		return person;
	}
	
	public static Member createMember(String firstname, String lastname, String phone, Address address) {		
		LocalDateTime currentTime = LocalDateTime.now();
		String id = ""+currentTime.getYear() + currentTime.getMonth() + currentTime.getDayOfMonth() +currentTime.getHour() +currentTime.getMinute()+currentTime.getSecond();
		return new Member(id, firstname, lastname, phone, address);
	}
	
	public static User createUser (Member member, String username, String password, Role role) {
		return new User(member, username, password, role);
	}
    
	
	
    @FXML
    public void addNewMember() {
    	List<User> users = (List<User>)ObjectReader.getObjectByFilename("users"); 
    	
    	users.add(createUser(createMember(firstNameTextField.getText(), lastNameTextField.getText(), phoneTextField.getText(), createAddress(streetTextField.getText(), cityTextField.getText(), stateTextField.getText(), zipTextField.getText())), 
    			"", "", Role.MEMBER));    
    	//users.add(createUser(createMember("Jack", "Ma", "93933722", createAddress("123 North Street", "Fairfield", "Iowa", "52557")), "admin", "adminpassword", Role.ADMIN));
    	//users.add(createUser(createMember("John", "Wick", "22432345", createAddress("999 south Street", "Fairfield", "Iowa", "52557")), "super", "superpassword", Role.SUPERADMIN));
    	ObjectWriter.Output("users", users);
    	
    	
//		for (User userobj : users){
//			System.out.println(userobj);
//		}
    }

    @FXML
    public void cancel() {
    }


}
