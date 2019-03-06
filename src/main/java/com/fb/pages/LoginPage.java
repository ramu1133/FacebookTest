package com.fb.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='pass']")
	WebElement password;
	
	@FindBy(xpath = "//input[@type ='submit']")
	WebElement loginbutton;
	

	public LoginPage() throws IOException
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String un , String pass)
	{
		username.sendKeys(un);
		password.sendKeys(pass);
		loginbutton.click();
		
		return new HomePage();
	}

}
