package utils;

import java.util.LinkedList;
import java.util.List;

import static utils.meko.readVar;
import static utils.translator.translate;

public class MekoMenu2 {

    private String title;
    private String bar;
    private final List<String> itemList;
    private int maxItemLen;

    public MekoMenu2() {
        this.bar = getGameItem();
        this.itemList = new LinkedList<>();
    }

    public void set(String title) {
        this.title = title;
    }

    public void put(String item) {
        this.itemList.add(item);
    }

    public void print() {
        translateItems();
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
            String[] split = item.split("\\.");
            split[1] = translate(split[1]);
            list.add(split[0] + "." + split[1]);
        }
        itemList.clear();
        itemList.addAll(list);
    }

    private List<String> getPrintLines() {
        List<String> menuLines = getMenuLines();
        List<String> printLines = new LinkedList<>();
        for (String line : menuLines) {
            printLines.add(convertLine(line));
        }
        return printLines;
    }

    private List<String> getMenuLines() {
        List<String> menuLines = new LinkedList<>();
        getMaxItemLen();
        if (showGameBar()) {
            addMenuLines(menuLines, gameBarType().equals("up"));
        } else {
            addMenuLines(menuLines, false);
        }
        return menuLines;
    }

    private void addMenuLines(List<String> menuLines, boolean showGameBarUp) {
        menuLines.add(getFirstLine());
        menuLines.add(getBlankLine());
        menuLines.add(getTitleLine());
        menuLines.add(getBlankLine());
        if (showGameBarUp) {
            menuLines.add(getBarLine());
            menuLines.add(getMiddleLine());
        }
        for (String item : itemList) {
            menuLines.add(getItemLine(item));
            menuLines.add(getBlankLine());
        }
        if (!showGameBarUp) {
            menuLines.add(getMiddleLine());
            menuLines.add(getBarLine());
        }
        menuLines.add(getLastLine());
    }

    private String getFirstLine() {
        return createLine(" ┏━━━━", "━━━━┓ ");
    }

    private String getBarLine() {
        return createLine(" ┃  ", "  ┃ ", bar);
    }

    private String getMiddleLine() {
        return createLine(" ┣━━━━", "━━━━┫ ");
    }

    private String getTitleLine() {
        return createLine(" ┃  ", "  ┃ ", title);
    }

    private String getBlankLine() {
        return createLine(" ┃  ", "  ┃ ", "");
    }

    private String getItemLine(String content) {
        return createLine(" ┃  ", "  ┃ ", content);
    }

    private String getLastLine() {
        return createLine(" ┗━━━━", "━━━━┛ ");
    }

    private String createLine(String prefix, String suffix) {
        return prefix + "━━".repeat(maxItemLen) + suffix;
    }

    private String createLine(String prefix, String suffix, String content) {
        int preSpace = (maxItemLen - content.length()) / 2;
        int sufSpace = maxItemLen - preSpace - content.length();
        return prefix + " ".repeat(preSpace) + content + " ".repeat(sufSpace) + suffix;
    }

    private String convertLine(String line) {
        line = HalfToFull.convert(line);
        return line.replace(" ", "\u3000");
    }

    private void getMaxItemLen() {
        maxItemLen = Math.max(title.length(), bar.length());
        for (String item : itemList) {
            if (item.length() > maxItemLen) {
                maxItemLen = item.length();
            }
        }
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
}