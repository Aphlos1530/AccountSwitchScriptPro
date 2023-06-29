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
public class readInMap2 {

    private static final String langPath = swhPath("revolve/lang");

    public static final Map<String, Map<String, String>> LANG_MAP = new LinkedHashMap<>();

    private static final String[] LANGUAGES = {"English", "Chinese", "Japanese", "Korean", "Russian"};

    static {
        try {
            for (String language : LANGUAGES) {
                Map<String, String> languageMap = new LinkedHashMap<>();
                read(langPath + language + "Menu.txt", languageMap, 1);
                read(langPath + language + "Sent.txt", languageMap, 1);
                read(langPath + language + "Test.txt", languageMap, 2);
                LANG_MAP.put(language, languageMap);
            }
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
                if (!line.equals("") && !line.startsWith("//")) {
                    if (type == 1) sht(line, map);
                    if (type == 2) key = lon(line, key, map);
                }
                line = reader.readLine();
            }
            reader.close();
        }
    }

    /**
     * 等于模式 / 冒号模式
     */
    private static void sht(String line, Map<String, String> map) {
        String[] parts = line.split("[=:]", 2);
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
        line = line.trim().replace("\\t", "\t").replace("\\n", "\n");
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
            arr[i] = arr[i].replaceAll("[{}\\[\\]()]", "");
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

