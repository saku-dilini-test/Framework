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
	
	@FindBy(xpath="//*[@id=\"email\"]") WebElement email;
	
	@FindBy(xpath="//*[@id=\"pass\"]") WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginbutton\"]") WebElement loginbutton;
	
	@FindBy(xpath="//*[@id=\"blueBarDOMInspector\"]/div/div/div/div[1]/h1/a/i") WebElement Logo;
	
	
	public String ValidateFBLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean ValidateFBLoginPageLogo() {
		
		return Logo.isDisplayed();
	}
	
	public void ValidateLoginToFB(String email1, String password1) throws InterruptedException {
		
		//Fill login page text boxes and click login
		Thread.sleep(2000);
		email.sendKeys(email1);
		password.sendKeys(password1);
		loginbutton.click();
	}
	
	
	
}



