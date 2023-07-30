package com.objectRespo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AppObjectRespo{
	
	//Project
	public static String projectPath = System.getProperty("user.dir");
	public static String timestamp = new SimpleDateFormat("dd_MM_yyyy HH:mm").format(Calendar.getInstance().getTime()).replaceAll(":", "-");
	public static WebDriver driver;
	
	//Application
	public static String propertiesFile = projectPath + "\\src\\main\\resources\\App.properties";
	public static String appUrl;
	
	//Reports
	public static String htmlReportPath = projectPath + "\\reports\\htmlreport_"+timestamp+".html";
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

}
