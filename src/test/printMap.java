package test;

import java.util.Map;

public class printMap {

    public static void co(Map<String, String> map) {
        System.out.println("{");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
        System.out.println("}");
    }

}
