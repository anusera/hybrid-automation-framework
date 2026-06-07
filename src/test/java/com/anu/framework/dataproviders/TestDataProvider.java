package com.anu.framework.dataproviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.anu.framework.utilities.ExcelUtility;

public class TestDataProvider {
	
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws IOException {
		/*return new Object[][] {
			{"standard_user", "secret_sauce"},
			{"visual_user", "secret_sauce"},
			{"problem_user", "secret_sauce"},
		};*/
		
		return ExcelUtility.getSheetData("LoginData");

}
}
