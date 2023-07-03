import static asc.path.cfgGamePath;
import static menu.menu.prtMainMenu;
import static utils.meko.readSet;
import static utils.meko.waitInput;

public class Main {

    public static void main(String[] args) {
        String eMode = readSet("eMode");
        if (eMode.equals("")||eMode.equals("0")) cfgGamePath();
        else prtMainMenu();

        waitInput("exit");
        

//        System.out.println();
//        System.out.println("ReadAndPrintFile6 : ");
//        System.out.println();
//        ReadAndPrintFile6.main(args);
//
//        System.out.println();
//        System.out.println("ReadAndPrintFile7 : ");
//        System.out.println();
//        ReadAndPrintFile7.main(args);

//        testBackslash.main(args);

    }

}
