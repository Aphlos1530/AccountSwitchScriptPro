package utils.mekos;

import java.util.Scanner;

public class input {


    private static final Scanner scanner = new Scanner(System.in);

    private static String read(String text) {
        String input = scanner.nextLine();
        return input;
    }


    private static String ToNumber(String text) {
        switch (text){
            case "零" -> text="0";
            case "一" -> text="1";
            case "二" -> text="2";
            case "三" -> text="3";
            case "四" -> text="4";
            case "五" -> text="5";
            case "六" -> text="6";
            case "七" -> text="7";
            case "八" -> text="8";
            case "九" -> text="9";
            case "十" -> text="10";
        }
        return text;
    }
}
