package com.testScripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.Base;
import com.pageObjects.HomePage;

public class CreateAccount extends Base {

	@Test
	public void createAccount() throws InterruptedException {
		
		// Create test for reports
		test = extent.createTest("Opening of registration Page");
		
		HomePage hp = new HomePage(driver);
		hp.clikCreateAccount();

		test.log(Status.PASS, "Test passed successfully.");
		
	}
}
