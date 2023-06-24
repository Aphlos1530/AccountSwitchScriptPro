package lang;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Locale;
import java.util.ResourceBundle;


public class ch2 {
    private static Map<String, String> EN_TO_ZH_MAP = new HashMap<String, String>() {{
        put("hello", "你好");
        put("world", "世界");
        put("!", "！");
    }};

//    public static void main(String[] args) {
//        String str = "5.hello world!";
//        String newStr = replaceMultipleStrings(str, EN_TO_ZH_MAP);
//        System.out.println(newStr);
//    }

    public static String toCh2(String str) {
        StringBuilder patternString = new StringBuilder();
        Map<String, String> stringMap = EN_TO_ZH_MAP;
        for (String key : stringMap.keySet()) {
            patternString.append(String.format("|\\b%s\\b", Pattern.quote(key)));
        }
        Pattern pattern = Pattern.compile(patternString.substring(1));
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, stringMap.get(matcher.group()));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String toCh3(String str) {
        Map<String, String> stringMap = EN_TO_ZH_MAP;
        for (String key : stringMap.keySet()) {
            str=str.replaceAll(key,stringMap.get(key));
        }
        return str;
    }

    public static String toCh4(String str) {
        // 设置当前语言环境为中文
        Locale locale = new Locale("zh", "CN");
        // 加载中文资源束
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        // 获取本地化文本
//        String greeting = bundle.getString("greeting");
//        String name = bundle.getString("name");

        str = bundle.getString(str);
        // 输出本地化文本
        //System.out.println(greeting + ", " + name + "!");

        return str;
    }


    //!!!!!!!
    public static String toCh5(String str) {

        Map<String, String> map = readInMap4Pro.EN_TO_ZH_MAP;

        for (String key : map.keySet()) {
            str=str.replaceAll(key,map.get(key));
        }

        return str;

    }

    public static String toCh6(String str) {

        String zhStr = readInMap.EN_TO_ZH_MAP.get(str);

        return zhStr != null ? zhStr : str;

    }

    public static String toCh7(String str) {
        Pattern pattern = Pattern.compile("\\b(" + String.join("|", EN_TO_ZH_MAP.keySet()) + ")\\b");
        Matcher matcher = pattern.matcher(str);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, EN_TO_ZH_MAP.get(matcher.group(1)));
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    public static String toCh8(String str) {

        Map<String, String> map = new HashMap<>();

        map.putAll(readInMap.EN_TO_ZH_MAP);
        map.putAll(readInMap4Pro.EN_TO_ZH_MAP);

        for (String key : map.keySet()) {
            str = str.replaceAll(key,map.get(key));
        }

        return str;
    }

    public static String toCh9(String str) {

        Map<String, String> map = new HashMap<>();

        map.putAll(readInMap9.EN_TO_ZH_MAP_LONG);
        map.putAll(readInMap9.EN_TO_ZH_MAP_SHORT);

        for (String key : map.keySet()) {
            str = str.replaceAll(key,map.get(key));
        }

        return str;
    }

    public static String toCh10(String str) {

        Map<String, String> map = readInMap10.EN_TO_ZH_MAP;

        for (String key : map.keySet()) {
            str = str.replaceAll(key,map.get(key));
        }

        return str;
    }

    public static String toCh12(String str) {

        Map<String, String> map = readInMap10.EN_TO_ZH_MAP;

//        Map<String, String> map1 = readInMap12.EN_TO_ZH_MAP;
//
//        Map<String, String> map2 = readInMap12.VAR_MAP;
//
//
//        Map<String, String> map = new HashMap<>();
//
//        map.putAll(map1);
//
//        map.putAll(map2);


        for (String key : map.keySet()) {
            str = str.replaceAll(key,map.get(key));
        }

        return str;
    }


}

