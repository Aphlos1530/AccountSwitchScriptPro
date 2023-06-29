package utils;

import java.util.LinkedHashMap;
import java.util.Map;

import static utils.meko.getLangMap;
import static utils.meko.readVar;

/**
 * 自定义翻译类
 */
public class translator {

    private static final Map<String, String> revoMap = new LinkedHashMap<>();

    private static Map<String, String> langMap = new LinkedHashMap<>();

    private static String language;

    static {
        getRevoMap();
        refreshLanguage();
    }

    /**
     * 对外接口
     */
    public static String co(String text) {
        if (language.equals("English")) {
            return text;
        }
        return translate(text);
    }

    /**
     * 文本翻译
     */
    private static String translate(String text) {

        String code = getTextCode(text);  //获取文本对应的代码
        if (code.equals("00000")) return text;  //对应代码不存在，返回原文

        String slat = langMap.get(code);  //获取代码对应的译文
        if (slat == null || slat.equals("")) return text;  //译文为空，返回原文

        return slat;  //转译成功，返回译文

    }

    /**
     * 获取英文文本对应的代码
     */
    private static String getTextCode(String text) {
        String code = revoMap.get(text.trim());
        return code == null ? "00000" : code;
    }

    /**
     * 反转英文代码映射表
     */
    private static void getRevoMap() {
        Map<String, String> codeMap = getLangMap("English");
        for (String key : codeMap.keySet()) {
            revoMap.put(codeMap.get(key), key);
        }
    }

    /**
     * 刷新语言键值对照表（用于设置语言后）
     */
    public static void refreshLanguage() {
        language = readVar("language");
        if (language.equals("")) {
            language = "English";
        }
        langMap = getLangMap(language);
    }

}
