package application;
	
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import business.Address;
import business.Author;
import business.Book;
import business.Member;
import business.Role;
import business.User;
import dataaccess.ObjectReader;
import dataaccess.ObjectWriter;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	

	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		
		launch(args);
		
		
		
	}
}
