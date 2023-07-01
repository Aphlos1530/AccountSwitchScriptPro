package asc;

import auto.fileSearch;
import utils.mekoPath;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utils.meko.*;

public class path {

    public static void cfgGamePath() {
        echo("");
        echo("No game detected. Please configure the game path. ");
        echo("");
        echo("1. Auto search    2.Manual search    3. Manual input");
        disPot("");
    }

    private static void disPot(String text) {
        switch (getInput(text)) {
            case "1" -> searchPath(1);
            case "2" -> searchPath(2);
            case "3" -> inputPath();
            case "" -> waitInput(-1);
            default -> disPot("Input error, please input again : ");
        }
    }

    private static void searchPath(Integer mode) {


        String fileName = "launcher.exe";

        switch (mode){
            case 1 -> {
                overSearch(fileName,4);


            }
            case 2 -> {
                manualSearch(fileName,5);

            }
        }

    }

    private static void overSearch(String fileName, Integer depth) {

            echo("");
            echo("Begin searching ... Please wait patiently.");

        List<String> list = fileSearch.overSearch(fileName, depth);

        Integer count = 0;
        for (String path : list) {

            if (checkPath(path)){
                count++;
                echo("");

                echo(count+". "+path);
            }else {
                list.remove(path);
            }

        }

        // 未找到
        if (list.size()==0){
            System.out.println("未找到");
            return;
        }

//        else{
//            //下一步
//        }

        // 选择路径
        //System.out.println("请选择.");
        selectPath(list);

    }


    private static void overSearch() {

    }

    private static void selectPath(List<String> list) {

        System.out.println("正在选择路径");

        //死循环

        //用户取消配置


        //进行配置路径
        cfgPath();
    }



    private static Integer found = 0;



    private static void manualSearch(String fileName, Integer depth) {

        found=0;

        echo("");
            //echo("In the next steps, you need to enter [\\] or [、] to confirm, [`] or [·] to quit , and else to continue.");

//            echo("In the next steps, you need to enter [、] to confirm, [·] to quit , and else to continue.");


//            echo("In the next steps, you need to enter : ");
//            echo("");
//            echo("");
//            echo("[\\] or [、] to confirm path");
//
//
//            echo("");
//            echo(" [`] or [·] to quit search");
//
//
//            echo("");
//            //echo("else to continue search");
//
//            echo("[Enter] to continue search");



//            echo("");
//        echo("In the next steps, you need to enter [Y] to confirm, [Q] to quit , and else to continue.");


        echo("In the next steps, you need to enter [Y] to confirm, [Q] to quit, and [Else] to continue.");

//        echo("In the next steps, you need to enter [Y] to confirm, [Q] to quit, and [] to continue.");
//




        echo("");
//        echo("Begin searching ... Please wait patiently.");
        echo("Begin searching ... ");






        String path = fileSearch.reSearch(fileName, depth);

//        echo("");
        Byte state = circleSearch(path);

        Boolean notFound = true;

        if (state==0){
            //
            System.out.println("未找到");
        }else if (state==1){
            //用户退出
        }else if (state==2){
            //正常配置
        }

    }


    private static final List<String> exitChars = Arrays.asList("`", "·", "q", "Q", "quit", "Quit", "QUIT", "e", "E", "exit", "Exit", "EXIT");

    private static final List<String> confirmChars = Arrays.asList("\\", "、", "y", "Y", "yes", "Yes", "YES", "c", "C", "confirm", "Confirm", "CONFIRM");



    private static Byte circleSearch(String path) {
        // goto
        if (checkPathTest(path)) {

//            echo("\r\r\r\r\r\r");

//            System.out.print("\r\r\r\r");
//            System.out.print("\r");//ok

//            echo("123\n456\n789");
//
//            System.out.println("123456\r789");

//            echo("\r\r\r\r");
            echo("\r");

//            echo("12345\r123");


            found++;
//            echo("");
//            echo("");
//            echo(path);


            echo(found+". "+path);


//            echo("\r\r"+found+". "+path);

            echo("");
            echo("Please enter your choice : ");


            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            //String input = scanner.next();


//            switch (input) {
//                case "`", "·" -> {
//                    return;
//                }
//                case "\\", "、" -> cfgPath();
//                default -> {
//                    fileSearch.conSearch();
//                    manualSearch();
//
//                    //缺少：
//                    // 搜索结束
//                }
//            }

//            if (input.equals("`")||input.equals("·")){
//                return;
//            }
//            if (input.equals("`")||input.equals("·")){
//                return;
//            }


            if (exitChars.contains(input)) {
                return 1;
            } else if (confirmChars.contains(input)) {
                cfgPath();
                return 2;
            }else {

//                echo("\r");
                echo("");
                echo("Searching ... ");


            }




//            else {
//
//
//                path = fileSearch.conSearch();//继续找
//                if (!path.equals("")){
//                    // 找到，送检
//                    circleSearch(path);
//
//                }else {
//                    //找不到，返回
//                    return 0;
//                }
//
//
//
//            }
//            path = fileSearch.conSearch();
//            circleSearch(path);


//        } else {
//            //路径检查不通过
////            path = fileSearch.conSearch();
////            circleSearch(path);
//
//
//        path = fileSearch.conSearch();//继续找
//            if (!path.equals("")){
//                // 找到，送检
//                circleSearch(path);
//
//            }else {
//                //找不到，返回
//                return 0;
//            }
//
//        }

//        else {
//            path = fileSearch.conSearch();
//            circleSearch(path);
//        }


//        path = fileSearch.conSearch();
//        circleSearch(path);

//        if (!fileSearch.conSearch().equals("")){
//
//            circleSearch(path);
//
//        }


        }


        //System.out.println();

        //System.out.print("\033[2K\r");

//        System.out.print("\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r");

//        System.out.print("\033[1A\r" + "新的内容");

//        System.out.print("\033[2J\033[H" + "新的内容");

        //ConsoleUtils.backLine();

//        ConsoleUtils.backLine();
//        ConsoleUtils.backLine();
//        ConsoleUtils.backLine();

//        ConsoleUtils.clear();


//        ConsoleUtils.clearLine(3);

                path = fileSearch.conSearch();//继续找
                if (!path.equals("")){

//                    echo("123456789\r");
//                    System.out.println("123456789\r");
//                    System.out.print("12345678\r");

//                    System.out.print("\r");
//                    System.out.println("\r");



                    // 找到，送检
                    circleSearch(path);



                }

//                else {
//                    //找不到，返回
//                    return 0;
//                }





        return 0;
    }

//    private static void manualSearch() {
//        //y确定q退出 其它继续
//        // 顿号、反斜杠确定  回车继续  其它退出
//        // 顿号、反斜杠 确定  反引号、间隔号 退出  其它继续
//
//
////        echo("");
////        echo("Please enter your choice ： ");
//
//        switch (input("Please enter your choice :")) {
//            case "`", "·" -> {return;}
//            case "\\","、" -> cfgPath();
//            default  -> {
//                fileSearch.conSearch();
//                manualSearch();
//
//                //缺少：
//                // 搜索结束
//            }
//        }
//
//        // 有BUg待改进
//        //echo("");
//        //System.out.println("No found !");
//    }











    private static void searchPath() {
        System.out.println("ssssssssssss");

        System.out.println("No found !");
    }


//    private static void searchPath(Integer mode) {
//        if (mode.equals(1)){
//            echo("");
//            echo("Begin searching ... Please wait patiently.");
//            echo("");
//            //auto.fileSearch3.overSearch("YuanShen.exe");
//            auto.fileSearch3.overSearch("launcher.exe");
//        }
//        if (mode.equals(2)) {
//
//            echo("");
//            //echo("In the next steps, you need to enter [\\] or [、] to confirm, [`] or [·] to quit , and else to continue.");
//
////            echo("In the next steps, you need to enter [、] to confirm, [·] to quit , and else to continue.");
//
//
//            echo("In the next steps, you need to enter :");
//            echo("");
//            echo("");
//            echo("[\\] or [、] to confirm path");
//
//
//            echo("");
//            echo(" [`] or [·] to quit search");
//
//
//            echo("");
//            //echo("else to continue search");
//
//            echo("[Enter] to continue search");
//
//
//
//
//            echo("");
//            echo("Be searching ...");
//            echo("");
//            auto.fileSearch3.reSearch("YuanShen.exe");
//
//            manualSearch();
//        }
//    }


    private static void inputPath() {
        //System.out.println("iiiiiiiiiii");

        testClear2();
        testClear2();

    }

    public static void testClear() {
//        ConsoleUtils.print("Hello, world!");
//        ConsoleUtils.backLine();
//        ConsoleUtils.print("This is a test.");
//        ConsoleUtils.clear();
    }

    public static void testClear2() {

        //ConsoleCLS.main();
        String[] strings = {""};
//        clear4.main(strings);

    }


    private static Boolean checkPath(String path){
        String fileName = mekoPath.destFile(path);
        String keyPath = "";
        if (fileName.equals("YuanShen.exe")) {
            String gamePath = mekoPath.lastPath(path);
            if (!gamePath.equals("Genshin Impact Game")) return false;
            keyPath = mekoPath.lastPath(path,2) + "\\launcher.exe";
        }
        if (fileName.equals("launcher.exe")) {
            keyPath = mekoPath.lastPath(path) + "\\Genshin Impact Game\\YuanShen.exe";
        }
        File exFile = new File(keyPath);
        return exFile.exists();
    }


    private static Boolean checkPathTest(String path){
        return true;
    }


    private static void cfgPath() {
        System.out.println();
        //System.out.println("ccccccccccccccc");
        System.out.println("Path configured.");
    }


}
