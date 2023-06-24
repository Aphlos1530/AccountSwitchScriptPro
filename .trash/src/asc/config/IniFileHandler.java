package asc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class IniFileHandler {
    private Properties properties;

    String fileName;

    public IniFileHandler(String fileName){
        properties = new Properties();
        this.fileName=fileName;
    }

    public String getProperty(String key)  throws IOException {
        FileInputStream inputStream = new FileInputStream(fileName);
        properties.load(inputStream);
        inputStream.close();
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) throws IOException {
        properties.setProperty(key, value);
        FileOutputStream outputStream = new FileOutputStream(fileName);
        properties.store(outputStream, "Update value of " + key);
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {
        IniFileHandler handler = new IniFileHandler("src/data/config.ini");
        String value = handler.getProperty("key1");
        System.out.println("Value of key1: " + value);
        //handler.setProperty("key1", "new value");
        Random random = new Random();
        int randomNumber = random.nextInt();
        int randomInRange = Math.abs(randomNumber) % 100;
        handler.setProperty("key1", String.valueOf(randomInRange));
        value = handler.getProperty("key1");
        System.out.println("Value of key1 after: " + value);
    }
}