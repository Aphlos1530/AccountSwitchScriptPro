package utils;

import java.util.HashMap;
import java.util.Map;

import static utils.meko.readVar;
import static utils.meko.writeVar;
import static utils.tabChars.setTabStyle;
import static utils.translator.*;

public class setting {

    private static final Map<String, String> settingMap = new HashMap<>();

    public static String read(String key) {
        String setting = settingMap.get(key);  //优先从 Map 中读取
        if (setting == null) {
            setting = readVar(key);  //从文件中读取
            if (setting.equals("")) {
                setting = defSet.get(key);  //读取默认值
            }
            settingMap.put(key, setting);  //存入 Map 中
        }
        return setting;
    }

    public static void write(String key, String value) {
        String current = settingMap.get(key);
        if (!value.equals(current)) {
            settingMap.put(key, value);  //存入 Map 中
            writeVar(key, value);  //写入到文件中
            if (key.equals("language")) {
                refreshLanguage();  //刷新 langMap
            }
            if (key.equals("tabStyle")) {
                setTabStyle();  //刷新制表符样式
            }
        }
    }

}
