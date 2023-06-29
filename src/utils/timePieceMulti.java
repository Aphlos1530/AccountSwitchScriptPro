package utils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class timePieceMulti {

    private static final Map<String, Long> startTimeMap = new HashMap<>();

    static {
        set();
    }

    public static void set() {
        set("def");
    }

    public static String get() {
        return get("def");
    }

    public static void set(String key) {
        Long startTime = System.currentTimeMillis();
        startTimeMap.put(key, startTime);
    }

    public static String get(String key) {
        Long startTime = startTimeMap.get(key);
        if (startTime == null) return "-1";
        Long endTime = System.currentTimeMillis();
        return calc(startTime, endTime);
    }

    private static String calc(Long startTime, Long endTime) {
        long elapsed = endTime - startTime;
        DecimalFormat df = new DecimalFormat("#.###");
        return df.format(elapsed / 1000.0);
    }

}
