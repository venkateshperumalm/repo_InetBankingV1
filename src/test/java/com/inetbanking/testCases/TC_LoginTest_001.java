package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.InetBankLoginPO;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void logInTest() throws IOException{
		InetBankLoginPO objLogin = new InetBankLoginPO(driver);
		objLogin.setUserName(userName);
		objLogin.setPassword(password);
		logger.info("Username and password is given");
		objLogin.clickSubmit();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			Assert.assertTrue(true);
			logger.info("Logged in!");
		}else{
			//loginScreenshot is a BaseClass method to capture screenshot
			loginScreenshot(driver, "logInTest");
			Assert.assertTrue(false);
			logger.info("Not Logged in!");
		}
	}
}
