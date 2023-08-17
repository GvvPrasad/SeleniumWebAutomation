package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class RegistrationPage extends Base{
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "firstname")
	WebElement firstName;
	
	@FindBy(id = "lastname")
	WebElement lastName;
	
	@FindBy(id = "email_address")
	WebElement email;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "password-confirmation")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button")
	WebElement submitbutton;


	public void newUserRegistration(String firstname, String lastname, String useremail, String userpassword, String confirmpassword) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		email.sendKeys(useremail);
		password.sendKeys(userpassword);
		confirmPassword.sendKeys(confirmpassword);
		//submitbutton.click();
	}

}

