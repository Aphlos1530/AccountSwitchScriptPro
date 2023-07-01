package utils.mekos;

import static utils.translator.translate;

/**
 * 自定义输出类
 */
public class echo implements imeko {

    /**
     * 编码转译
     */
    public static void co(Integer code) {
        print(translate(code));
    }

    /**
     * 英文翻译
     */
    public static void co(String text) {
        if (text == null) {
            System.out.println();
            return;
        }
        if (text.endsWith("\r")) {
            System.out.print(text);
            return;
        }
        print(finalTreat(translate(text)));
    }

    /**
     * 打印输出
     */
    private static void print(String text) {
        if (text.endsWith(":") || text.endsWith("...")) {
            System.out.print(text + " ");
        } else {
            System.out.println(text);
            //System.out.print("\n" + text);
        }
    }

    /**
     * 末尾处理
     */
    private static String finalTreat(String text) {
        return text.trim();
    }

}
