package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InetBankLoginPO {

	WebDriver driver;
	public InetBankLoginPO(WebDriver ldriver){
		driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(how=How.NAME, using="uid")
	@CacheLookup
	WebElement txtUser;

	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[@href='Logout.php']")
	@CacheLookup
	WebElement btnLogout;

	public void setUserName(String uname){
		txtUser.sendKeys(uname);
	}
	public void setPassword(String pswd){
		txtPassword.sendKeys(pswd);
	}
	public void clickSubmit(){
		btnLogin.click();
	}
	public void clickLogout(){
		btnLogout.click();
	}
}