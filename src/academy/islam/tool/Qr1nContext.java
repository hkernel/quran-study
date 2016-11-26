package academy.islam.tool;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Qr1nContext {

	//configuration options
	Properties config = new Properties();
	
	public static Qr1nContext INSTANCE = new Qr1nContext();
	
	private Qr1nContext(){
		try {
			
			config.load(new FileReader("java/resources/config.properties"));
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
