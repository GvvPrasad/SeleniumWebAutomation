package com.utilities;

import com.base.Base;

public class BrowserUtilities extends Base {
	
	//Browser alerts
	public static String browserAlerts(String alerttype, String message) {
		
		String alerttext = null;
		
		switch (alerttype) {
		case "accept": driver.switchTo().alert().accept();
			break;
		case "dismiss": driver.switchTo().alert().dismiss();
			break;
		case "gettext": alerttext = driver.switchTo().alert().getText();
			break;
		case "sendtext": driver.switchTo().alert().sendKeys(message);
			break;
		}
		return alerttext;
	}
	
	
}
