package utils;

import utils.mekos.*;

import java.util.Map;

/**
 * 统一工具方法调用类
 */
public class meko {

    public static String swhPath(String path) {
        return filePath.getTruePath(path);
    }

    // IO

    public static void echo(Integer code) {
        echo.co(code);
    }

    public static void echo(String text) {
        echo.co(text);
    }

    public static void cls() {
        clear.co();
    }

    // Var

    public static String readVar(String key) {
        return variable.read(key);
    }

    public static void writeVar(String key, String value) {
        variable.write(key, value);
    }

    public static String readSet(String key) {
        return setting.read(key);
    }

    public static void writeSet(String key, String value) {
        setting.write(key, value);
    }

    // IO

    public static void waitInput() {
        waitInput.co();
    }

    public static void waitInput(String str) {
        waitInput.co(str);
    }

    public static void waitInput(Integer code) {
        waitInput.co(code);
    }

    public static String getInput() {
        return getInput.co();
    }

    public static String getInput(String text) {
        return getInput.co(text);
    }

    // Path

    public static String destPath(String path) {
        return mekoPath.destPath(path);
    }

    public static String destFile(String path) {
        return mekoPath.destFile(path);
    }

    public static Map<String, String> getLangMap() {
        return langMap.get();
    }

    public static Map<String, String> getLangMap(String language) {
        return langMap.get(language);
    }

}
