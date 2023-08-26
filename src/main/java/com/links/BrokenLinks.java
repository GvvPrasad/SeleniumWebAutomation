package com.links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base;

@Listeners(com.listener.TestNgListener.class)
public class BrokenLinks extends Base {

	// variables
	static HttpURLConnection hul;

	@Test
	public static void brokenLinksList() throws IOException {
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// Get all the links
		for (WebElement link : links) {
			String linkText = link.getText();
			String linkUrl = link.getAttribute("href");
			
			if (linkUrl == null || linkUrl.isEmpty()) {
				System.out.println(linkText+" : "+linkUrl + " :URL is either not configured for anchor tag or it is empty");
				continue;
			}

			URL url = new URL(linkUrl);

			// Now we will be creating url connection and getting the response code
			hul = (HttpURLConnection) url.openConnection();
			hul.setConnectTimeout(5000);
			hul.connect();
			
			if(hul.getResponseCode()>=400)
            {
            	System.out.println(linkText+" : "+linkUrl+" is a broken link");
            } 
		}

	}

}
