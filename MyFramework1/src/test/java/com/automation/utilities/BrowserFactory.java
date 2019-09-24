package com.automation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	// Browsers details
	
	static WebDriver driver;
	public static WebDriver StartApplication(WebDriver driver,String browsername, String url) {
		
		if(browsername.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","/Users/sakunthaladilini/Desktop/GeckoDriver/chromedriver");
			driver=new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void quitbrowser(WebDriver driver) {
		
		driver.quit();
		
	}


}
