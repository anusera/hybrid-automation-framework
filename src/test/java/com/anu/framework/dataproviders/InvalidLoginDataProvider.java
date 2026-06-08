package com.anu.framework.dataproviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.anu.framework.utilities.JsonUtility;

public class InvalidLoginDataProvider {

	@DataProvider(name = "invalidLoginData")
	public Object[][] getInvalidLoginData() throws IOException {
		return JsonUtility.getJsonData();
}
}