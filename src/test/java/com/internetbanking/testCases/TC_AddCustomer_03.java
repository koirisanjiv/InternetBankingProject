package com.internetbanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.internetbanking.pageObject.AddNewCustomerPage;
import com.internetbanking.pageObject.LoginPage;

public class TC_AddCustomer_03 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
	
		logger.info("user start login");
		
		lp.setUserName(userName);
		lp.setPasword(password);
		lp.clickButton();
		Thread.sleep(3000);
		logger.info("Login done");
		System.out.println("Login done");
		
		
		AddNewCustomerPage addcustomer = new AddNewCustomerPage(driver);
	
		
		addcustomer.clickAddNewCustomer();
		System.out.println("Clicked on add new customer link");
		driver.manage().window().maximize();
		System.out.println("Window is maximize");
		logger.info("user start adding new customer");
		Thread.sleep(3000);
		addcustomer.customerName("Anderson");
		System.out.println("Customer name filled");
		addcustomer.clickgender("male");
		addcustomer.dateofbirth("22","05", "1995");
		Thread.sleep(3000);
		addcustomer.address("123, maxico,russia");
		addcustomer.cityName("maxico");
		addcustomer.stateName("russia");
		addcustomer.pinNumber("456512");// it must be 6 digit
		addcustomer.telephoneNumber("1234567890");
		
		String email = randomString()+"@gmail.com";
		addcustomer.emailAddress(email);
		
		addcustomer.clickSubmit();
		
		Thread.sleep(3000);
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(result == true)
		{
			Assert.assertTrue(true);
			logger.info("new customer added successfully");
		}
		else
		{
			captureScreen(driver,"AddNewCustomer");
			Assert.assertFalse(false);
			logger.info("Getting error to add new customer");
		}
	}
	

}
