package asc;

import java.io.*;
import java.util.Properties;

public class config2 {


    static String filePath = "src/data/config.ini";

    static InputStream input = null;

    static OutputStream output = null;

    static Properties prop = new Properties();

    static {
        try {
            input = new FileInputStream(filePath);
            output = new FileOutputStream(filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static String get(String key) {

        // 从输入流中读取属性列表
        try {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 获取属性值
        String value = prop.getProperty(key);

        // 返回属性值
        return value == null ? "" : value;

    }

    public static void set(String key, String value) {

        // 设置属性值
        prop.setProperty(key, value);

        // 将属性列表输出到输出流
        try {
            prop.store(output, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
