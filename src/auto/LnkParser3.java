package auto;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LnkParser3 {

    // convert two bytes into a short // note, this is little endian because
    // it's for an // Intel only OS.
    //将两个字节转换为一个简短的说明，这是小端序，因为它只适用于英特尔操作系统。

    static int norm(byte b) {
        if (b < 0) {
            b += 128;
        }
        return b;
    }

    static int bytes2int(byte[] arr, int off) {
        int b1 = norm(arr[off]);
        int b2 = norm(arr[off + 1]);
        int b3 = norm(arr[off + 2]);
        int b4 = norm(arr[off + 3]);
        int val = ((b1) | (b2 << 8) | (b3 << 16) | (b4 << 24));
        p("bytes2int: " + b1 + " " + b2 + " " + b3 + " " + b4);
        return val;
    }


    static NumberFormat num_format = new DecimalFormat(" 000;-000");

    public static String padd(String str, int len) {
        StringBuilder strBuilder = new StringBuilder(str);
        while (strBuilder.length() < len) {
            strBuilder.insert(0, " ");
        }
        str = strBuilder.toString();
        return str;
    }

    public static void pw(byte[] arr, int off) {
        StringBuilder top = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder bot = new StringBuilder();
        top.append("--");
        mid.append("  ");
        bot.append("  ");

        for (int i = 0; i < 16; i++) {
            int val = arr[off + i];
            String str = Integer.toHexString(off + i);
            top.append(padd(str, 5));
            mid.append(padd(String.valueOf(val), 5));
            if (val < 0) {
                val += 128;
            }
            if (val >= ' ' && val <= '~') {
                str = String.valueOf((char) val);
            } else {
                str = Integer.toHexString(val);
            }
            str = padd(str, 5);
            bot.append(str);
            if (i % 4 == 3) {
                top.append("    ");
                mid.append("    ");
                bot.append("    ");
            }
        }
        p(top.toString());
        p(mid.toString());
        p(bot.toString());
    }

    public static void pbits(byte bt) {
        p("byte = " + bt + " " + Integer.toHexString(bt) + " " + Integer.toBinaryString(bt));
    }


    public static void p(String str) {
        System.out.println(str);
    }
}
