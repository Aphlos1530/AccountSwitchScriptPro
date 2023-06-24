package utils;

import java.util.Scanner;

public class waitInput implements imeko {

    public static void co() {
        co("continue");
    }

    public static void co(String str) {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press any key to " + str + " ...");
        scanner.nextLine();
    }

    public static void co(Integer code) {
        switch (code) {
            case 1 -> co("pause");
            case 2 -> co("break");
            case -1 -> co("exit");
            default -> co("continue");
        }
    }

}
