package com.testscripts;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.Base;
import com.objectrespo.AppObjectRespo;
import com.pageobjects.HomePage;
import com.pageobjects.RegistrationPage;
import com.utilities.ExcelUtilities;

@Listeners(com.listener.TestNgListener.class)
public class CreateAccount extends Base {

	@Test(dataProvider = "userTestdata")
	public void createAccount(String testid, String description, String fname, String lname, String email,
			String password, String Confirmpassword) throws InterruptedException {

		// Create test for reports
		test = extent.createTest(testid + "  " + description);
		Thread.sleep(5000);

		HomePage hp = new HomePage(driver);
		hp.clikCreateAccount();

		if (driver.getTitle().equalsIgnoreCase("create new Customer account")) {
			test.log(Status.PASS, "Registration page opened");
		}

		RegistrationPage rp = new RegistrationPage(driver);
		rp.newUserRegistration(fname, lname, email, password, Confirmpassword);

		if (driver.getTitle().equalsIgnoreCase("My Account")) {
			test.log(Status.PASS, "Registered successfully");
		} else {
			test.log(Status.FAIL, "Registration Fail");
		}
	}

	@DataProvider(name = "userTestdata")
	public static String[][] userTestdata() throws IOException {
		ExcelUtilities.getExcel(AppObjectRespo.testDataFile);
		ExcelUtilities.getSheet(0);
		return ExcelUtilities.getValuesFromExcel();
	}
}
