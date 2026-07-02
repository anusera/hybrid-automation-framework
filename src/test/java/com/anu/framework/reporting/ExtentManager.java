package com.anu.framework.reporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	public static ExtentReports getExtentReports() {
		if(extent == null) {
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Reports/ExtentReport.html");
			sparkReporter.config().setReportName("Automation Test Execution Report"); //This is the title displayed inside the report.
			sparkReporter.config().setDocumentTitle("Automation Framework Report"); // This is the browser tab title
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Tester", "Anu");
			extent.setSystemInfo("Browser", "Chrome");
			extent.setSystemInfo("Environment", "QA");
		}
		
		
		
		return extent;
	}
	
}
