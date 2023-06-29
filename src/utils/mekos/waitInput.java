package utils.mekos;

import java.util.Scanner;

// 待改名
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

    public static void main(String[] args) throws Exception {
        System.out.println("Press any key to continue...");
        while (System.in.read() == -1) {
            Thread.sleep(100);
        }
        System.out.println("Continuing...");
    }

}
