package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

public WebDriver driver;
public ExcelDataProvider excel;	
public ConfigDataProvider config;	
public ExtentReports report;
public ExtentTest logger;

	@BeforeSuite
	public void setUpSuit() {
		
	Reporter.log("Setting up reports and Test is getting ready ",true);
	
	excel=new ExcelDataProvider();
	config =new ConfigDataProvider();
	
	ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
	report=new ExtentReports();
	report.attachReporter(extent);
	
	Reporter.log("Setting done- reports and Test can be started",true);

	}
	
	@BeforeClass
	public void setup() {
		
		Reporter.log("Trying to start Browser and Getting applicaton ready ",true);
		
		driver = BrowserFactory.StartApplication(driver, config.getBrowser(),config.getStagingURL());
		
		Reporter.log("Browser and Application is up and running ",true);
		
	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		//BrowserFactory.quitbrowser(driver);
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException {
		
		Reporter.log("Test is about to end ",true);
		
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshots(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshots(driver)).build());
		}
		
		report.flush();
		
		Reporter.log("Test completed >>> Reports generated ",true);
	}
}
