package utils;

import java.util.LinkedList;
import java.util.List;

import static utils.meko.readVar;
import static utils.translator.translate;

public class mekoMenu {

    private String title;

    private String bar;

    private final List<String> itemList;

    //待实现：不显示游戏条

//    public void setBar(String bar) {
//
//    }

//    public void setTitle(String title) {
//
//    }

    public mekoMenu() {
        this.bar = getGameItem();
//        this.bar = "";


        this.itemList = new LinkedList<>();

    }


    public void set(String title) {
        this.title = title;
    }

    public void put(String item) {
        this.itemList.add(item);

    }


    public void print() {

//        System.out.println("{");
//        int index=1;
//        for (String item : itemList) {
//            System.out.println(index + ". " + item);
//            index++;
//        }
//        System.out.println("}");


        //翻译
        translateItems();

//        System.out.println("{");
//        int judex=1;
//        for (String item : itemList) {
//            System.out.println(judex + ". " + item);
//            judex++;
//        }
//        System.out.println("}");


        List<String> printLines = getPrintLines();
        for (String line : printLines) {
            System.out.println(line);
        }
    }


    private void translateItems() {

        bar = translate(bar);
        title = translate(title);

        List<String> list = new LinkedList<>();
        for (String item : itemList) {


//            System.out.println("index = "+ind);

//            System.out.println();
//            System.out.println("item = "+item);

            String[] split = item.split("\\.");
            split[1] = translate(split[1]);
            list.add(split[0] + "." + split[1]);

//            System.out.println();
//            System.out.println("item = "+item);
//            ind++;
        }
        itemList.clear();
        itemList.addAll(list);


    }


    private List<String> getPrintLines() {
        List<String> menuLines = getMenuLines();
        List<String> printLines = new LinkedList<>();
        for (String line : menuLines) {

            //line=translator.translate(line);

            //System.out.println("line = "+line);

            printLines.add(convertLine(line));
        }
        return printLines;
    }

    private List<String> getMenuLines() {
        List<String> mlist = new LinkedList<>();
//        getMaxItemLen();
        calcMaxItemLen();
        if (showGameBar()) {
            if (gameBarType().equals("up")) {

                //bar=getGameItem();

                mlist.add(getFirstLine());
                //mlist.add(getBlankLine());
                mlist.add(getBarLine());
                //mlist.add(getBlankLine());


                mlist.add(getMiddleLine());
                mlist.add(getBlankLine());
                mlist.add(getTiTleLine());
                mlist.add(getBlankLine());

            } else {
                mlist.add(getFirstLine());
                mlist.add(getBlankLine());
                mlist.add(getTiTleLine());
                mlist.add(getBlankLine());
            }


        } else {

            mlist.add(getFirstLine());
            mlist.add(getBlankLine());
            mlist.add(getTiTleLine());
            mlist.add(getBlankLine());
        }


//        getMaxItemLen();


//        int ind=1;
        for (String item : itemList) {
//            System.out.println();
//            System.out.println("item = "+item);

            mlist.add(getItemLine(item));
            mlist.add(getBlankLine());

//            System.out.println();
//            //System.out.println("index = "+ind);
//            System.out.println("item = "+item);
//            ind++;
        }


        if (showGameBar()) {
            if (gameBarType().equals("down")) {

                mlist.add(getMiddleLine());
                //mlist.add(getBlankLine());
                mlist.add(getBarLine());
                //mlist.add(getBlankLine());
                mlist.add(getLastLine());


            } else {
                mlist.add(getLastLine());
            }
        } else {

            mlist.add(getLastLine());
        }
        return mlist;
    }

    private String getFirstLine() {
        String prefix = " ┏━━━━";
        String suffix = "━━━━┓ ";
        return prefix + "━━".repeat(maxItemLen) + suffix;
    }

    private String getBarLine() {
        String prefix = " ┃  ";
        String suffix = "  ┃ ";
        int preSpace = (maxItemLen - bar.length()) / 2;
        int sufSpace = maxItemLen - preSpace - bar.length();

//        System.out.println("bar = "+bar);
//        System.out.println("barLength = "+bar.length());
//        System.out.println("preSpace = "+preSpace);
//        System.out.println("sufSpace = "+sufSpace);

        return prefix + " ".repeat(preSpace) + bar + " ".repeat(sufSpace) + suffix;
    }

    private String getMiddleLine() {
        String prefix = " ┣━━━━";
        String suffix = "━━━━┫ ";
        return prefix + "━━".repeat(maxItemLen) + suffix;

//        String prefix = " ┣━━";
//        String suffix = "━━┫ ";
//        return prefix + "━━".repeat(maxItemLen+2) + suffix;
    }


    private String getTiTleLine() {
        String prefix = " ┃  ";
        String suffix = "  ┃ ";
        int preSpace = (maxItemLen - title.length()) / 2;
        int sufSpace = maxItemLen - preSpace - title.length();
        return prefix + " ".repeat(preSpace) + title + " ".repeat(sufSpace) + suffix;
    }

    private String getBlankLine() {
        String prefix = " ┃  ";
        String suffix = "  ┃ ";
        return prefix + " ".repeat(maxItemLen) + suffix;

//        String prefix = " ┃";
//        String suffix = "┃ ";
//        return prefix + " ".repeat(maxItemLen+2) + suffix;
    }

    private String getItemLine(String content) {
        String prefix = " ┃  ";
        String suffix = "  ┃ ";
        return prefix + content + " ".repeat(maxItemLen - content.length()) + suffix;
    }

    private String getLastLine() {
        String prefix = " ┗━━━━";
        String suffix = "━━━━┛ ";
        return prefix + "━━".repeat(maxItemLen) + suffix;


//        String prefix = " ┗━━";
//        String suffix = "━━┛ ";
//        return prefix + "━━".repeat(maxItemLen+2) + suffix;
    }

    private String convertLine(String line) {
        //return HalfToFull.convert(line);
        line = HalfToFull.convert(line);
        return line.replace(" ", "\u3000");
    }


    private int maxItemLen;

    private void calcMaxItemLen() {

//        System.out.println("titleLength = "+title.length());
//        System.out.println("barLength = "+bar.length());

        maxItemLen = Math.max(title.length(), bar.length());


//        System.out.println("maxItemLen = "+maxItemLen);


        for (String item : itemList) {
            if (item.length() > maxItemLen) {
                maxItemLen = item.length();
            }
        }
//
//        System.out.println("maxItemLen = "+maxItemLen);

        //缺少：奇偶检验

        if (maxItemLen % 2 == 0) maxItemLen += 1;
    }

    private String getGameItem() {
        String eMode = readVar("eMode");
        return switch (eMode) {
            case "1" -> "Genshin Impact";
            case "2" -> "Star Rail";
            case "3" -> "Honkai Impact 4";
            case "" -> "No games";
            default -> "Unknown game";
        };
    }


    private boolean showGameBar() {
        String show = readVar("showGameBar");
        return !show.equals("false");
    }

    private String gameBarType() {
        String type = readVar("gameBarType");
        if (type.equals("")) return "up";
        return type;
    }

    private String getEnv() {
        if (System.console() == null) {
            return "IDEA";  //在 IDE 等其他环境中运行
        } else {
            return "CMD";  //在命令行中运行
        }
    }

    private boolean runInCmd() {
        return System.console() != null;
    }

    private void sss(){
//                -  ┏ ：左上角
//                -  ┓ ：右上角
//                -  ┗ ：左下角
//                -  ┛ ：右下角
//                -  ━ ：长横线
//                -  ┃ ：长竖线
//                -  ┣ ：右端竖线交叉
//                -  ┫ ：左端竖线交叉
//                -  ┳ ：下横线交叉
//                -  ┻ ：上横线交叉


        //-  ┏ ：U+250F
        //-  ┓ ：U+2513
        //-  ┗ ：U+2517
        //-  ┛ ：U+251B
        //-  ┣ ：U+2523
        //-  ┫ ：U+252B
        //-  ┳ ：U+2533
        //-  ┻ ：U+253B
        //-  ┠ ：U+2520
        //-  ┨ ：U+2528
        //-  ┯ ：U+252F
        //-  ┷ ：U+2537

        //以下是上面提到的十个字符及其 Unicode 编码：
        //-  `┌` ：U+250C
        //-  `┐` ：U+2510
        //-  `└` ：U+2514
        //-  `┘` ：U+2518
        //-  `─` ：U+2500
        //-  `│` ：U+2502
        //-  `┬` ：U+252C
        //-  `┴` ：U+2534
        //-  `├` ：U+251C
        //-  `┤` ：U+2524
        // 您可以使用 Python 的  `ord()`  函数来查询这些字符的 Unicode 编码，例如：
        //print(hex(ord('┌')))
        //该代码将输出字符  `┌`  的 Unicode 编码  `0x250c` 。

        //非常抱歉，我误解了您的意思。如果您需要绘制比较粗的虚线边框，可以使用以下字符：
        //-  `╔` ：左上角
        //-  `╗` ：右上角
        //-  `╚` ：左下角
        //-  `╝` ：右下角
        //-  `═` ：横线
        //-  `║` ：竖线
        //-  `╦` ：上横线交叉
        //-  `╩` ：下横线交叉
        //-  `╠` ：右端竖线交叉
        //-  `╣` ：左端竖线交叉
        //-  `╬` ：横竖线交叉
        // 例如，以下代码可以生成一个包含两个空格的虚线矩形框：
        //您可以根据需要，调整字符的排列方式和数量，以绘制出您需要的虚线边框。

        //- 圆角：
        //  -  ╭ ：左上圆角
        //  -  ╮ ：右上圆角
        //  -  ╰ ：左下圆角
        //  -  ╯ ：右下圆角

        //以下是您所列出的这些 Unicode 字符的编码，对应的十六进制编码为：
        //-  `┏` ：U+250F
        //-  `┓` ：U+2513
        //-  `┗` ：U+2517
        //-  `┛` ：U+251B
        //-  `━` ：U+2501
        //-  `┃` ：U+2503
        //-  `┣` ：U+2523
        //-  `┫` ：U+252B
        //-  `┳` ：U+2533
        //-  `┻` ：U+253B
        // 这些字符的编码是 Unicode 标准中的一部分，可以在各种支持 Unicode 的平台上使用。

        //这个系列中有十字的字符，编码如下：
        //-  `┼` ：U+253C
        //十字是由横线和竖线相交形成的，因此  `┼`  字符可以用来绘制十字。

        //很抱歉，之前我的回答有误。实际上，有十一个字符可以用来绘制虚线边框，包括：
        //-  `┌` ：左上角
        //-  `┐` ：右上角
        //-  `└` ：左下角
        //-  `┘` ：右下角
        //-  `─` ：横线
        //-  `│` ：竖线
        //-  `┬` ：上横线交叉
        //-  `┴` ：下横线交叉
        //-  `├` ：右端竖线交叉
        //-  `┤` ：左端竖线交叉
        //-  `┼` ：横竖线交叉
        // 其中，使用  `┼`  可以绘制出十字形的虚线边框。


        //以下是常见虚线边框字符的 Unicode 编码：
        //-  `┌` ：U+250C
        //-  `┐` ：U+2510
        //-  `└` ：U+2514
        //-  `┘` ：U+2518
        //-  `─` ：U+2500
        //-  `│` ：U+2502
        //-  `┬` ：U+252C
        //-  `┴` ：U+2534
        //-  `├` ：U+251C
        //-  `┤` ：U+2524
        //-  `┼` ：U+253C

        //请注意，这些字符的编码可能会因不同的字符集而有所不同。

        //非常抱歉，我理解有误。实际上，这个系列中有细线和粗线两种不同粗细的字符。细线的字符编码如下：
        //-  `┌` ：U+250C
        //-  `┐` ：U+2510
        //-  `└` ：U+2514
        //-  `┘` ：U+2518
        //-  `─` ：U+2500
        //-  `│` ：U+2502
        //-  `┬` ：U+252C
        //-  `┴` ：U+2534
        //-  `├` ：U+251C
        //-  `┤` ：U+2524
        // 粗线的字符编码如下：
        //-  `┏` ：U+250F
        //-  `┓` ：U+2513
        //-  `┗` ：U+2517
        //-  `┛` ：U+251B
        //-  `━` ：U+2501
        //-  `┃` ：U+2503
        //-  `┳` ：U+2533
        //-  `┻` ：U+253B
        //-  `┣` ：U+2523
        //-  `┫` ：U+252B
        // 这些字符可以根据需要灵活使用，以绘制出不同粗细的虚线边框。

        //如果您是在问虚线边框字符中是否有粗细不同的版本，那么实际上有一些字符有粗细不同的版本，例如：
        //-  `─` ：细横线
        //-  `━` ：粗横线
        //-  `│` ：细竖线
        //-  `┃` ：粗竖线
        //-  `┌` ：细左上角
        //-  `┏` ：粗左上角
        //-  `┐` ：细右上角
        //-  `┓` ：粗右上角
        //-  `└` ：细左下角
        //-  `┗` ：粗左下角
        //-  `┘` ：细右下角
        //-  `┛` ：粗右下角
        //-  `┬` ：细上横线交叉
        //-  `┳` ：粗上横线交叉
        //-  `┴` ：细下横线交叉
        //-  `┻` ：粗下横线交叉
        //-  `├` ：细右端竖线交叉
        //-  `┣` ：粗右端竖线交叉
        //-  `┤` ：细左端竖线交叉
        //-  `┫` ：粗左端竖线交叉
        //-  `┼` ：细横竖线交叉
        //-  `╋` ：粗横竖线交叉
        //这些字符的粗细版本可以根据需要灵活使用，以绘制出不同粗细的虚线边框。

        //Unicode 中，粗横竖线交叉的编码是 U+254B，对应的字符是  `╋` 。

    }


}
