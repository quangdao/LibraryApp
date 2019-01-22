package application;
	
import java.util.List;

import com.sun.corba.se.impl.orb.ParserTable.TestAcceptor1;

import business.Address;
import dataccess.ObjectInput;
import dataccess.ObjectOutput;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
	public  Main() {
		//Test only
		Address add1 = new Address("1000646546549999999 N 4th Street", "Fairfield", "IA", "52557");	
		//new ObjectOutput("addresses", add1);
		ObjectOutput.Output("addresses", add1);
		List<Object> listAdd = ObjectInput.getObjectsByFilename("addresses");
		for (Object address : listAdd) {
			System.out.println(address);
		}
	}
	
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
