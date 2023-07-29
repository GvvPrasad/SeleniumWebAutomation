package com.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.base.Base;
import com.objectrespo.ObjectRespo;

public class ReadProperties extends Base{
	
	public void readProperties() throws IOException {
		
		FileReader reader=new FileReader(ObjectRespo.propertiesFile);
        Properties props=new Properties();
        props.load(reader);
        
        ObjectRespo.appUrl = props.getProperty("URL");
	}
}
