package com.utilies;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.base.Base;
import com.objectRespo.AppObjectRespo;

public class ReportGeneration extends Base {

	@Test
	public static void reportGeneration() {
		htmlReporter = new ExtentHtmlReporter(AppObjectRespo.htmlReportPath);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

}
