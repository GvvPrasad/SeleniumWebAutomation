package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base;
import com.objectrespo.AppObjectRespo;

import io.netty.handler.codec.http.HttpHeaders.Values;

public class BrowserUtilities extends Base {
	static WebDriverWait wait;
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	static Actions act = new Actions(driver); 

	// Browser alerts
	public static String browserAlerts(String alerttype, String message) {

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alerttext = null;

		switch (alerttype) {
		case "accept":
			driver.switchTo().alert().accept();
			break;
		case "dismiss":
			driver.switchTo().alert().dismiss();
			break;
		case "gettext":
			alerttext = driver.switchTo().alert().getText();
			break;
		case "sendtext":
			driver.switchTo().alert().sendKeys(message);
			break;
		}
		return alerttext;
	}
	
	//Iframe
	public static void switchToIframe(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	//Current window handle
	public static String currentWindow() {
		String currentWindowHandle = driver.getWindowHandle();
		return currentWindowHandle;
	}
	
	//Get all window handles
	public static Set<String> allwindows() {
		Set<String> allWindowHandles = driver.getWindowHandles();
		return allWindowHandles;
	}
	
	//Switch to specific window
	public static void desiredWindow(String[] allWindowHandles, String desiredwindow) {
		for (String eachHandle : allWindowHandles) {
			if (eachHandle.equalsIgnoreCase(desiredwindow)) {
				driver.switchTo().window(desiredwindow);
			}
		}
	}
	
	//Screenshot
	public static String screenShot(String methodName) throws IOException {
		File SrcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		AppObjectRespo.dest = projectPath + "\\screenshot\\" + methodName +"_"+ timestamp + ".png";
		File DestFile=new File(dest);
		FileUtils.copyFile(SrcFile, DestFile);
		return dest;
	}
	
	//Scroll to end of page
	public static void scrollToEnd() {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	//scroll to top of page
	public static void scrollToTop() {
		js.executeScript("window.scrollBy(0,0)");
	}
	
	//Scroll to a particular element
	public static void scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	//Refresh page
	public static void refreshPage() {
		driver.navigate().refresh();
	}
	
	//Move page backward
	public static void movePageBackward() {
		driver.navigate().back();
	}
	
	//Move page forward
	public static void movePageForward() {
		driver.navigate().forward();
	}
	
	//Move the mouse to a particular element
	public static void moveMouseToParticularElement(WebElement element) {
		act.moveToElement(element).build().perform();
	}
	
	//Drag & Drop element
	public static void dragAndDrop(WebElement source, WebElement destination) {
		act.dragAndDrop(source, destination).build().perform();
	}
	
	//web tables
	public static Object[][] webTable(WebElement tableElement) {
		Object[][] tableData = null;
		List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
		for (int i = 0; i <= rows.size(); i++) {
			List<WebElement> columns = rows.get(0).findElements(By.tagName("td"));
				for (int j = 0; j < columns.size(); j++) {
					tableData = new Object[rows.size()][columns.size()];
					tableData[i][j] = columns.get(j).getText();
				}
		}
		return tableData;
	}
	
	//dropdown
	public static void dropDown(String element, String elementvalue) {
		Select dropdown = new Select(driver.findElement(By.id(element)));
		dropdown.selectByVisibleText(elementvalue);
	}
	
}
