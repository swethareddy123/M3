package com.cg.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPageFactory {
	WebDriver driver;
	@FindBy(id="usrID")
	@CacheLookup
	WebElement userid;

	@FindBy(id="pwd")
	@CacheLookup
	WebElement password;

	@FindBy(id="usrname")
	@CacheLookup
	WebElement username;

	@FindBy(id="addr")
	@CacheLookup
	WebElement address;

	@FindBy(name="country")
	@CacheLookup
	WebElement country;

	@FindBy(name="zip")
	@CacheLookup
	WebElement zip;

	@FindBy(name="email")
	@CacheLookup
	WebElement email;

	@FindBy(name="sex")
	@CacheLookup
	WebElement gender1;

	@FindBy(name="sex")
	@CacheLookup
	WebElement gender2;
	
	@FindBy(name="submit")
	@CacheLookup
	WebElement submitBtn;
	
	
	public RegistrationPageFactory() {

	}
	public RegistrationPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void setUserId(String id)
	{
		userid.sendKeys(id);
	}

	public void setPassword(String pswrd)
	{
		password.sendKeys(pswrd);
	}

	public void setUserName(String name)
	{
		username.sendKeys(name);
	}

	public void setAddress(String adrs)
	{
		address.sendKeys(adrs);
	}

	public void clickLoginButton()
	{
		submitBtn.click();
	}



}
