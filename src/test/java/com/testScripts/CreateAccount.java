package com.testScripts;

import org.testng.annotations.Test;

import com.base.Base;
import com.pageObjects.HomePage;

public class CreateAccount extends Base{
	
	@Test
	public void createAccount() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.clikCreateAccount();
	}
}
