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
        print(translate(text));
    }

    /**
     * 打印输出
     */
    private static void print(String text) {
        text = text.trim();
        if (text.endsWith(":") || text.endsWith("...")) {
            System.out.print(text + " ");
        } else {
            System.out.println(text);
        }
    }

}
