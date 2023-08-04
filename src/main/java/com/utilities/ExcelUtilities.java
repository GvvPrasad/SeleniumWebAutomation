package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.base.Base;

public class ExcelUtilities extends Base {

	public static void getExcel(String fileLocation) throws IOException {
		FileInputStream workFile = new FileInputStream(fileLocation);
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

	public static void getValuesFromExcel() {
		for (int i = 0; i < excelSheet.getLastRowNum() + 1; i++) {
			Row row = excelSheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.print(row.getCell(j).getStringCellValue());
			}
			System.out.println();
		}
	}

}
