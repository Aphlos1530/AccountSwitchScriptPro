
import static asc.path.cfgGamePath;
import static menu.main.prtMainMenu;
import static menu.menu.mainMenu;
import static utils.meko.readVar;

public class Main {

    public static void main(String[] args) {
        String eMode = readVar("eMode");
        if (eMode.equals("")) cfgGamePath();
        else prtMainMenu();
    }

}
