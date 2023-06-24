package lang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class readInMap4 {
    public static final Map<String, String> EN_TO_ZH_MAP = new HashMap<String, String>();

    static {
//        Map<String, String> map = new HashMap<>();
        String filePath = "src/note/translations3.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            String key = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    key = null;
                } else if (key == null) {
                    key = line.trim();
                } else {
                    EN_TO_ZH_MAP.put(key, line.trim());
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

