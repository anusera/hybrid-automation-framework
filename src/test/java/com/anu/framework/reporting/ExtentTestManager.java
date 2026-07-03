package com.anu.framework.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
	public static void setExtentTest(ExtentTest extentTest) {
		test.set(extentTest);
	}
	
	public static ExtentTest getExtentTest(){
		return test.get();
		}
	
	public static void unload() {
		test.remove();
	}


}
