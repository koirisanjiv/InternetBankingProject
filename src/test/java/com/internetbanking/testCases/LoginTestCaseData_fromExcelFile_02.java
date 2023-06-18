package com.internetbanking.testCases;

import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.internetbanking.pageObject.LoginPage;
import com.internetbanking.utilities.XLUtils;

public class LoginTestCaseData_fromExcelFile_02  extends BaseClass{

	@Test(dataProvider = "LoginData_FromExcel")
	public void loginDataFromExcel(String user, String pwd) throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName( user);
		lp.setPasword(pwd);
		lp.clickButton();
		
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
		
			lp.clickLogout();
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
	
		}
//		if(driver.getTitle().equals(" GTPL Bank Manager HomePage "))
//		{
//			logger.info("Test case passed");
//			Assert.assertTrue(true);
//			
//		}
//		else
//		{	
//			captureScreen(driver,"longinTest");
//			logger.info("Test case failed");
//			Assert.assertTrue(false);
//		
//		}
//		driver.navigate().refresh();
//		 Thread.sleep(5000);
		
	}
	
	// to check whether the alert is present or not
	// this is user defined method
	public boolean isAlertPresent() throws InterruptedException
	{
		try
		{
			driver.switchTo().alert();
			//Thread.sleep(3000);
			return true;
		}
		catch (NoAlertPresentException e)
		{
			//Thread.sleep(3000);
			return false;
			
		}
	}

	
	@DataProvider(name="LoginData_FromExcel")
	String [][] getData() throws IOException
	{
		String path = System.getProperty("user.dir") + "/src/test/java/com/internetbanking/testData/LoginPage_TestData.xlsx";

		
		int rownum = XLUtils.getRowCount(path, "Sheet2");
		//System.out.println(rownum);
		int colcount = XLUtils.getCellCount(path,"Sheet2",1);
		//System.out.println(colcount);
		
		String logindata[][] = new String[rownum][colcount];
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet2", i, j);
				//System.out.println(logindata[i-1][j]);
			}
			//System.out.println();
		}
		
		return logindata;
	}
}
