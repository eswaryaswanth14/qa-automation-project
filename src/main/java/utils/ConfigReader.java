package utils;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigReader {
	
	Properties p=new Properties();
	
	public String loadConfig() throws IOException {
		FileInputStream f=new FileInputStream("C:\\Sel Practice\\qa-automation-project\\src\\test\\resources\\config.properties");
		p.load(f);
		 return p.getProperty("url");
		

	}
	
	
	

}
