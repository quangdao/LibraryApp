package dataccess;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import business.Address;

public class ObjectInput {
	
	public static List<Object> getObjectsByFilename(String filename) {
		String OUTPUT_DIR = System.getProperty("user.dir") 
				+ "\\src\\dataaccess\\storage\\"+ filename +".txt";
		List<Object> list = new ArrayList<Object>();
		boolean isExist = true;
		try {
		
			//Read from the stored file
			FileInputStream fileInputStream = new FileInputStream(new File(
					OUTPUT_DIR));
			ObjectInputStream input = new ObjectInputStream(fileInputStream);
			while(isExist) {
				if (fileInputStream.available() != 0) {
					Address address = (Address) input.readObject();
					list.add(address);
				}
				else
					isExist = false;
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	
}
