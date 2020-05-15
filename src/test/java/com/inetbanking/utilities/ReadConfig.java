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
		return objProp.getProperty("baseUrl");
	}

	public String getUserName() {
		return objProp.getProperty("userName");
	}

	public String getPassword() {
		return objProp.getProperty("password");
	}

	public String getChromePath() {
		return objProp.getProperty("chromePath");
	}

	public String getGeckoPath() {
		return objProp.getProperty("geckoPath");
	}

	public String getExplorerPath() {
		return objProp.getProperty("explorerPath");
	}
}
