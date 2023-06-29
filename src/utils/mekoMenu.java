package utils;

import java.util.LinkedList;
import java.util.List;

import static utils.meko.readSet;
import static utils.meko.readVar;
import static utils.translator.translate;

public class mekoMenu {

    private String navbar;

    private String title;

    private final List<String> itemList;

    public mekoMenu() {
        navbar = getGameBar();
        itemList = new LinkedList<>();
    }

    /**
     * 设置标题
     */
    public void set(String argTitle) {
        title = argTitle;
    }

    /**
     * 放入子项
     */
    public void put(String item) {
        itemList.add(item);
    }

    /**
     * 打印菜单
     */
    public void print() {

        //翻译菜单内容
        transContent();

        //计算最大内容长度
        calcMaxItemLen();

        //获取表格绘制符
        setTabs();

        //获取每一行菜单
        List<String> printLines = getMenuLines();

        //打印菜单
        for (String line : printLines) {
            System.out.println(line);
        }

    }


    //准备工作


    /**
     * 翻译菜单内容
     */
    private void transContent() {
        navbar = translate(navbar);
        title = translate(title);
        List<String> list = new LinkedList<>();
        for (String item : itemList) {
            String[] split = item.split("\\.");
            if (split.length == 1) {  //无序号
                list.add(translate(split[0]));
            }
            if (split.length == 2) {  //有序号
                split[1] = translate(split[1]);
                list.add(split[0] + "." + split[1]);
            }
        }
        itemList.clear();
        itemList.addAll(list);
    }

    private int maxItemLen;  //该长度是指文字的长度，不包括空格及制表符

    /**
     * 计算最大内容长度
     */
    private void calcMaxItemLen() {
        maxItemLen = Math.max(title.length(), navbar.length());
        for (String item : itemList) {
            if (item.length() > maxItemLen) maxItemLen = item.length();
        }
        if (maxItemLen % 2 == 0) maxItemLen += 1;  //转为奇数以适配标题
    }

    private String[] tab;  //使用字符串类型是为了方便调用拼接方法

    /**
     * 获取表格绘制符
     */
    private void setTabs() {
        char[] chars = tabChars.getTabs();
        tab = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            tab[i] = String.valueOf(chars[i]);
        }
    }

    private final mekoBuilder builder = new mekoBuilder();  //原生字符串类不好用，自己封装一个

    /**
     * 获取自定义字符串类
     */
    private mekoBuilder getMekoBuilder() {
        return builder.clear();  //清空原对象并返回，避免重复构造新对象
    }


    //核心功能


    /**
     * 获取每一行菜单
     */
    private List<String> getMenuLines() {
        List<String> mlist = new LinkedList<>();
        //导航条
        mlist.add(firstLine());
        if (showGameBar && gameBarType.equals("up")) {
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
        if (showGameBar && gameBarType.equals("down")) {
            mlist.add(middleLine());
            mlist.add(barLine());
        }
        mlist.add(lastLine());
        return mlist;
    }

    //七种行

    private String firstLine() {
        return separateLine(tab[1], tab[3]);
    }

    private String middleLine() {
        return separateLine(tab[4], tab[6]);
    }

    private String lastLine() {
        return separateLine(tab[7], tab[9]);
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

    //三类行的具体实现

    /**
     * 分隔行
     */
    private String separateLine(String prefix, String suffix) {
        mekoBuilder builder = getMekoBuilder();
        if (language.equals("English")) {
            builder.append(" ");
            for (int i = 1; i <= maxItemLen + 10; i++) {
                if (i % 2 == 1) builder.append("*");
                if (i % 2 == 0) builder.append(" ");
            }
            builder.append(" ");
        } else {
            builder.append(" ");
            builder.append(prefix);
            builder.appendMulti(tab[11], maxItemLen * 2 + 8);
            builder.append(suffix);
            builder.append(" ");
            if (environment.equals("IDEA")) {
                builder.remove(-3); //删去一根横线
            }
        }
        convertLine(builder);  //字符转换
        return builder.toString();
    }

    /**
     * 居中对齐的内容行
     */
    private String centerContentLine(String content) {
        int preSpace = (maxItemLen - content.length()) / 2;
        int sufSpace = maxItemLen - content.length() - preSpace;
        return contentLine(content, preSpace, sufSpace);
    }

    /**
     * 左对齐的内容行
     */
    private String leftContentLine(String content) {
        int remSpace = maxItemLen - content.length();
        return contentLine(content, 0, remSpace);
    }

    /**
     * 内容行
     */
    private String contentLine(String content, int preLen, int sufLen) {
        mekoBuilder builder = getMekoBuilder();
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
            if (environment.equals("IDEA")) {
                //前后各加一个空格
                builder.append(2, " ");
                builder.append(-2, " ");
            }
        }
        convertLine(builder);  //字符转换
        return builder.toString();
    }


    //其它辅助功能


    /**
     * 半角字符转全角字符
     */
    private void convertLine(mekoBuilder line) {
        if (!language.equals("English")) {
            halfToFull.convert(line);
            line.replace(" ", "\u3000");
        }
    }

    /**
     * 获取游戏名称
     */
    private String getGameBar() {
        String eMode = readSet("eMode");
        return switch (eMode) {
            case "1" -> "Genshin Impact";
            case "2" -> "Star Rail";
            case "3" -> "Honkai Impact 4";
            case ""  -> "No games";
            default  -> "Unknown game";
        };
    }


    //内置变量


    private final Boolean showGameBar = readSet("showGameBar").equals("true");

    private final String gameBarType = readSet("gameBarType");  //游戏条顶置或底置

    private final String language = readSet("language");  //当前文字语言

    private final String environment = System.console() == null ? "IDEA" : "CMD";   //在CMD中运行还是IDEA中运行


}
