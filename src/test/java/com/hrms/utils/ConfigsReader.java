package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	
	public static Properties prop;
/**
 * This method will read properties file
 * @param filePath
 * @return 
 */
	public static void readProperties(String filePath) {
		try {
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		/*this method will retrieve any properties,any values, any key that i pass
		 * 
		 */
	
	/**
	 * This method will return value of specified key
	 * @param String key
	 * @return String key
	 */
		public static String getProperty(String key) {
			
			return prop.getProperty(key); 
			
		}
	
	}

