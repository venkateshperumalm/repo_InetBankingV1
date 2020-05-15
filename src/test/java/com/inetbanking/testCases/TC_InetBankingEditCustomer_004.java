package com.inetbanking.testCases;

import java.lang.annotation.Annotation;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.InetBankLoginPO;
import com.inetbanking.pageObjects.InetBankingAddCustomerPO;
import com.inetbanking.pageObjects.InetBankingEditCustomerPO;

public class TC_InetBankingEditCustomer_004 extends BaseClass{

	@Test
	public void editCustomer() throws InterruptedException{
		InetBankLoginPO objLogin = new InetBankLoginPO(driver);
		objLogin.setUserName(userName);
		objLogin.setPassword(password);
		objLogin.clickSubmit();

		logger.info("Logged into gurudemo");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		InetBankingEditCustomerPO customerEdit = new InetBankingEditCustomerPO(driver);
		customerEdit.clickEditMenu();
		customerEdit.getCustomerId(98742);
		customerEdit.clickSubmit();
		logger.info("Edit customer page");

		Thread.sleep(3000);
		
		InetBankingAddCustomerPO customerPo= new InetBankingAddCustomerPO(driver);
		//Annotation[]declaredAnnotations = InetBankingAddCustomerPO.class.getDeclaredAnnotations();
		Annotation[]anno = InetBankingAddCustomerPO.class.getAnnotations();
		String annotation =anno.getClass().getName();
		System.out.println(annotation);
		//declaredAnnotations.clone();
		customerPo.enterAddress("new address");
		customerPo.enterCity("Mad");
		customerPo.enterState("Tamilnadu");
		customerPo.enterPinno("894562");
		customerPo.enterTelephone("8523691470");
		customerPo.enterEmailid("mad12@gmail.com");
		
		customerEdit.clickEditSubmit();
		
		if(isEditAlertPresent()==true){
			driver.switchTo().alert().accept();
			logger.info("Alert is present");
			driver.switchTo().defaultContent();
			logger.info("Unauthoried login! ");
			Assert.assertTrue(false);
		}else{
			Assert.assertTrue(true);
			logger.info("Edit customer screen");
			driver.switchTo().defaultContent();
		}

	}
	public boolean isEditAlertPresent(){
		try{
			driver.switchTo().alert().accept();
			return true;
		}catch(NoAlertPresentException e){
			return false;
		}
	}}