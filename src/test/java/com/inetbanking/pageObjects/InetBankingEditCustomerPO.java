package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class InetBankingEditCustomerPO{

	WebDriver driver;

	public InetBankingEditCustomerPO(WebDriver lDriver){
		driver = lDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using = "//a[@href='EditCustomer.php']")
	@CacheLookup
	WebElement editMenu;

	@FindBy(how=How.NAME, using="cusid")
	@CacheLookup
	WebElement custId;

	@FindBy(how=How.NAME, using="AccSubmit")
	@CacheLookup
	WebElement btnSubmit;

	@FindBy(name="sub")
	@CacheLookup
	WebElement btnSub;
	
	
	public void clickEditMenu(){
		editMenu.click();
	}

	public void getCustomerId(int customerId){
		custId.sendKeys(String.valueOf(customerId));
	}

	public void clickSubmit(){
		btnSubmit.click();
	}
	public void clickEditSubmit(){
		btnSub.click();
	}
}
