package tech.codingclub.helix.global;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class SysProperties {
    private static final Logger logger = Logger.getLogger(SysProperties.class);
    private static Properties prop = null;

    private SysProperties() {
    }

    public static Properties getInstance() {
        if (prop == null) {

            ClassLoader loader = SysProperties.class.getClassLoader();
            if (loader == null)
                loader = ClassLoader.getSystemClassLoader();

            String propFile = "application.properties";
            java.net.URL url = loader.getResource(propFile);
            prop = new Properties();

            try {
                prop.load(url.openStream());
            } catch (IOException ex) {
                logger.error("Unable to load property file");
            }
        }

        return prop;
    }

    public static String getBaseDir() {
        return SysProperties.getInstance().getProperty("BASE_DIR");
    }

    public static String getServerDomain() {
        return SysProperties.getInstance().getProperty("SERVER_DOMAIN");
    }

}
