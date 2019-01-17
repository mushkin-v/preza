package utils;

import java.io.FileInputStream;
import java.io.IOException;

public class Properties {

    public Object readProperties(String name,String propertyPass)//"src/resources/config.Properties"
    {

        final String dir = System.getProperty("user.dir");
        FileInputStream fis;
        java.util.Properties property = new java.util.Properties();
        try {
            fis = new FileInputStream(dir+propertyPass);
            property.load(fis);
            return property.getProperty(name);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return  null;
    }
}
