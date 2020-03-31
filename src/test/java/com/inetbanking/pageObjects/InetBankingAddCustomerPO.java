package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InetBankingAddCustomerPO {

	WebDriver ldriver;
	public InetBankingAddCustomerPO(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@href='addcustomerpage.php']")
	@CacheLookup
	WebElement newCustomer;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement customerName;
	
	@FindBy(name = "rad1")
	@CacheLookup
	WebElement gender;
	
	@FindBy(name = "dob")
	@CacheLookup
	WebElement dateOfBirth;
	
	@FindBy(name = "addr")
	@CacheLookup
	WebElement address;
	
	@FindBy(name = "city")
	@CacheLookup
	WebElement cityName;
	
	@FindBy(name = "state")
	@CacheLookup
	WebElement stateName;
	
	@FindBy(name = "pinno")
	@CacheLookup
	WebElement pinNo;
	
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement telephoneNo;
	
	@FindBy(name = "emailid")
	@CacheLookup
	WebElement emailId;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name = "sub")
	@CacheLookup
	WebElement buttonSubmit;
	
	public void clickNewCustomer(){
		newCustomer.click();	
	}
	
	public void enterCustomer(String custName){
		customerName.sendKeys(custName);	
	}
	
	public void enterGender(String genderT){
		gender.sendKeys(genderT);	
	}
	
	public void enterDob(String dd, String mm, String yyyy){
		dateOfBirth.sendKeys(String.valueOf(dd));
		dateOfBirth.sendKeys(String.valueOf(mm));
		dateOfBirth.sendKeys(String.valueOf(yyyy));
	}
	
	public void enterAddress(String addr){
		address.sendKeys(addr);	
	}
	
	public void enterCity(String city){
		cityName.sendKeys(city);	
	}
	
	public void enterState(String state){
		stateName.sendKeys(state);	
	}
	
	public void enterPinno(String pin){
		pinNo.sendKeys(String.valueOf(pin));	
	}
	
	public void enterTelephone(String telephone){
		telephoneNo.sendKeys(String.valueOf(telephone));	
	}
	
	public void enterEmailid(String email){
		emailId.sendKeys(email);	
	}
	
	public void enterPassword(String pswd){
		password.sendKeys(String.valueOf(pswd));	
	}
	
	public void clickSubmit(){
		buttonSubmit.click();	
	}
}
