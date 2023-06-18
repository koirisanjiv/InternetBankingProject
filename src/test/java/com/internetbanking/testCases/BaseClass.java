package com.internetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.internetbanking.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseUrl = readconfig.getApplicationUrl();
	public String userName = readconfig.getUserName();
	public String password = readconfig.getPassword();

	
	
	public static Logger logger;
	public WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{
		 logger = Logger.getLogger("ebanking");
		 PropertyConfigurator.configure("Log4j.properties");
		 
			
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chromedriver",readconfig.getChromepath());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.geckodriver",readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edgedriver",readconfig.getMsEdgepath());
			driver = new EdgeDriver();
		}
		
		Thread.sleep(5000);
	
		driver.get(baseUrl);
	   
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname + ".png");
		
		FileUtils.copyFile(source, target);
		
		System.out.println("Screenshot taken");
		
	}
	public String randomString()
	{
		String genratedString = RandomStringUtils.randomAlphabetic(5);
		return genratedString;
	}
	
	public String randomStringNum()
	{
		String genratedNumber = RandomStringUtils.randomNumeric(5);
		return genratedNumber;
	}
}
