package com.automation.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;


import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;


// This is the login page test case

public class LoginTestCRM extends BaseClass {
	

	@Test
	public void LoginApp() throws InterruptedException {
		
		logger=report.createTest("Login to CRM");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.LoginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login success"); 
		
		
		
		
	}
	
}
