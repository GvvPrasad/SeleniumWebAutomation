package com.objectrespo;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AppObjectRespo{
	
	//Project
	public static String projectPath = System.getProperty("user.dir");
	public static String timestamp = new SimpleDateFormat("dd_MM_yyyy HH:mm").format(Calendar.getInstance().getTime()).replaceAll(":", "_");
	public static WebDriver driver;
	
	//Application
	public static String propertiesFile = projectPath + "\\src\\main\\resources\\App.properties";
	public static String appUrl;
	
	//Reports
	public static String htmlReportPath = projectPath + "\\reports\\htmlreport_"+timestamp+".html";
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	//Excel
	public static FileInputStream workFile;
	public static XSSFWorkbook excelFile;
	public static XSSFSheet excelSheet;
	public static int totalNoOfRows;
	public static int totalNoOfColumns;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	//Test case files
	public static String testDataFile = projectPath+"\\src\\test\\resources\\TestCases.xlsx"; 
	
	//Screenshot
	public static String dest; 
}
