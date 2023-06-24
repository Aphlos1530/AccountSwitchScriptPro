package lang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class readInMap {

    public static final Map<String, String> EN_TO_ZH_MAP = new HashMap<String, String>();

    static {

        try {


//            try {
                String filename = "src/note/translations.txt";
                BufferedReader reader = new BufferedReader(new FileReader(filename));

//            System.out.println(reader);

//            } catch (IOException e) {
//                System.out.println("Failed to load translations from file1: " + filename);
//            }
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    EN_TO_ZH_MAP.put(key, value);
                }
            }
            reader.close();

        } catch (Exception ignored) {

//            System.out.println("Exception!");
        }

//        System.out.println(EN_TO_ZH_MAP);
    }


}
