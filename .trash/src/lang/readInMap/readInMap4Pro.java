package lang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class readInMap4Pro {

    public static final Map<String, String> EN_TO_ZH_MAP = new HashMap<String, String>();

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
                    EN_TO_ZH_MAP.put(key, line);
                    key = null;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

