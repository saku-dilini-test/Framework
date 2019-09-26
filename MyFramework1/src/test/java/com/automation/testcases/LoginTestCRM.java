package com.automation.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;


import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;


// This is the login page test case

public class LoginTestCRM extends BaseClass {
	
	
	@Test(priority=1)
	public String FBLoginPageTitleTest() {
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		return loginPage.ValidateFBLoginPageTitle();
	}
	
	@Test(priority=2)
	public void FBLoginPageLogoTest() {
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.ValidateFBLoginPageLogo();
	}

	@Test(priority=3)
	public void LoginApp() throws InterruptedException {
		
		logger=report.createTest("Login to CRM");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.ValidateLoginToFB(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));
		
		logger.pass("Login success"); 
		
		
		
		
	}
	
}
