package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties objProp;
	public ReadConfig(){

		File objFile = new File("./Configuration/config.properties");
		try{
			FileInputStream fis= new FileInputStream(objFile);
			objProp= new Properties();
			objProp.load(fis);
		}catch(Exception e){
			System.out.println(""+e.getMessage());
		}
	}

	public String getApplicationUrl() {
		String applicationUrl = objProp.getProperty("baseUrl");
		return applicationUrl;
	}

	public String getUserName() {
		String userName = objProp.getProperty("userName");
		return userName;
	}

	public String getPassword() {
		String passw0rd = objProp.getProperty("password");
		return passw0rd;
	}

	public String getChromePath() {
		String chromePath = objProp.getProperty("chromePath");
		return chromePath;
	}

	public String getGeckoPath() {
		String geckoPath = objProp.getProperty("geckoPath");
		return geckoPath;
	}

	public String getExplorerPath() {
		String explorerPath = objProp.getProperty("explorerPath");
		return explorerPath;
	}
}
