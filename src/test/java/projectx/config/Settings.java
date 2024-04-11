/**
 * @author Rasika Ranawaka
 * @filename Settings
 * @date 11/04/2024
 */
package projectx.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Settings {

    private static final Logger logger = LogManager.getLogger(Settings.class);

    private final Properties configProp = new Properties();

    private Settings() {
        String propertiesFile = "application.properties";
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(propertiesFile);
        try {
            logger.info("Reading application properties from application.properties file");
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class LazyHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static Settings getInstance() {
        return LazyHolder.INSTANCE;
    }


    public   <T> T getProperty(String key, Class<T> clazz) {
        T t;
        String value = this.configProp.getProperty(key);
        if (clazz.isAssignableFrom(String.class)) {
            t = (T) value;
        } else if (clazz.isAssignableFrom(Integer.class)) {
            t = (T) Integer.valueOf(value);
        } else if (clazz.isAssignableFrom(Boolean.class)) {
            t = (T) Boolean.valueOf(value);
        } else if (clazz.isAssignableFrom(Double.class)) {
            t = (T) Double.valueOf(value);
        } else if (clazz.isAssignableFrom(Long.class)) {
            t = (T) Long.valueOf(value);
        } else {
            throw new IllegalArgumentException("Bad type.");
        }
        logger.info(String.format("Reading property %s as %s from application properties", key, t.toString()));
        return t;
    }

}
