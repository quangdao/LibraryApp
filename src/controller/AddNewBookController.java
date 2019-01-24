package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import business.Address;
import business.Author;
import business.Book;
import business.Member;
import business.Person;
import business.Role;
import business.User;
import dataaccess.ObjectReader;
import dataaccess.ObjectWriter;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewBookController {

	private Stage addBookStage;
    private Stage primaryStage;

    public void setAddBookStage(Stage primaryStage, Stage addBookStage) {
        this.primaryStage = primaryStage;
        this.addBookStage = addBookStage;
    }
    
    public void setMain(MainController mainController) {
        this.main = mainController;
    }
	
	@FXML
	private TextField isbnTextField;
	@FXML
	private TextField titleTextField;
	@FXML
	private TextField checkoutMaxTimeTextField;
	@FXML
	private TextField authorTextField;
	
	
    private MainController main;

    
    public static Book createBook (String isbn, String title, String authorname, Integer checkoutMaxLength) {
    	LocalDateTime currentTime = LocalDateTime.now();
    	String id = "bk"+currentTime.getYear() + currentTime.getMonthValue() + currentTime.getDayOfMonth() + currentTime.getSecond();
    	List<Author> authors = new ArrayList<Author>();
    	authors.add(createAuthor(authorname));
    	return new Book(id, title, isbn, checkoutMaxLength, authors);
    }
    
    public static Author createAuthor( String firstname) {
        LocalDateTime currentTime = LocalDateTime.now();
        String id = ""+currentTime.getYear() + currentTime.getMonthValue() + currentTime.getDayOfMonth() +currentTime.getHour() +currentTime.getMinute()+currentTime.getSecond();
        String lastname = ""+ firstname + currentTime.getMonth() + currentTime.getNano();
        String phone = ""+ currentTime.getNano()+ (int)Math.random();
        String credendtials = ""+ currentTime.getNano() + randomAlphaNumeric(4) + " " + randomAlphaNumeric(9);
        String bio = ""+ randomAlphaNumeric(3) + " " + randomAlphaNumeric(7) + " " + currentTime.getNano();
        Author author = new Author(id, firstname, lastname, phone, createAddress(), credendtials, bio);
        return author;
    } 
    
    
    public static Address createAddress() {
        return new Address(randomAlphaNumeric(5), randomAlphaNumeric(3), randomAlphaNumeric(10), randomAlphaNumeric(5));
    }
    
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String randomAlphaNumeric(int count) {
	    StringBuilder builder = new StringBuilder();
	    while (count-- != 0) {
		    int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		    builder.append(ALPHA_NUMERIC_STRING.charAt(character));
	    }
	    return builder.toString();
    }
    public void ShowMessage(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(main.getPrimaryStage());
        alert.setTitle("Book");
        alert.setHeaderText("Add New Book");
        alert.setContentText(content);
        alert.showAndWait();
    }
    @FXML
    public void addNewBook() {
    	List<Book> books = (List<Book>) ObjectReader.getObjectByFilename("books");
        //List<Member> members = new ArrayList<Member>();

        if (isbnTextField.getText().isEmpty() || titleTextField.getText().isEmpty() || checkoutMaxTimeTextField.getText().isEmpty() || authorTextField.getText().isEmpty()) {
            ShowMessage("Please fill out all fields");
        } else {
        	
            books.add(createBook(isbnTextField.getText(), titleTextField.getText(), authorTextField.getText() , Integer.parseInt(checkoutMaxTimeTextField.getText())));
            ObjectWriter.Output("books", books);
            for (Book book : books) {
                System.out.println(book);
            }
            ShowMessage("Book added successfully");
            this.addBookStage.close();
        }
    	
    }

    @FXML
    public void cancel() {
    	
    }

   
}
