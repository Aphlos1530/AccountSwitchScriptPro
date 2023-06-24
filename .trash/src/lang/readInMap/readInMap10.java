package lang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class readInMap10 {

    public static final Map<String, String> EN_TO_ZH_MAP = new HashMap<String, String>();

    static {
        try {
            read( "src/note/translations.txt","short");
            read( "src/note/translations4.txt","long");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(EN_TO_ZH_MAP);
    }

    private static void read(String filePath, String type) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        String key = null;
        while (line != null && !line.equals("")) {
            line = line.trim();
            if (type.equals("short")) sht(line);
            if (type.equals("long")) key=lon(line,key);
            line = reader.readLine();
        }
        reader.close();
    }

    private static void sht( String line) {
        String[] parts = line.split("=", 2);
        if (parts.length == 2) {
            EN_TO_ZH_MAP.put(parts[0], parts[1]);
        }
    }

    private static String lon(String line, String key) {
        if (key != null) {
            EN_TO_ZH_MAP.put(key, line);
            key = null;
        } else {
            key = line;
        }
        return key;
    }

}

