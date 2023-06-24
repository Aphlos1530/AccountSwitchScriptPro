package asc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class config6 {

    private class myProp {

        private String filePath = "src/data/config.ini";

        myProp(){

        }

        public String getProperty(String key) throws IOException {
            Properties properties = new Properties();
            FileInputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
            inputStream.close();
            return properties.getProperty(key);
        }

        public void setProperty(String key, String value) throws IOException {
            Properties properties = new Properties();
            properties.setProperty(key, value);
            FileOutputStream outputStream = new FileOutputStream(filePath);
            properties.store(outputStream, "Update value of " + key);
            outputStream.close();
        }

    }

    public config6(){}

    public String get(String key) {
        try {
            myProp myProp = new myProp();
            String value = myProp.getProperty(key);
            return value == null ? "" : value;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void set(String key, String value) {
        try {
            myProp myProp = new myProp();
            myProp.setProperty(key, value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
