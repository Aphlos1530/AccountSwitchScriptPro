package utils;

public class halfToFull {

    private static final int START = 33;
    private static final int END = 126;
    private static final int OFFSET = 65248;

    public static String convert(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (START <= ch && ch <= END) {
                result.append((char) (ch + OFFSET));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static mekoBuilder convert(mekoBuilder builder) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= builder.length(); i++) {
            char ch = builder.charAt(i);
            if (START <= ch && ch <= END) {
                result.append((char) (ch + OFFSET));
            } else {
                result.append(ch);
            }
        }
        builder.set(result);
        return builder;
    }


}