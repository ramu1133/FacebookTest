package com.fb.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.base.TestBase;
import com.fb.pages.HomePage;
import com.fb.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() throws IOException 
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test
	public void loginPageTitleTest()
	{
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	
	@Test
	public void loginTest()
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
