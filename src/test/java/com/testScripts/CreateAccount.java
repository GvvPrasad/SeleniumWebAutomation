package com.testScripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.Base;
import com.pageObjects.HomePage;
import com.pageObjects.RegistrationPage;

public class CreateAccount extends Base {

	@Test
	public void createAccount() throws InterruptedException {
		
		// Create test for reports
		test = extent.createTest("Registration of new user");
		
		HomePage hp = new HomePage(driver);
		hp.clikCreateAccount();

		if (driver.getTitle().equalsIgnoreCase("create new Customer account")) {
			test.log(Status.PASS, "Registration page opened");
		}
		
		RegistrationPage rp = new RegistrationPage(driver);
		rp.newUserRegistration("usha", "fairy", "usha@yopmail.com", "Prasu$1819", "Prasu$1819");
		
		if (driver.getTitle().equalsIgnoreCase("My Account")) {
			test.log(Status.PASS, "Registered successfully");
		}else {
			test.log(Status.FAIL, "Registration Fail");
		}
		
		
	}
}
