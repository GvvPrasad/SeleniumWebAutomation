package com.links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.base.Base;
import com.objectrespo.AppObjectRespo;

@Listeners(com.listener.TestNgListener.class)
public class BrokenLinks extends Base {

	// variables
	static HttpURLConnection hul;

	@Test
	public static void brokenLinksList() throws IOException {
		test = extent.createTest("Checking all broken links");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		// Get all the links
		for (WebElement link : links) {
			String linkText = link.getText();
			String linkUrl = link.getAttribute("href");
			
			//Checking if url is empty or null
			if (linkUrl == null || linkUrl.isEmpty()) {
				continue;
			}
			
			//Checking url belong to same or other applications
			if (!(linkUrl.startsWith(AppObjectRespo.baseUrl))) {
				continue;
			}

			URL url = new URL(linkUrl);

			// Now we will be creating url connection and getting the response code
			hul = (HttpURLConnection) url.openConnection();
			hul.setConnectTimeout(5000);
			hul.connect();
			
			//Displaying all the broken links
			if (hul.getResponseCode() >= 400) {
				test.log(Status.FAIL,
						MarkupHelper.createLabel(linkText + " : " + linkUrl + " :URL is not broken", ExtentColor.RED));
			}
		}

	}

}
