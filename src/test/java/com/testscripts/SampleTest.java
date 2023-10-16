package com.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.Base;
import com.objectrespo.AppObjectRespo;
import com.utilities.ExcelUtilities;

public class SampleTest extends Base{
	
	@Test
	public static void checking() throws IOException {
		
		test = extent.createTest("Checking");
		
		ExcelUtilities.getExcel(AppObjectRespo.testDataFile);
		ExcelUtilities.getSheet(0);
		ExcelUtilities.getValuesFromExcel();
	}
	
}
