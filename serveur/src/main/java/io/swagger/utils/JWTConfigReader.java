package io.swagger.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lux on 25.01.17.
 */
public class JWTConfigReader {
    public static void readProperties() throws Exception
    {
        Properties properties = new Properties();

        InputStream fileInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("JWT.properties");
        properties.load(fileInputStream);

        JWTConfig.secret = properties.getProperty("secret");

        fileInputStream.close();
    }
}
