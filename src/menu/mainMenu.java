package menu;

//import utils.MekoMenu2;
import utils.mekoMenu;

import static utils.meko.*;

public class mainMenu implements imenu {

    private static final mekoMenu menu = new mekoMenu();  //通过 new 静态对象的方式实现 短名称 调用

    private static void init() {
        menu.set("Main menu");
        menu.put("1. Switch account");
        menu.put("2. Account management");
        menu.put("3. Setting ");
        menu.put("4. Fix errors");
        menu.put("5. "+getStartItem());
        menu.put("6. Help");
        menu.put("-1. Exit");
    }

    private static String getStartItem() {
        String sMode = readSet("sMode");
        return switch (sMode) {
            case "1" -> "Start launcher";
            case "2" -> "Start game";
            default  -> "Start";
        };
    }

    public static void print() {
        if (menu.isEmpty()) init();  //惰式初始化
        echo("");
        menu.print();
    }


}
