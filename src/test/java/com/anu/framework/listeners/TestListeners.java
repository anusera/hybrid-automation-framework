package com.anu.framework.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.anu.framework.base.BaseTest;
import com.anu.framework.utilities.ScreenshotUtility;

public class TestListeners implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result) {

	    try {

	        BaseTest baseTest =
	                (BaseTest) result.getInstance();

	        ScreenshotUtility.captureScreenshot(
	                baseTest.getDriver(),
	                result.getName());

	        System.out.println(
	                "Screenshot captured");

	    } catch (Exception e) {

	        e.printStackTrace();
	    }
	}
}
