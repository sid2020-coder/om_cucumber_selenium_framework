package utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;
    //private constructor
    private ConfigLoader() throws IOException {
        properties = PropertyUtils.propertiesLoader("src/test/resources/config/config.properties");
    }

    public static ConfigLoader getInstance() throws IOException {
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String url = properties.getProperty("baseUrl");
        if(url!=null) return url;
        else throw new RuntimeException();
    }

}
