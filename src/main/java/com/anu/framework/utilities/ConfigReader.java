package com.anu.framework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import com.anu.framework.constants.Constants;

public class ConfigReader {
	
	Properties prop; 
	//Properties is a built-in Java class which is used to read the data from properties file.
	//It is designed specifically to store and retrieve key-value pairs.
	
	FileInputStream f;
	//FileInputStream is a built-in Java class which is used to read data from a file in the form of bytes.
	
	
	public ConfigReader() {
		try {
			prop = new Properties();// Creates an empty Properties object.
			
			f = new FileInputStream(Constants.CONFIG_FILE_PATH);
			//Java says:"Go to this file path and open the file for reading."
			//It returns a FileInputStream object that represents the opened file stream.
			//and assigns it to the variable f.
			//Think of f as connection to the opened file, which can be used to read data from that file.
			
			prop.load(f);
			//Read the contents coming from the file stream f.
			//The load() method of the Properties class is used to read the key-value pairs from the file stream (f) and load them into the Properties object (prop).
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
		//getProperty() is a method of the Properties class that retrieves the value associated with the specified key ("browser" in this case) from the Properties object (prop).
	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}
	
	public String getUsername() {
		return prop.getProperty("username");
	}
	
	public String getPassword() {
		return prop.getProperty("password");
	}
	
	
	
}
