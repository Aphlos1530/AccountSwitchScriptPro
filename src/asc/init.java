package asc;

import static utils.meko.echo;
import static utils.meko.getInput;

public class init implements menu{

    /**
     *
     *
     * 1.检查游戏路径是否配置
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * @param args
     */

    @Override
    public void menu(String... args) {

        System.out.println("* * * * * * * * * * * * * * * *");
        System.out.println("*          No games           *");
        System.out.println("* * * * * * * * * * * * * * * *");

    }

    public static void co() {
        echo("");
        echo("No game detected. Please configure the game path . ");
        echo("");
        echo("1. Auto search        2. Manual input");
        String input = getInput();
        echo("input = "+input);
    }

    public static void main(String[] args) {

    }

}
