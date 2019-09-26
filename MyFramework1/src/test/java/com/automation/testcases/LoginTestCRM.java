package com.automation.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;


import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;


// This is the login page test case

public class LoginTestCRM extends BaseClass {
	
	
	@Test(priority=1)
	public void FBLoginPageTitleTest() {
		
		logger=report.createTest("FB Page Title ");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.ValidateFBLoginPageTitle();
		
		logger.pass("FB title is correct"); 
	}
	
	@Test(priority=2)
	public void FBLoginPageLogoTest() {
		
		logger=report.createTest("FB page Logo ");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.ValidateFBLoginPageLogo();
		
		logger.pass("Logo is available"); 
	}

	@Test(priority=3)
	public void LoginApp() throws InterruptedException {
		
		logger=report.createTest("Login to FB");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.ValidateLoginToFB(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));
		
		logger.pass("Login success"); 
		
		
		
		
	}
	
}
