package com.anu.framework.constants;

import java.io.File;

public class Constants {

	public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "main" + File.separator + "resources" + File.separator + "config.properties";

	public static final String TESTDATA_FILE_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator + "testdata" + File.separator + "TestData.xlsx";
}
