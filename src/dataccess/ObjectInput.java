package dataccess;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import business.Address;

public class ObjectInput {
	
	public static Object getObjectByFilename(String filename) {
		String OUTPUT_DIR = System.getProperty("user.dir") 
				+ "\\src\\dataaccess\\storage\\"+ filename +".txt";
		boolean isExist = true;
		Object object = new Object();
		try {
			
			//Read from the stored file
			FileInputStream fileInputStream = new FileInputStream(new File(
					OUTPUT_DIR));
			ObjectInputStream input = new ObjectInputStream(fileInputStream);
			while(isExist) {
				if (fileInputStream.available() != 0) {
					object = input.readObject();
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
		return object;
		
		
	}
	
}
