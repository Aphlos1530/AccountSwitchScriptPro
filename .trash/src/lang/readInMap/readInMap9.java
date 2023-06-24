package lang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class readInMap9 {

    public static final Map<String, String> EN_TO_ZH_MAP_SHORT = new HashMap<String, String>();

    public static final Map<String, String> EN_TO_ZH_MAP_LONG = new HashMap<String, String>();

    static {

        try {
            String filePath = "src/note/translations3.txt";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            String key = null;
            while (line != null) {
                line=line.trim();
                if (key == null) {
                    key = line;
                } else {
                    EN_TO_ZH_MAP_LONG.put(key, line);
                    key = null;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            String filename = "src/note/translations.txt";
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    EN_TO_ZH_MAP_SHORT.put(key, value);
                }
                line = reader.readLine();
            }
            reader.close();

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

