package com.internetbanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.internetbanking.pageObject.LoginPage;



public class TC_LoginTest_01 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
	
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(userName);
		logger.info("user id entered");
		
		lp.setPasword(password);
		logger.info("Password entered");
		
		lp.clickButton();
		Thread.sleep(3000);
		
		if(driver.getTitle().contains("Manager"))
		{
			logger.info("Test case passed");
			Assert.assertTrue(true);
			
		}
		else
		{	
			captureScreen(driver,"longinTest");
			logger.info("Test case failed");
			Assert.assertTrue(false);
		
		}
		
	}

}
