package asc;

import java.io.*;
import java.util.Properties;

public class config {


    static String filePath = "src/data/config.ini";

    static InputStream input = null;

    static OutputStream output = null;

    static Properties prop = new Properties();

    static {

        openStream();

    }


    public static String get(String key) {

        // 开启流
        openStream();

        // 从输入流中读取属性列表
        try {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 获取属性值
        String value = prop.getProperty(key);

        // 关闭流
        closeStream();

        // 返回属性值
        return value == null ? "" : value;

    }

    public static void set(String key, String value) {

        // 开启流
        openStream();

        // 设置属性值
        prop.setProperty(key, value);

        // 将属性列表输出到输出流
        try {
            prop.store(output, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 关闭流
        closeStream();

    }

    // 手动开启流
    public static void openStream() {
        //if (input != null && output != null) return;
        try {
            if (input == null) input = new FileInputStream(filePath);
            if (output == null) output = new FileOutputStream(filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // 手动关闭流
    public static void closeStream() {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (output != null) {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
