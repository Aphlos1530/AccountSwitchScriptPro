package utils;

import java.util.LinkedList;
import java.util.List;

import static utils.meko.readSet;
import static utils.meko.readVar;
import static utils.translator.translate;

public class mekoMenu {

    private String title;

    private String navbar;

    private final List<String> itemList;

    //待实现：不显示游戏条//已实现

//    public void setBar(String bar) {
//
//    }

//    public void setTitle(String title) {
//
//    }

    public mekoMenu() {
        navbar = getGameBar();
        itemList = new LinkedList<>();
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


//        System.out.println("{");
//        int judex=1;
//        for (String item : itemList) {
//            System.out.println(judex + ". " + item);
//            judex++;
//        }
//        System.out.println("}");

        prepare();

        List<String> printLines = getPrintLines();
        for (String line : printLines) {
            System.out.println(line);
        }
    }


    private void prepare() {
        //翻译
        transCont();

        //计算长度
        calcMaxItemLen();

        //获取制表符
        setTabs();

        //计算空白间隔
        //calcBlankInterLen();

        //set
        setMekoBuilder();

    }



    //准备///其它//计算


    private void transCont() {

        navbar = translate(navbar);
        title = translate(title);

        List<String> list = new LinkedList<>();
        for (String item : itemList) {
            String[] split = item.split("\\.");
            if (split.length == 1) {
                list.add(translate(split[0]));
            }
            if (split.length == 2) {
                split[1] = translate(split[1]);
                list.add(split[0] + "." + split[1]);  //？？？？？？？？？？？？？英文情况
            }

            //System.out.println(list.get(list.size()-1));
        }

        itemList.clear();
        itemList.addAll(list);
    }


    private int maxItemLen;

    private void calcMaxItemLen() {
        maxItemLen = Math.max(title.length(), navbar.length());
        for (String item : itemList) {
            if (item.length() > maxItemLen) {
                maxItemLen = item.length();
            }
        }
        if (maxItemLen % 2 == 0) maxItemLen += 1;
    }


//    private char[] tab ;
//
//    private void setTabs() {
//        tab= tabChars.getTabs();
//    }

    private String[] tab ;

    private void setTabs() {
        char[] chars = tabChars.getTabs();
        tab = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            tab[i] = String.valueOf(chars[i]);
        }
    }

//    private int padLen;  //内部空白（最少)
//
//    private int magLen;  //外部空白
//
//    private void calcBlankInterLen() {
//        String language = readVar("language");
//        if (language.equals("English")) {
//            padLen = 4;
//            magLen = 0;
//        } else {
//            padLen = 2;
//            magLen = 1;
//        }
//    }


    private mekoBuilder builder;

    private void setMekoBuilder() {
        builder = new mekoBuilder();
    }

    private mekoBuilder getMekoBuilder(){
        builder.clear();
        return builder;
    }



    //主要功能

//    private List<String> getPrintLines() {
//        List<String> menuLines = getMenuLines();
//        List<String> printLines = new LinkedList<>();
//        for (String line : menuLines) {
//            printLines.add(convertLine(line));
//        }
//        return printLines;
//    }

    private List<String> getPrintLines() {
        return getMenuLines();
    }

    private List<String> getMenuLines() {

        List<String> mlist = new LinkedList<>();

        //导航条
        mlist.add(firstLine());
        if (showGameBar() && gameBarType().equals("up")) {
            mlist.add(barLine());
            mlist.add(middleLine());
        }

        //标题行
        mlist.add(blankLine());
        mlist.add(titleLine());
        mlist.add(blankLine());

        //子项行
        for (String item : itemList) {
            mlist.add(itemLine(item));
            mlist.add(blankLine());
        }

        //尾航条
        if (showGameBar() && gameBarType().equals("down")) {
            mlist.add(middleLine());
            mlist.add(barLine());
        }
        mlist.add(lastLine());

        return mlist;

    }

    private void test2(){
        String s1 = "　　　４．问题修复　　　　";
        String s2 = "　　　５．打开启动器　　　";
    }

    //
    private String firstLine() {
        return separateLine(tab[1], tab[3]);
    }

    private String middleLine() {
        return separateLine(tab[4],tab[6]);
    }


    private String lastLine() {
        return separateLine(tab[7],tab[9]);
    }

    private String barLine() {
        return centerContentLine(navbar);
    }

    private String titleLine() {
        return centerContentLine(title);
    }

    private String blankLine() {
        return centerContentLine("");
    }

    private String itemLine(String content) {
        return leftContentLine(content);
    }


    private String separateLine(String prefix, String suffix) {
//        mekoBuilder builder = new mekoBuilder();
        mekoBuilder builder = getMekoBuilder();
        String language = readSet("language");
        if (language.equals("English")) {



            builder.append(" ");
            for (int i = 1; i <= maxItemLen + 10; i++) {
                if (i % 2 == 1) builder.append("*");
                if (i % 2 == 0) builder.append(" ");
            }
            builder.append(" ");

        }else {
            builder.append(" ");
            builder.append(prefix);
            builder.appendMulti(tab[11],maxItemLen*2+8);
            builder.append(suffix);
            builder.append(" ");

            if (getEnv().equals("IDEA")){
                builder.remove(-3);
//                builder.remove(-6,-3);
            }

        }

        convertLine(builder);

        return builder.toString();
    }

    private String centerContentLine(String content) {
        int preSpace = (maxItemLen - content.length()) / 2;
        int sufSpace = maxItemLen - preSpace - content.length();

        return contentLine(content,preSpace,sufSpace);


    }

    private String leftContentLine(String content) {

        return contentLine(content,0,maxItemLen - content.length());
    }

    private String contentLine(String content, int preLen, int sufLen) {
        mekoBuilder builder = getMekoBuilder();
        String language = readSet("language");
        if (language.equals("English")) {
            builder.append(" * ");
            builder.appendMulti(" ", preLen + 3);
            builder.append(content);
            builder.appendMulti(" ", sufLen + 3);
            builder.append(" * ");

        } else {
            builder.append(" ");
            builder.append(tab[12]);
            builder.appendMulti(" ", preLen + 2);
            builder.append(content);
            builder.appendMulti(" ", sufLen + 2);
            builder.append(tab[12]);
            builder.append(" ");
            if (getEnv().equals("IDEA")) {
                builder.append(2, " ");
                builder.append(-2, " ");
            }
        }


//        return builder.toString();

//        String line = builder.toString();
//        return  convertLine(line);

        convertLine(builder);
//        builder.remove(-3);
//        builder.append(-3," ");
        return builder.toString();
    }

    private void convertLine(mekoBuilder line) {
        String language = readSet("language");
        if (!language.equals("English")) {
            halfToFull.convert(line);
            line.replace(" ", "\u3000");
        }
    }

//    private void convertLine(mekoBuilder line) {
//        String language = readSet("language");
//        if (!language.equals("English")) {
//            halfToFull.convert(line);
//
//            String env =getEnv();
//            if (env.equals("IDEA")) {
//                line.replace(" ", "\u3000");
////                line.replace(" ", "\u00A0");
////                line.replace(" ", "\u200B");
////                line.replace(" ", "\u200C");
////                line.replace(" ", "\u200D");
////                line.replace(" ", "\u2028");
////                line.replace(" ", "\uFEFF");
//            }else {
//
//                line.replace(" ", "\u3000");
//            }
//        }
//    }




    private String convertLine(String line) {
        //return HalfToFull.convert(line);
//        line = halfToFull.convert(line);
//        return line.replace(" ", "\u3000");


//        String language = readSet("language");
//        if (!language.equals("English")) {
//            line = halfToFull.convert(line);
//            return line.replace(" ", "\u3000");
//        }
//        return line;

        String language = readSet("language");
        if (language.equals("English")) return line;
        line = halfToFull.convert(line);
        return line.replace(" ", "\u3000");
    }




    // Game Bar

    private String getGameBar() {
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
        String show = readSet("showGameBar");
        return show.equals("true");
    }

    private String gameBarType() {
        return readSet("gameBarType");
    }

    ///////////////////////////////////////////

    private String getEnv() {
        if (System.console() == null) {
            return "IDEA";  //在 IDE 等其他环境中运行
        } else {
            return "CMD";  //在命令行中运行
        }
    }

    //////////////////////////////////////////////

    private boolean runInCmd() {
        return System.console() != null;
    }


    private String interBlank() {
        String language = readVar("language");
        if (language.equals("Chinese")) return "  ";
        return "    ";
    }

    private Integer getBlankInterLen() {
        String language = readVar("language");
        if (language.equals("Chinese")) return 2;
        return 4;
    }

//    private int blankInterLen;
//
//    private void calcBlankInterLen(){
//        String language = readVar("language");
//        if (language.equals("Chinese")) blankInterLen= 2;
//        blankInterLen=4;
//    }


    private void test(){
        //　┏━━━━━━━━━━━━━━━━━━━━━┓　
        //　┃　　　　崩　坏　４　　 　┃　
        //　┣━━━━━━━━━━━━━━━━━━━━━┫　
        //　┃　　　　　　　　　　　 　┃　
        //　┃　　　　　主菜单　　　 　┃　
        //　┃　　　　　　　　　　　 　┃　
        //　┃　　　１．账号切换　　 　┃　
        //　┃　　　　　　　　　　　 　┃　
        //　┃　　　２．账号管理　　 　┃　
        //　┃　　　　　　　　　　　 　┃　
        //　┃　　　３．设置　　　　 　┃　
        //　┃　　　　　　　　　　　 　┃　
        //　┃　　　４．问题修复　　 　┃　
        //　┃　　　　　　　　　　　 　┃　
        //　┃　　　５．打开启动器　 　┃　
        //　┃　　　　　　　　　　　 　┃　
        //　┃　　　６．帮助　　　　 　┃　
        //　┃　　　　　　　　　　　 　┃　
        //　┃　　　－１．退出　　　 　┃　
        //　┃　　　　　　　　　　　 　┃　
        //　┗━━━━━━━━━━━━━━━━━━━━━┛　
        //
        //进程已结束,退出代码0
    }


    private void test1(){
        //
        //　┏━━━━━━━━━━━━━━━━━━━━━┓　
        //　┃　　　　崩　坏　４　　　　┃　
        //　┣━━━━━━━━━━━━━━━━━━━━━┫　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　　　主菜单　　　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　１．账号切换　　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　２．账号管理　　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　３．设置　　　　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　４．问题修复　　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　５．打开启动器　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　６．帮助　　　　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　－１．退出　　　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┗━━━━━━━━━━━━━━━━━━━━━┛　
        // /
    }




//    private void calcBlankInterLen(){
//        String language = readVar("language");
//        if (language.equals("Chinese")) blankInterLen= 2;
//        blankInterLen=4;
//    }
//

    private void sss() {
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


//        tabs=new char[] {'╋','┏','┓','┗','┛','┣','┫','┳','┻','━','┃'};
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

//        U+254B，对应的字符是  `╋`

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

        //这几个字符是 Unicode 字符，对应的编码如下：
        // -  `╔` ：U+2554
        //-  `╗` ：U+2557
        //-  `╚` ：U+255A
        //-  `╝` ：U+255D
        //-  `═` ：U+2550
        //-  `║` ：U+2551
        //-  `╦` ：U+2566
        //-  `╩` ：U+2569
        //-  `╠` ：U+2560
        //-  `╣` ：U+2563
        //-  `╬` ：U+256C
        // 在 Java 中，可以使用 Unicode 编码来表示这些字符，例如：
        //char c = '\u2554'; // 表示字符 '╔'
        //需要注意的是，Java 中的字符类型是 16 位 Unicode 字符，因此可以直接使用 Unicode 编码来表示这些字符。

        //　┏━━━━━━━━━━━━━━━━━━━━━┓　
        //　┃　　　　崩　坏　４　　 　┃　
        //　┣━━━━━━━━━━━━━━━━━━━━━┫　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　　　主菜单　　　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　１．账号切换　　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　２．账号管理　　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　３．设置　　　　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　４．问题修复　　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　５．打开启动器　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　６．帮助　　　　　　┃　
        //　┃　　　　　　　　　　　　　┃　
        //　┃　　　－１．退出　　　 　┃　
        //　┃　　　　　　　　　　　　 ┃　
        //　┗━━━━━━━━━━━━━━━━━━━━━┛　

        //
        //　┏━━━━━━━━━━━━━━━━━━━━━━┓　
        //　┃　　　崩　坏　４　　　┃　
        //　┣━━━━━━━━━━━━━━━━━━━━━━┫　
        //　┃　　　　　　　　　　　┃　
        //　┃　　　　主菜单　　　　┃　
        //　┃　　　　　　　　　　　┃　
        //　┃　　１．账号切换　　　┃　
        //　┃　　　　　　　　　　　┃　
        //　┃　　２．账号管理　　　┃　
        //　┃　　　　　　　　　　　┃　
        //　┃　　３．设置　　　　　┃　
        //　┃　　　　　　　　　　　┃　
        //　┃　　４．问题修复　　　┃　
        //　┃　　　　　　　　　　　┃　
        //　┃　　５．打开启动器　　┃　
        //　┃　　　　　　　　　　　┃　
        //　┃　　６．帮助　　　　　┃　
        //　┃　　　　　　　　　　　┃　
        //　┃　　－１．退出　　　　┃　
        //　┃　　　　　　　　　　　┃　
        //　┗━━━━━━━━━━━━━━━━━━━━━━┛　/



    }


}
