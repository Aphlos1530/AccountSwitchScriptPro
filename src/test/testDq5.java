package test;

public class testDq5 {

    public static void main(String[] args) {
        int width = 20;
        String text = "这是一个矩形边框的示例";
        System.out.println("单线边框：");
        System.out.println(getSingleLineBorder(width, text));
        System.out.println("双线边框：");
        System.out.println(getDoubleLineBorder(width, text));
        System.out.println("点线边框：");
        System.out.println(getDottedLineBorder(width, text));
        System.out.println("虚线边框：");
        System.out.println(getDashedLineBorder(width, text));
    }

    public static String getSingleLineBorder(int width, String text) {
        String border = "\u250c" + "\u2500".repeat(width-2) + "\u2510" + "\n";
        border += "\u2502" + centerText(width-2, text) + "\u2502" + "\n";
        border += "\u2514" + "\u2500".repeat(width-2) + "\u2518";
        return border;
    }
    public static String getDoubleLineBorder(int width, String text) {
        String border = "\u2554" + "\u2550".repeat(width-2) + "\u2557" + "\n";
        border += "\u2551" + centerText(width-2, text) + "\u2551" + "\n";
        border += "\u255a" + "\u2550".repeat(width-2) + "\u255d";
        return border;
    }
    public static String getDottedLineBorder(int width, String text) {
        String border = "\u256d" + "\u2500".repeat(width-2) + "\u256e" + "\n";
        border += "\u2502" + centerText(width-2, text) + "\u2502" + "\n";
        border += "\u2570" + "\u2500".repeat(width-2) + "\u256f";
        return border;
    }
    public static String getDashedLineBorder(int width, String text) {
        String border = "\u250f" + "\u2501".repeat(width-2) + "\u2513" + "\n";
        border += "\u2503" + centerText(width-2, text) + "\u2503" + "\n";
        border += "\u2517" + "\u2501".repeat(width-2) + "\u251b";
        return border;
    }
    public static String centerText(int width, String text) {
        int padding = width - text.length();
        int leftPadding = padding / 2;
        int rightPadding = padding - leftPadding;
        return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
    }
}
