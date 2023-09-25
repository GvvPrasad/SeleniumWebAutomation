package com.objectrespo;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AppObjectRespo{
	
	//Project
	public static String projectPath = System.getProperty("user.dir");
	public static String timestamp = new SimpleDateFormat("dd_MM_yyyy HH:mm").format(Calendar.getInstance().getTime()).replaceAll(":", "_");
	public static WebDriver driver;
	public static Logger logger;
	public static ChromeOptions co = new ChromeOptions();
	public static EdgeOptions eo = new EdgeOptions();
	public static FirefoxOptions fo = new FirefoxOptions();
	public static SafariOptions so = new SafariOptions();
	
	//Application
	public static String propertiesFile = projectPath + "\\src\\main\\resources\\App.properties";
	public static String appUrl;
	public static String baseUrl;
	
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
