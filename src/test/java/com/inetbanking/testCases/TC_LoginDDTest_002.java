package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.InetBankLoginPO;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDTest_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void logInDDTest(String uName, String password) throws InterruptedException
	{
		InetBankLoginPO bankLogin = new InetBankLoginPO(driver);
		bankLogin.setUserName(uName);
		bankLogin.setPassword(password);
		bankLogin.clickSubmit();

		Thread.sleep(8000);

		if(isAlertPresent()==true){
			driver.switchTo().alert().accept();//close alert of invalid credentials login
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}else{
			Assert.assertTrue(true);
			bankLogin.clickLogout();//close alert of logout
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	//isAlertPresent a boolean type method is used to check whether alert is present or not
	public boolean isAlertPresent(){
		try{
			driver.switchTo().alert().accept();
			return true;
		}catch(NoAlertPresentException e){
			return false;
		}
	}

	@DataProvider(name="LoginData")
	String [][] readFromXls() throws IOException{
		String xlsPath="C:/Users/Venkat Yem/workspace/InetBankingv1/src/test/java/com/inetbanking/testData/InetBanking_LoginData.xlsx";
		int rowCount = XLUtils.getRowCount(xlsPath, "Sheet1");
		int columnCount = XLUtils.getCellCount(xlsPath, "Sheet1", 1);

		String [][] loginData = new String[rowCount][columnCount];

		for (int rowLoop = 1; rowLoop <= rowCount; rowLoop++){
			for (int columnLoop = 0; columnLoop < columnCount; columnLoop++){
				loginData[rowLoop-1][columnLoop] = XLUtils.getCellData(xlsPath, "Sheet1", rowLoop, columnLoop);
			}
		}
		return loginData;
	}
}
