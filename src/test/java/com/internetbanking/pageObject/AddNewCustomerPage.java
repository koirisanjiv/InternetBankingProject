package com.internetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	
	WebDriver ldriver = null;
	
	public AddNewCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='New Customer']")
	@CacheLookup
	WebElement addNewCustomerTab;
	
	@FindBy(name = "name")
	@CacheLookup
	WebElement customerName;
	
	@FindBy(xpath = "//tbody/tr[5]/td[2]")
	@CacheLookup
	WebElement gender;
	
	@FindBy(xpath = "//input[@id='dob']")
	@CacheLookup
	WebElement dateOfBirth;
	
	
	@FindBy(xpath = "//textarea[@name='addr']")
	@CacheLookup
	WebElement address;
	
	@FindBy(xpath = "//input[@name='city']")
	@CacheLookup
	WebElement city;
	
	
	@FindBy(xpath = "//input[@name='state']")
	@CacheLookup
	WebElement state;
	
	@FindBy(xpath = "//input[@name='pinno']")
	@CacheLookup
	WebElement pin;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	@CacheLookup
	WebElement telephone;
	
	@FindBy(xpath = "//input[@name='emailid']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath = "//input[@name='sub']")
	@CacheLookup
	WebElement submit;
	
	
	public void clickAddNewCustomer()
	{
		addNewCustomerTab.click();
	}
	
	public void customerName(String custname)
	{
		customerName.sendKeys(custname);
	}
	
	public void clickgender(String gen)
	{
		gender.click();
	}
	public void dateofbirth(String mm, String dd, String yy)
	{
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(yy);
	}
	public void address(String add)
	{
		address.sendKeys(add);
	}
	public void cityName(String cityn)
	{
		city.sendKeys(cityn);
	}
	public void stateName(String statename)
	{
		state.sendKeys(statename);
	}
	public void pinNumber(String pinnum)
	{
		pin.sendKeys(pinnum);
	}
	public void telephoneNumber(String telnumber)
	{
		telephone.sendKeys(telnumber);
	}
	public void emailAddress(String mail)
	{
		email.sendKeys(mail);
	}
	public void clickSubmit()
	{
		submit.click();
	}

}
