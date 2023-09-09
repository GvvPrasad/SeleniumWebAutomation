package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;
import com.base.Base;

@Listeners(com.listener.TestNgListener.class)
public class ExcelUtilities extends Base {

	static int i;
	static int j;

	// Get Excel file
	public static void getExcel(String fileLocation) throws IOException {
		try {
			workFile = new FileInputStream(fileLocation);
			excelFile = new XSSFWorkbook(workFile);
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}

	// Get the sheet
	public static void getSheet(int sheetno) {
		try {
			excelSheet = excelFile.getSheetAt(sheetno);
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}

	// Get no of rows it start with 0
	public static int getRowCount() {
		totalNoOfRows = excelSheet.getLastRowNum();
		return totalNoOfRows;
	}

	// Get no of columns it start with 1
	public static int getColumnCount() {
		totalNoOfColumns = excelSheet.getRow(0).getLastCellNum();
		return totalNoOfColumns;
	}
	
	// Get all values from Excel
	public static Object[][] getValuesFromExcel() throws IOException {
		Object[][] excelData = new Object[getRowCount()][getColumnCount()];
		for (i = 1; i <= getRowCount(); i++) {
			for (j = 0; j < getColumnCount(); j++) {
				//for Empty cells
				//for date
				excelData[i-1][j] =	excelSheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return excelData;
	}

}
