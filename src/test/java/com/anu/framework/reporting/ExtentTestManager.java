package com.anu.framework.reporting;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	private static ExtentTest test;
	
	public static void setExtentTest(ExtentTest extentTest) {
		test =extentTest;
	}
	
	public static ExtentTest getExtentTest(){
		return test;
		}


}
