package com.anu.framework.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.anu.framework.constants.Constants;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;
	
	public static String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
		f = new FileInputStream(Constants.TESTDATA_FILE_PATH);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheetName);
		XSSFRow r = s.getRow(rowNum);
		XSSFCell c = r.getCell(colNum);		
		return c.getStringCellValue(); 		
	}
	
	public static Object[][] getSheetData(String sheetName) throws IOException {
		FileInputStream f = new FileInputStream(Constants.TESTDATA_FILE_PATH);
		XSSFWorkbook w = new XSSFWorkbook(f);
		XSSFSheet s = w.getSheet(sheetName);
		
		int rowCount = s.getLastRowNum(); // Get total number of rows
		int colCount = s.getRow(0).getLastCellNum(); // Get total number of columns
		
		Object[][] data = new Object[rowCount][colCount];
		
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow r = s.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell c = r.getCell(j);
				data[i-1][j] = c.getStringCellValue();
			}
		}
		
		return data;
	}
	
	public static void main(String[] args) throws IOException {
		Object[][] data = ExcelUtility.getSheetData("LoginData");
		System.out.println(Arrays.deepToString(data));

}
	}
