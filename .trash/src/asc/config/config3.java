package asc;

import java.io.*;
import java.util.Properties;

public class config3 {


    static String filePath = "src/data/config.ini";

    static InputStream input = null;

    static OutputStream output = null;

    static Properties prop = new Properties();


    public static String get(String key) {

        // 开启流
        openStream("in");

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
        openStream("out");

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

    // 开启流
    private static void openStream(String io) {
        try {
            if (io.equals("in")) input = new FileInputStream(filePath);
            if (io.equals("out")) output = new FileOutputStream(filePath);
            //System.out.println("input="+input);
            //System.out.println("output="+output);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // 关闭流
    private static void closeStream() {
        if (input != null) {
            try {
                //System.out.println("exist-in");
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (output != null) {
            try {
                //System.out.println("exist-out");
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
