package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static utils.meko.swhPath;

/**
 * 自定义语言类
 */
public class readInMap {

    public static final Map<String, String> NO_TO_EN_MAP = new LinkedHashMap<>();

    public static final Map<String, String> NO_TO_CH_MAP = new LinkedHashMap<>();

    public static final Map<String, String> NO_TO_JP_MAP = new LinkedHashMap<>();

    public static final Map<String, String> NO_TO_KO_MAP = new LinkedHashMap<>();

    public static final Map<String, String> NO_TO_RU_MAP = new LinkedHashMap<>();

    public static final Map<String, String> TEST_MAP = new HashMap<>();

    private static final String langPath = swhPath("data/revolve/lang");

    static {
        try {
            read(langPath + "/EnglishMenu.txt", NO_TO_EN_MAP, 1);
            read(langPath + "/ChineseMenu.txt", NO_TO_CH_MAP, 1);
            read(langPath + "/JapaneseMenu.txt", NO_TO_JP_MAP, 1);
            read(langPath + "/KoreanMenu.txt", NO_TO_KO_MAP, 1);
            read(langPath + "/RussianMenu.txt", NO_TO_RU_MAP, 1);

            read(langPath + "/EnglishSent.txt", NO_TO_EN_MAP, 1);
            read(langPath + "/ChineseSent.txt", NO_TO_CH_MAP, 1);
            read(langPath + "/JapaneseSent.txt", NO_TO_JP_MAP, 1);
            read(langPath + "/KoreanSent.txt", NO_TO_KO_MAP, 1);
            read(langPath + "/RussianSent.txt", NO_TO_RU_MAP, 1);

            read("src/revolve/lang/TestText.txt", TEST_MAP, 2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读入 Map 中
     */
    private static void read(String filePath, Map<String, String> map, Integer type) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            String key = null;
            while (line != null) {
                if (line.equals("") || line.startsWith("//")) {
                    line = reader.readLine();
                    continue;
                }
                if (type == 1) sht(line, map);
                if (type == 2) key = lon(line, key, map);
                line = reader.readLine();
            }
            reader.close();
        }
    }

    /**
     * 等于模式 / 冒号模式
     */
    private static void sht(String line, Map<String, String> map) {
        String[] parts = line.split("=", 2);
        if (parts.length != 2) parts = line.split(":", 2);
        if (parts.length == 2) {
            trimSpace(parts);
            removeBrace(parts);
            map.put(parts[0], parts[1]);
        }
    }

    /**
     * 间行模式
     */
    private static String lon(String line, String key, Map<String, String> map) {
        line = line.trim();
        line = line.replace("\\t", "\t");
        if (key != null) {
            map.put(key, line);
            key = null;
        } else {
            key = line;
        }
        return key;
    }

    /**
     * 去除两边的大括号（如果有的话）
     */
    private static void removeBrace(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replace("{", "").replace("}", "");
        }
    }

    /**
     * 去除两边的空格（如果有的话）
     */
    private static void trimSpace(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
        }
    }

}

