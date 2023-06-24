package lang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class readInMap12 {

    public static final Map<String, String> EN_TO_ZH_MAP = new HashMap<String, String>();

    public static final Map<String, String> VAR_MAP = new HashMap<String, String>();

    static {
        try {
            read( "src/note/translations.txt", EN_TO_ZH_MAP, 1);
            read( "src/note/translations4.txt", EN_TO_ZH_MAP,2);
            read( "src/temp/variable.ini", VAR_MAP, 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(EN_TO_ZH_MAP);
    }

    private static void read(String filePath, Map<String, String> map, Integer type) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        String key = null;
        while (line != null && !line.equals("")) {
            line = line.trim();
            if (type==1) sht(line,map);
            if (type==2) key=lon(line,key,map);
            line = reader.readLine();
        }
        reader.close();
    }

    private static void sht( String line, Map<String, String> map) {
        String[] parts = line.split("=", 2);
        if (parts.length == 2) {
            map.put(parts[0], parts[1]);
        }
    }

    private static String lon(String line, String key, Map<String, String> map) {
        if (key != null) {
            map.put(key, line);
            key = null;
        } else {
            key = line;
        }
        return key;
    }

}

