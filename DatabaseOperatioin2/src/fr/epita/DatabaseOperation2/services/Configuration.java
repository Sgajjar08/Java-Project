/**
 * 
 */
package fr.epita.DatabaseOperation2.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import fr.epita.logger.Logger;

/**
 * @author Jaydev
 *
 */
public class Configuration {
	private static final Logger logger = new Logger(Configuration.class);
	private static Configuration instance;

	private final Properties properties;

	public static Configuration getInstance() {
		if (instance == null) {
			instance = new Configuration();
		}
		return instance;
	}

	private Configuration() {
		properties = new Properties();
		try {
			
//			String file = System.getProperty("conf");
//			
//			FileInputStream fileInputStream = new FileInputStream(file);
//			properties.load(fileInputStream);
		
			properties.load(new FileInputStream("C:\\Users\\Jaydev\\eclipse-workspace\\DatabaseOperatioin2\\src\\testConfiguration.properties"));
		} catch (final IOException e) {
			logger.error("error while loading the configuration", e);
		}
	}

	public String getProperty(String key) {
	return properties.getProperty(key);

	}

	public boolean containsProperty(String key) {
		return properties.containsKey(key);
	}

}
