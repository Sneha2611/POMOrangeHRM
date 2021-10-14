package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties properties;
	
	public ReadConfig() {
		// TODO Auto-generated constructor stub
		File file = new File("./src/main/resources/config.properties");
		
		try {
			FileInputStream fis  =  new FileInputStream(file);
			properties = new Properties();
			properties.load(fis);
		} 
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
		public String getApplocationUrl()
		{
			String url = properties.getProperty("url");
			return url;
		}
		
	
		public String getChromeBrowserPath()
		{
			String chromepath = properties.getProperty("chromepath");
			return chromepath;
		}
		
		public String getFirefoxBrowserPath()
		{
			String firefoxpath = properties.getProperty("firefoxpath");
			return firefoxpath;
		}
		
		
		public String getUname()
		{
			String user = properties.getProperty("uname");
			return user;
		}
		
		
		public String getPwd()
		{
			String pass = properties.getProperty("pwd");
			return pass;
		}
}
