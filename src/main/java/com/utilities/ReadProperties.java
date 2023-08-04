package com.utilies;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.base.Base;
import com.objectRespo.AppObjectRespo;

public class ReadProperties extends Base{
	
	public void readProperties() throws IOException {
		
		FileReader reader=new FileReader(AppObjectRespo.propertiesFile);
        Properties props=new Properties();
        props.load(reader);
        
        AppObjectRespo.appUrl = props.getProperty("URL");
	}
}
