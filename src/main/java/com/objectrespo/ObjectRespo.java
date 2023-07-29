package com.objectrespo;

import org.openqa.selenium.WebDriver;

public class ObjectRespo{

	public static String projectPath = System.getProperty("user.dir");
	public static String propertiesFile = projectPath + "\\src\\main\\resources\\App.properties";
	
	public static WebDriver driver;
	
	public static String appUrl;
}
