package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}
	//Verifying login page elements
	
	@FindBy(name="ctl00$CPHContainer$txtUserLogin") WebElement email;
	
	@FindBy(name="ctl00$CPHContainer$txtPassword") WebElement password;
	
	@FindBy(xpath="//*[@id=\"ctl00_CPHContainer_btnLoginn\"]") WebElement loginbutton;
	
	
	public void LoginToCRM(String email1, String password1) throws InterruptedException {
		
		//Fill login page text boxes and click login
		Thread.sleep(2000);
		email.sendKeys(email1);
		password.sendKeys(password1);
		loginbutton.click();
	}
	
	
	
}



