package utils;

import java.util.Arrays;
import java.util.List;

import static utils.meko.readSet;

public class tabChars {

    private static char[] tabs;

    static {
        setTabStyle();
        setTabsByGraph();
    }

    public static char[] getTabs(){
        return tabs;
    }

    private static String tabStyle = "thick";

    public static void setTabStyle() {
        List<String> styles = Arrays.asList("thick", "thin", "double", "dot", "angle", "star");
        String style = readSet("tabStyle");
        if (styles.contains(style)) tabStyle = style;
    }

    private static void setTabsByGraph() {
        mekoBuilder builder = new mekoBuilder();
        switch (tabStyle) {
            case "thick"  ->  builder.set("#、┏、┳、┓、┣、╋、┫、┗、┻、┛、@、━、┃");
            case "thin"   ->  builder.set("#、┌、┬、┐、├、┼、┤、└、┴、┘、@、─、│");
            case "double" ->  builder.set("#、╔、╦、╗、╠、╬、╣、╚、╩、╝、@、═、║");
            case "angle"  ->  builder.set("#、╭、┬、╮、├、┼、┤、╰、┴、╯、@、─、│");
        }
        builder.replace("#", " ");
        builder.replace("@", "·");
        builder.replace("、", "");
        tabs = builder.toCharArray();
    }


}
