package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
	public Properties prop;
	public BaseClass() throws IOException{
		prop=new Properties();
		
		try {
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//com//PlayGroundAPI//resources//Config.property");
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException i) {
			i.printStackTrace();
		}
		
	}
	
}
