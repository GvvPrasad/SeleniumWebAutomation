package com.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base;

public class WaitUtilities extends Base{
	
	//implicitly Wait
	public static void implicitlyWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	//Explicit wait
	public static WebElement explicitWaits(int seconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		WebElement newelement = wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
		return newelement;
	}
	
	//Fluent Wait
	public static WebElement fluentWait(int totalseconds, int pollingseconds, WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) 
				.withTimeout(Duration.ofSeconds(totalseconds))
				.pollingEvery(Duration.ofSeconds(pollingseconds))
				.ignoring(NoSuchElementException.class);
		WebElement newelement = wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
		return newelement;
	}
}
