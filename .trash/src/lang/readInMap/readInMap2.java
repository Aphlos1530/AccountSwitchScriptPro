package lang;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class readInMap2 {
    public static final Map<String, String> EN_TO_ZH_MAP = new HashMap<String, String>();

    static {
//        Map<String, String> map = new HashMap<>();
        String filePath = "src/note/translations2.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim().replace("{", "").replace("}", "");
                    String value = parts[1].trim().replace("{", "").replace("}", "");
                    EN_TO_ZH_MAP.put(key, value);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

//        System.out.println(EN_TO_ZH_MAP);
    }
}

