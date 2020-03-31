package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig objReadConfig = new ReadConfig();
	public String baseUrl = objReadConfig.getApplicationUrl();
	public String userName = objReadConfig.getUserName();
	public String password = objReadConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browserName){

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", objReadConfig.getChromePath());
			driver= new ChromeDriver();
		}else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", objReadConfig.getGeckoPath());
			driver= new FirefoxDriver();
		}else if(browserName.equals("iExplorer")){
			System.setProperty("webdriver.ie.driver", objReadConfig.getExplorerPath());
			driver= new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public void loginScreenshot(WebDriver driver, String testcaseName) throws IOException{
		String timestampSs= new SimpleDateFormat("yyyy.MM.dd_hh.mm.ss").format(new Date());

		TakesScreenshot loginScreenshot = (TakesScreenshot) driver;
		File sourceSs= loginScreenshot.getScreenshotAs(OutputType.FILE);
		File targetSs= new File("C://Users//Venkat Yem//workspace//InetBankingv1//Screenshots//" + testcaseName + "_" + timestampSs + ".png");
		FileUtils.copyFile(sourceSs, targetSs);
		System.out.println("Taken screenshot");
	}
}
