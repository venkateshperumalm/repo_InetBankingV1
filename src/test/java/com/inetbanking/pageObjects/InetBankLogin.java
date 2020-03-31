package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InetBankLogin {

	WebDriver driver;
	public InetBankLogin(WebDriver ldriver){
		driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(name="uid")
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