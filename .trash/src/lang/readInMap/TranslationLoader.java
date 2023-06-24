package lang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class TranslationLoader {
    public static Map<String, String> loadTranslations(String filename) throws IOException {
        Map<String, String> translations = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("=", 2);
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                translations.put(key, value);
            }
        }
        reader.close();
        return translations;
    }
}