package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class ProperitiesUtility {
	
	public static String getData(String key) throws IOException {
		
		//create file class object
		File file=new File("C:\\Users\\Nickson Abraham\\OneDrive\\Desktop\\Testdata.properties");
		
		
		//create file reader class object
		
		FileReader reader =new FileReader(file);
		
		//create properties class object
		
		Properties prop=new Properties();
		
		//load properties file
		prop.load(reader);
		//call getValue()
		
		return (String) prop.get(key);
		
		
	}

}
