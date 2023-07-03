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
     * 句子翻译
     */
    public static void co(String text) {
        if (text == null || text.equals("")) {
            System.out.println();
        } else if (text.equals("\r")) {
            carriFlag = true;
            System.out.print(text);
        } else {
            print(finalTreat(translate(text)));
        }
    }

    /**
     * 打印输出
     */
    private static void print(String text) {
        if (text.endsWith(":") || text.endsWith("...")) {
            System.out.print(text + " ");
        } else {
            System.out.println(text);
            //System.out.print("\n" + text);//无法首行显示和清空行，故废弃
        }
    }

    /**
     * 末尾处理
     */
    private static String finalTreat(String text) {

        //text = text.trim();  //翻译者已做处理

        //以下内容是为\ r 专门设计的，以达到清空该行前面所有的字符的效果

        if (IDEA) return text;  //IDEA下不需要补空格，直接无视后面所有相关操作

        if (carriFlag) {
            int spaceLen = lastTextLength - text.length();  //文本的差值就是需要补足的空格的字数
            if (spaceLen > 0) text += " ".repeat(spaceLen);  //比上次的文本长（或等长），无需补空格
        }

        carriFlag = text.endsWith("\r");
        lastTextLength = text.length();
        return text;

    }

    //新增内置变量

    private static boolean carriFlag = false;  //行清空标志（上次是否以 \r 结尾）

    private static int lastTextLength = 0;  //记录上次文字的长度（用于于补足空格）

    private static final boolean IDEA = (System.console() == null);   //在 CMD 中运行还是 IDEA 中运行

}
