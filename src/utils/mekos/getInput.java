package utils.mekos;

import java.util.Scanner;

// 待修改
public class getInput implements imeko {

    public static String co() {
        return co(1);
    }

    public static String co(String text) {
        if (text == null || text.equals("")) return co(1);
        return read(text);
    }

    public static String co(Integer textCode) {
        String text = switch (textCode) {
            case 1 -> "Please enter your choice and press enter : ";
            case 2 -> "Input error ! please input again : ";
            default -> "";
        };
        return read(text);
    }

    private static String read(String text) {
        Scanner scanner = new Scanner(System.in);
        echo.co("");
        echo.co(text);
        return scanner.nextLine();
    }

    public static final String PROMPT_MESSAGE = "Please enter your choice : ";
    public static final String ERROR_MESSAGE = "Input error ! please input again : ";

}
