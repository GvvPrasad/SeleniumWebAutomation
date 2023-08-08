package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.base.Base;

public class ExcelUtilities extends Base {

	static int i;
	static int j;

	public static void getExcel(String fileLocation) throws IOException {
		workFile = new FileInputStream(fileLocation);
		excelFile = new XSSFWorkbook(workFile);
	}

	public static void getSheet(int sheetno) {
		excelSheet = excelFile.getSheetAt(sheetno);
	}

	public static int getRowCount() {
		totalNoOfRows = excelSheet.getLastRowNum() + 1;
		return totalNoOfRows;
	}

	public static int getColumnCount() {
		totalNoOfColumns = excelSheet.getRow(0).getLastCellNum();
		return totalNoOfColumns;
	}

	public static String[][] getValuesFromExcel() throws IOException {
		String[][] excelData = new String[totalNoOfRows][totalNoOfColumns];
		for (i = 1; i < totalNoOfRows; i++) {
			row = excelSheet.getRow(i);
			for (j = 0; j < totalNoOfColumns; j++) {
				cell = row.getCell(j);
				excelData[i - 1][j] = cell.toString();
				System.out.println(excelData);
			}

		}
		workFile.close();
		excelFile.close();
		return excelData;
	}

}
