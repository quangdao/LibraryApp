package application;
	
import java.util.ArrayList;
import java.util.List;


import business.Address;
import business.Member;
import business.Role;
import business.User;
import dataccess.ObjectReader;
import dataccess.ObjectWriter;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
//public  Main() {
//		//Test only
//		List<User> list = new ArrayList<User>();
//		
//		
//		Address add1 = new Address("2323 N 4th Street", "Fairfield", "IA", "52557");
//		Address add2 = new Address("43434 South 4th Street", "Fairfield", "IA", "52557");
//		Address add3 = new Address("322323 East 4th Street", "Fairfield", "IA", "52557");
//		Member member = new Member("1", "Quang", "Dao", "22456", add1);
//		Member member2 = new Member("2", "Penh", "Lim", "34556346", add2);
//		Member member3 = new Member("2", "Jack", "Ma", "565869", add3);
//		User user = new User(member, "admin", "admin", Role.ADMIN);
//		User user2 = new User(member2, "super", "super", Role.SUPERADMIN);
//		User user3 = new User(member3, "librarian", "librarian", Role.LIBRARIAN);
//		
//		list.add(user);
//		list.add(user2);
//		list.add(user3);
//	
//
//
//
//		ObjectWriter.Output("users", list);
//		
//		List<User> user4 = (List<User>)ObjectReader.getObjectByFilename("users"); 
//		for (User userobj : user4){
//			System.out.println(userobj);
//		}
//
//}
	
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
