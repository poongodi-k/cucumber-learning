package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
	static Properties props;
	static {
		props = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(new File("src/test/resources/properties/props.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getValue(String key) {
		return props.getProperty(key);
	}

}
