package com.testscripts;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
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

	{
		logger = LogManager.getLogger(CreateAccount.class);
	}

	@Test(dataProvider = "userTestdata")
	public void createAccount(String testid, String description, String fname, String lname, String email,
			String password, String Confirmpassword) throws InterruptedException {

		// Create test for reports
		test = extent.createTest(testid + "  " + description);

		HomePage hp = new HomePage(driver);
		hp.clikCreateAccount();

		RegistrationPage rp = new RegistrationPage(driver);
		rp.newUserRegistration(fname, lname, email, password, Confirmpassword);

		Assert.assertEquals(driver.getTitle(), "My Account");
	}

	@DataProvider(name = "userTestdata")
	public static Object[][] userTestdata() throws IOException {
		ExcelUtilities.getExcel(AppObjectRespo.testDataFile);
		ExcelUtilities.getSheet(0);
		return ExcelUtilities.getValuesFromExcel();
	}
}
