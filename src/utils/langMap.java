package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static utils.meko.readVar;
import static utils.meko.swhPath;

/**
 * 自定义语言类
 */
public class langMap {

    private static final String langPath = swhPath("revolve/lang");

    /**
     * 获取 Map 表
     */
    public static Map<String, String> get(String language) {
        Map<String, String> languageMap = new LinkedHashMap<>();
        try {
            read(langPath + "/" + language + "Menu.txt", languageMap, 1);
            read(langPath + "/" + language + "Sent.txt", languageMap, 1);
            read(langPath + "/" + language + "Essa.txt", languageMap, 2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return languageMap;
    }

    /** 根据数字获取 */
    public static Map<String, String> get(Integer type) {
        return switch (type) {
            case 1  -> get("English");
            case 2  -> get("Chinese");
            case 3  -> get("Japanese");
            case 4  -> get("Korean");
            case 5  -> get("Russian");
            default -> get("Other");
        };
    }

    /** 自动获取（对应语言的） */
    public static Map<String, String> get() {
        String language = readVar("language");
        return get(language);
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

