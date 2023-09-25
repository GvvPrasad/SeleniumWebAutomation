package com.base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.objectrespo.AppObjectRespo;
import com.utilities.ReadProperties;
import com.utilities.ReportGeneration;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.listener.TestNgListener.class)
public class Base extends AppObjectRespo {
	
	{
		logger = LogManager.getLogger(Base.class);
	}

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
			System.out.println(browser + " is not a valid browser");
			logger.error(browser + " is not a valid browser");
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

}