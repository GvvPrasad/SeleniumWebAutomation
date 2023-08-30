package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.Status;
import com.base.Base;

public class ExcelUtilities extends Base {

	static int i;
	static int j;

	public static void getExcel(String fileLocation) throws IOException {
		try {
			workFile = new FileInputStream(fileLocation);
			excelFile = new XSSFWorkbook(workFile);
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	public static void getSheet(int sheetno) {
		try {
			excelSheet = excelFile.getSheetAt(sheetno);
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	public static int getRowCount() {
		totalNoOfRows = excelSheet.getLastRowNum();
		return totalNoOfRows;
	}

	public static int getColumnCount() {
		totalNoOfColumns = excelSheet.getRow(0).getLastCellNum();
		return totalNoOfColumns;
	}

	public static String[][] getValuesFromExcel() throws IOException {
		String[][] excelData = new String[getRowCount()][getColumnCount()];
		for (i = 0; i < totalNoOfRows; i++) {
			for (j = 0; j < totalNoOfColumns; j++) {
				DataFormatter df = new DataFormatter();
				excelData[i][j] = df.formatCellValue(excelSheet.getRow(i+1).getCell(j));
			}
		}
		return excelData;
	}

}
