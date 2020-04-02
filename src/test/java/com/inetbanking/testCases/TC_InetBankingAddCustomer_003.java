package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.InetBankLogin;
import com.inetbanking.pageObjects.InetBankingAddCustomerPO;

public class TC_InetBankingAddCustomer_003 extends BaseClass{

	@Test
	public void addInetBankCustomer() throws InterruptedException, IOException{

		InetBankLogin objLogin = new InetBankLogin(driver);
		objLogin.setUserName(userName);
		objLogin.setPassword(password);
		objLogin.clickSubmit();

		logger.info("Logged into gurudemo");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		InetBankingAddCustomerPO addCustomer = new InetBankingAddCustomerPO(driver);
		addCustomer.clickNewCustomer();

		logger.info("Customer Registration Page");
		addCustomer.enterCustomer(RandomStringUtils.randomAlphabetic(7));
		addCustomer.enterGender("male");
		addCustomer.enterDob(RandomStringUtils.randomNumeric(1,31), RandomStringUtils.randomNumeric(1,12), "1950");
		Thread.sleep(5000);

		addCustomer.enterAddress("cassie street");
		addCustomer.enterCity("wuhan");
		addCustomer.enterState("Tokyo");
		addCustomer.enterPinno("565669");
		addCustomer.enterTelephone("45682312");
		addCustomer.enterEmailid(RandomStringUtils.randomAlphanumeric(6) + "@gmail.com");
		addCustomer.enterPassword(RandomStringUtils.randomAlphanumeric(8));
		addCustomer.clickSubmit();

		logger.info("Submitted a new customer");
		Thread.sleep(8000);
		
		boolean resultCust = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(resultCust == true){
			Assert.assertTrue(true);
			logger.info("Welcome! New customer");
		}else{
			logger.info("No customer added");
			loginScreenshot(driver,"addInetBankCustomer");
			//driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
	}
}
