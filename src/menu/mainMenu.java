package menu;

//import utils.MekoMenu2;
import utils.mekoMenu;

import static utils.meko.echo;
import static utils.meko.readVar;

public class mainMenu implements imenu {

    public static void print() {


        echo("");

        mekoMenu menu = new mekoMenu();
//        MekoMenu2 menu = new MekoMenu2();

        menu.set("Main menu");
        menu.put("1. Switch account");
        menu.put("2. Account management");
        menu.put("3. Setting ");
        menu.put("4. Fix errors");
        menu.put("5. "+getStartItem());
        menu.put("6. Help");
        menu.put("-1. Exit");
        menu.print();



    }



    private static String getStartItem() {
        String sMode = readVar("sMode");
        return switch (sMode) {
            case "1" -> "Start launcher";
            case "2" -> "Start game";
            default  -> "Start";
        };
    }


}
