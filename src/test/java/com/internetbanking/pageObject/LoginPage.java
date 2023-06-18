package com.internetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver = null;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUserName;
	
	
	@FindBy(name= "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name= "btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath = "//a[normalize-space()='Log out']")
	@CacheLookup
	WebElement logout;
	
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPasword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickButton()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		logout.click();
	}
	

}
