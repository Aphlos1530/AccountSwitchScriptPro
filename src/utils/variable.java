package utils;

import java.io.*;
import java.util.Properties;

import static utils.meko.swhPath;

/** 自定义变量读写类 */
public class variable {

    static String filePath = swhPath("data/temp/variable.ini");

    static Properties properties = new Properties();

    /** 变量读取 */
    private static String getProperty(String key) throws IOException {
        FileInputStream inputStream = new FileInputStream(filePath);
        properties.load(inputStream);
        inputStream.close();
        return properties.getProperty(key);
    }

    /** 变量写入或修改 */
    private static void setProperty(String key, String value) throws IOException {
        properties.setProperty(key, value);
        FileOutputStream outputStream = new FileOutputStream(filePath);
        properties.store(outputStream, "Update value of " + key);
        outputStream.close();
    }

    public static String read(String key) {
        try {
            String value = getProperty(key);
            return value == null ? "" : value;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(String key, String value) {
        try {
            setProperty(key, value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
