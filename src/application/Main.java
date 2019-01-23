package application;
	
import java.util.ArrayList;
import java.util.List;


import business.Address;
import dataccess.ObjectReader;
import dataccess.ObjectWriter;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
//	public  Main() {
//		//Test only
//		List<Object> list = new ArrayList<Object>();
//		Address add1 = new Address("2323 N 4th Street", "Fairfield", "IA", "52557");
//		Address add2 = new Address("43434 N 4th Street", "Fairfield", "IA", "52557");	
//		list.add(add1);
//		list.add(add2);
//		
//		//new ObjectOutput("addresses", add1);
//		ObjectWriter.Output("myobject", list);
//		List<Address> listAdd = (List<Address>)ObjectReader.getObjectByFilename("myobject");
//		for (Address address : listAdd) {
//			System.out.println(address);
//		}
//	}
	
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
