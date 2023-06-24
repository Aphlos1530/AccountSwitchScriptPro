package lang;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class readInMap3 {
    public static final Map<String, String> EN_TO_ZH_MAP = new HashMap<String, String>();

    static {
//        Map<String, String> map = new HashMap<>();
        String filePath = "src/note/translations3.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            String key = null;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                if (key == null) {
                    key = line;
                } else {
                    EN_TO_ZH_MAP.put(key, line);
                    key = null;
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        System.out.println(EN_TO_ZH_MAP);
    }
}

