package utils;

import java.text.DecimalFormat;

public class timePiece {

    private static long startTime = System.currentTimeMillis();

    public static void set() {
        startTime = System.currentTimeMillis();
    }

    public static String get() {
        long endTime = System.currentTimeMillis();
        return calc(startTime, endTime);
    }

    private static String calc(long startTime, long endTime) {
        long elapsed = endTime - startTime;
        DecimalFormat df = new DecimalFormat("#.###");
        return df.format(elapsed / 1000.0);
    }

}
