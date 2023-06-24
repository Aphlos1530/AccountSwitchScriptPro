package utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 自定义输出类
 */
public class echo implements imeko {


    private static final Map<String, String> revoMap = new LinkedHashMap<>();

    private static Map<String, String> map = new LinkedHashMap<>();

    private static String language;


    static {
        revoMap();
        refreshLanguage();
    }

    /**
     * 编码转译
     */
    public static void co(Integer code) {
        String key = String.valueOf(code);
        String text = map.get(key);
        if (text == null) text = "";
        print(text);
    }

    /**
     * 文本直译
     */
    public static void co(String text) {
        if (!language.equals("English")) {
            text = getDirectly(text);
        }
        print(text);
    }

    /**
     * 打印输出
     */
    private static void print(String text) {
        text = text.trim();
        if (text.endsWith(":")||text.endsWith("...")) {
            System.out.print(text + " ");
        } else {
            System.out.println(text);
        }
    }

    /**
     * 翻译模式1——快速对照（用于句子）
     */
    private static String getDirectly(String text) {
        String key = getCode(text);
        if (key.equals("00000")) return text;
        String slat = map.get(key);
        if (slat == null || slat.equals("")) return text;
        return slat;
    }

    /**
     * 翻译模式2——整体替换（用于单词）
     */
    private static String textReplace(String str) {
        // 这里用到的 Map 是单词互译的 Map ！
        for (String key : map.keySet()) {
            str = str.replaceAll(key, map.get(key));
        }
        return str;
    }

    /**
     * 刷新语言（用于设置语言后）
     */
    public static void refreshLanguage() {
        language = readVar.co("language");
        if (language.equals("")) {
            language = "English";
        }
        setMap();
    }

    /**
     * 获取键值对照表
     */
    private static void setMap() {
        switch (language) {
            case "English"  -> map = readInMap.NO_TO_EN_MAP;
            case "Chinese"  -> map = readInMap.NO_TO_CH_MAP;
            case "Japanese" -> map = readInMap.NO_TO_JP_MAP;
            case "Korean"   -> map = readInMap.NO_TO_KO_MAP;
            case "Russian"  -> map = readInMap.NO_TO_RU_MAP;
        }
    }

    /**
     * 反转英文代码映射表
     */
    private static void revoMap() {
        Map<String, String> codeMap = readInMap.NO_TO_EN_MAP;
        for (String key : codeMap.keySet()) {
            revoMap.put(codeMap.get(key), key);
        }
    }

    /**
     * 获取英文文本对应的代码
     */
    private static String getCode(String text) {
        String code = revoMap.get(text.trim());
        return code == null ? "00000" : code;
    }

}
