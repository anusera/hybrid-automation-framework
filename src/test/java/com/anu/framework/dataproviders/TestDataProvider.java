package com.anu.framework.dataproviders;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
		return new Object[][] {
			{"standard_user", "secret_sauce"},
			{"visual_user", "secret_sauce"},
			{"problem_user", "secret_sauce"},
		};

}
}
