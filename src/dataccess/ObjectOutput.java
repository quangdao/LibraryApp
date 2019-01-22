package dataccess;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;







public class ObjectOutput {	
	public static void Output(String filename, Object obj) {
		String OUTPUT_DIR = System.getProperty("user.dir") 
				+ "\\src\\dataaccess\\storage\\"+filename +".txt";
		try {
			
			// Store Serialized User Object in File
			FileOutputStream fileOutputStream = new FileOutputStream(
					OUTPUT_DIR);
			
			ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
			
			output.writeObject(obj);
			
			output.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	
	}
	
	
}
