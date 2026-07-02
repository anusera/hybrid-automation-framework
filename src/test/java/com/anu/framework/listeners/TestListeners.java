package com.anu.framework.listeners;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.anu.framework.base.BaseTest;
import com.anu.framework.reporting.ExtentManager;
import com.anu.framework.reporting.ExtentTestManager;
import com.anu.framework.utilities.ScreenshotUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListeners implements ITestListener {
	
	private static final Logger logger =
	        LogManager.getLogger(TestListeners.class);
	
	private static final ExtentReports extent = ExtentManager.getExtentReports();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		// Create an ExtentTest entry for the current test method
	    ExtentTest extentTest = extent.createTest(result.getName());
	    ExtentTestManager.setExtentTest(extentTest);
	    logger.info("Test Started : {}", result.getName());
		
	}
		
	@Override
	public void onTestFailure(ITestResult result) {

	    try {

	        BaseTest baseTest =
	                (BaseTest) result.getInstance();

	       String screenshotPath =  ScreenshotUtility.captureScreenshot(
	                baseTest.getDriver(),
	                result.getName());
	       
	       ExtentTestManager.getExtentTest().fail(result.getThrowable());
	       ExtentTestManager.getExtentTest().fail("Test Failed : " + result.getName());
		    ExtentTestManager.getExtentTest().addScreenCaptureFromPath(screenshotPath);

	       // System.out.println("Screenshot captured");

	    } catch (Exception e) {

	        e.printStackTrace();
	    }
	    logger.error("Test Failed : {}", result.getName());
	    
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getExtentTest().pass("Test Passed");
		logger.info("Test Passed : {}", result.getName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		logger.info("Extent report generated.");
	}
	
	}
	