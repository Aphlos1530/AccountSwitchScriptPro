package lang;

import java.util.HashMap;
import java.util.Map;

public class ch {

    private static final Map<String, String> EN_TO_ZH_MAP = new HashMap<>();
    static {
        EN_TO_ZH_MAP.put("!", "！");
        EN_TO_ZH_MAP.put("hello world", "你好世界");
        // 其他需要替换的字符串
    }

    public static String toCh(String str) {


        if (str.equals("You have not configured, please configure the game path: ")) return "检测到您尚未进行配置，请配置游戏路径：";
//        return "";



        if (str.equals("bilibili")) return "哔哩哔哩";


        str=str.replace("You have not configured, please configure the game path: ","检测到您尚未进行配置，请配置游戏路径：");

        str=str.replace("bilibili","哔哩哔哩");



        String zhStr = EN_TO_ZH_MAP.get(str);
        str=zhStr != null ? zhStr : str;
//        return zhStr != null ? zhStr : str;




        return str;
    }

}
