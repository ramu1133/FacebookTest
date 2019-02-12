package com.fb.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() throws IOException
	{
		File f = new File("E:\\Automation\\practice\\FBTesting\\src\\main\\java\\com\\fb\\config\\config.properties");
		FileInputStream fis = new FileInputStream(f);
		prop = new Properties();
		prop.load(fis);
		
	}
	
	public void initialization()
	{
		String appUrl = prop.getProperty("url");
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\practice\\FBTesting\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Automation\\practice\\FBTesting\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get(appUrl);
	}

}
