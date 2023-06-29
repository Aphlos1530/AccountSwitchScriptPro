package menu;

import static utils.meko.echo;
import static utils.meko.readVar;

public class main {

    public static void prtMainMenu() {
        echo("");
        echo("* * * * * * * * * * * * * * * *");
        echo(getGameLine());
        echo("* * * * * * * * * * * * * * * *");
        echo("*                             *");
        echo("*          Main menu          *");
        echo("*                             *");
        echo("*    1. Switch account        *");
        echo("*                             *");
        echo("*    2. Account management    *");
        echo("*                             *");
        echo("*    3. Setting               *");
        echo("*                             *");
        echo("*    4. Fix errors            *");
        echo("*                             *");
        echo(getStartLine());
        echo("*                             *");
        echo("*    6. Help                  *");
        echo("*                             *");
        echo("*    -1. Exit                 *");
        echo("*                             *");
        echo("* * * * * * * * * * * * * * * *");

    }

    private static String getGameLine() {
        String eMode = readVar("eMode");
        return switch (eMode) {
            case "1" -> "*       Genshin Impact        *";
            case "2" -> "*          Star Rail          *";
            case "3" -> "*       Honkai Impact 4       *";
            case ""  -> "*          No games           *";
            default  -> "*        Unknown game         *";
        };
    }

    private static String getStartLine() {
        String sMode = readVar("sMode");
        return switch (sMode) {
            case "1" -> "*    5. Start launcher        *";
            case "2" -> "*    5. Start game            *";
            default  -> "*    5. Start                 *";
        };
    }


}
