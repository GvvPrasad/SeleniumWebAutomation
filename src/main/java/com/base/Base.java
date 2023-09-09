package com.base;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.objectrespo.AppObjectRespo;
import com.utilities.BrowserUtilities;
import com.utilities.ReadProperties;
import com.utilities.ReportGeneration;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.listener.TestNgListener.class)
public class Base extends AppObjectRespo {

	@Parameters("browser")
	@BeforeSuite
	public static void browerSetUp(String browser) throws IOException {

		// Read properties file
		ReadProperties rp = new ReadProperties();
		rp.readProperties();

		// Generate reports
		ReportGeneration.reportGeneration();

		// Select browser
		if (browser.equalsIgnoreCase("chrome")) {
			co.setAcceptInsecureCerts(true);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);
		} 
		else if (browser.equalsIgnoreCase("edge")) {
			eo.setAcceptInsecureCerts(true);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(eo);
		} 
		else if (browser.equalsIgnoreCase("firefox")) {
			fo.setAcceptInsecureCerts(true);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(fo);
		} 
		else if (browser.equalsIgnoreCase("safari")) {
			so.setAcceptInsecureCerts(true);
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver(so);
		} 
		else {
			System.out.println("Not a valid browser");
			test.log(Status.FAIL, browser + " is not a valid browser");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(AppObjectRespo.appUrl);

	}

	@AfterSuite
	public static void tearDown() throws InterruptedException {
		driver.close();
		driver.quit();
		extent.flush();
	}

	@AfterMethod
	public static void addToReports(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName().toString() + " FAILED  ", ExtentColor.RED));
			String screenshotPath = BrowserUtilities.screenShot(result.getName().toString());
			test.addScreenCaptureFromPath(screenshotPath);
		}
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName().toString() + " SKIPPED ", ExtentColor.ORANGE));
		}
	}
}
