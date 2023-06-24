package asc;

import java.io.*;
import java.util.Properties;

// perfect
public class config4 {


    static String filePath = "src/data/config.ini";

    static Properties prop = new Properties();

    // 说明：（针对同一文件的）输入输出流不能同时开启，否则会导致文件内容丢失！

    public static String get(String key) {

        // 开启流
        InputStream input = (InputStream) openStream(1);

        // 从输入流中读取属性列表
        try {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 获取属性值
        String value = prop.getProperty(key);

        // 关闭流
        closeStream(input);

        // 返回属性值
        return value == null ? "" : value;

    }

    public static void set(String key, String value) {

        // 开启流
        OutputStream output = (OutputStream) openStream(2);

        // 设置属性值
        prop.setProperty(key, value);

        // 将属性列表输出到输出流
        try {
            prop.store(output,  "Update value of " + key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 关闭流
        closeStream(output);

    }

    private static Closeable openStream(Integer io) {
        try {
            if (io==1) return new FileInputStream(filePath);
            if (io==2) return new FileOutputStream(filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static void closeStream(Closeable Stream) {
        if (Stream != null) {
            try {
                Stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
