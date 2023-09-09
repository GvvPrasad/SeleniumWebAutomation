package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.base.Base;

@Listeners(com.listener.TestNgListener.class)
public class HomePage extends Base {

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Create an Account")
	WebElement createAccount;
	
	
	public void clikCreateAccount() {
		System.out.println("enteer method");
		createAccount.click();
		System.out.println("linked clicked");
	}
}
