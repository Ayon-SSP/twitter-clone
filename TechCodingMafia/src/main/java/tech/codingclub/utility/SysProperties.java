package tech.codingclub.utility;

import java.io.IOException;
import java.util.Properties;

public class SysProperties {
    private static Properties prop = null;

    private SysProperties(){
    }

    public static Properties getInstance(){
        if(prop==null){
            // Singleton
            ClassLoader loader = SysProperties.class.getClassLoader();
            if(loader == null)
                loader = ClassLoader.getSystemClassLoader();

            String propFile = "application.properties";
            java.net.URL url= loader.getResource(propFile);
            prop = new Properties();

            try {
                prop.load(url.openStream());
            }catch (IOException ex){
            }
        }
        return prop;
    }

    public static String getPropertyValue(String key){
        return SysProperties.getInstance().getProperty(key);
    }

    public static void main(String[] args){

        System.out.println(getPropertyValue("DB_PASSWORD"));
    }
}