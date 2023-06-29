package utils;

import java.util.HashMap;
import java.util.Map;

public class defSet {


    public static final String language = "English";  //语言

    public static final String gameBarType = "up";  //导航条位置

    public static final String showGameBar = "true";  //显示导航条

    public static final String tabStyle = "thick";  //制表符样式

    public static final String eMode = "0";  //游戏模式

    public static final String sMode = "1";  //启动模式


    public static final Map<String, String> setMap = new HashMap<>();

    static {

        setMap.put("language", language);

        setMap.put("gameBarType", gameBarType);

        setMap.put("showGameBar", showGameBar);

        setMap.put("tabStyle", tabStyle);

        setMap.put("eMode", eMode);

        setMap.put("sMode", sMode);

    }


    public static String get(String key) {
        String value = setMap.get(key);
        if (value == null) return "";
        return value;
    }


}
