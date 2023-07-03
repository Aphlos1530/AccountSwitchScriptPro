package asc;

import auto.WindowsShortcut;
import auto.fileSearch;
import utils.timePiece;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import static utils.meko.*;
import static utils.mekoPath.lastPath;

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

        switch (mode) {
            case 1 -> {
                overSearch(fileName, 4);


            }
            case 2 -> {
                manualSearch(fileName, 5);

            }
        }

    }


    //自动搜索


    private static void overSearch(String fileName, Integer depth) {

        //清空缓存

        foundCount = 0;
        foundPath.clear();

        //打印提示信息

        echo("");
        echo("Begin searching, please wait patiently ...");

        //开始搜索

        timePiece.set();  //加入时间统计

        List<String> list = fileSearch.overSearch(fileName, depth);

        String consume = timePiece.get();

        //未找到路径
        if (list.size() == 0) {
            prtNotFoundMsg();
            return;
        }

        //路径过滤

        for (String path : list) {
            if (checkPath(path)) {
                //检查通过，存入并打印
                foundCount++;
                foundPath.put(String.valueOf(foundCount), path);  //存入伪 List 中

                echo("\r");  //清空正在搜索字样
                echo("[" + foundCount + "] " + path);  //新样式
                //echo(foundCount + ". " + path);  //旧样式
            }
        }

        //信息统计

        echo("");
        echo("Found : " + foundCount + "\t" + "Consume : " + consume + " S");  //待翻译

        //等待用户输入

        echo("");
        echo("Please enter your choice : ");

        //输入循环

        String input;
        while (true) {

            input = input();

            //直接回车
            if (input.equals("")) {
                echo("");
                echo("Input empty, operation canceled.");
                break;
            }

            //选择路径
            currentPath = foundPath.get(input);
            if (currentPath == null) {
                echo("");
                echo("Input error, please re-enter : ");
            } else {
                //进行配置
                cfgPath();
                break;
            }

        }

    }


    //手动搜索


    private static final Map<String, String> foundPath = new HashMap<>();  //找到的路径（为避免字符与整数的转换，这里以 Map 代替 List ）

    private static Integer foundCount = 0;  //找到的路径数目（可用 foundPath.size() 代替）

    private static String currentPath = "";  //当前搜索出来的路径

    /**
     * 手动搜索
     */
    private static void manualSearch(String fileName, Integer depth) {

        //清空缓存

        foundCount = 0;
        foundPath.clear();

        //打印提示信息

        echo("");
        echo("In the next steps, you need to enter [Y] to confirm, [Q] to quit, and [Else] to continue.");

        //开始搜索

        echo("");
        echo("Begin searching ...");

        currentPath = fileSearch.reSearch(fileName, depth);

        //进入循环搜索

        boolean found = circleSearch();
        if (found) cfgPath();  //循环结束后再配置路径，避免嵌套过深

    }

    //确认与退出

    private static final List<String> exitChars = Arrays.asList("`", "·", "q", "Q", "quit", "Quit", "QUIT", "e", "E", "exit", "Exit", "EXIT");

    private static final List<String> confirmChars = Arrays.asList("\\", "、", "y", "Y", "yes", "Yes", "YES", "c", "C", "confirm", "Confirm", "CONFIRM");

    /**
     * 循环搜索
     */
    private static boolean circleSearch() {

        //未找到路径

        if (currentPath.equals("")) {
            prtNotFoundMsg();
            return false;
        }

        if (checkPath()) {

            //检查通过，存入并打印

            foundCount++;
            foundPath.put(String.valueOf(foundCount), currentPath);  //存入伪 List 中

            echo("\r");  //清空正在搜索字样
            echo("[" + foundCount + "] " + currentPath);  //新样式
            //echo(foundCount + ". " + currentPath);  //旧样式

            //等待用户输入

            echo("");
            echo("Please enter your choice : ");

            String input = input();

            //用户退出搜索

            if (exitChars.contains(input)) {
                prtNotFoundMsg();
                return false;
            }

            //用户确认

            if (confirmChars.contains(input)) {
                return true;  //循环结束后再配置路径，避免嵌套过深
            }

            //尝试从之匹配前的路径（使用 StrMap 进行查找，无需判断数字是否在合理的范围内）

            String selectPath = foundPath.get(input);
            if (selectPath != null) {
                currentPath = selectPath;  //设置成用户选定的路径
                return true;  //循环结束后再配置路径，避免嵌套过深
            }

            //进行下一轮循环，提前打印提示信息（没有放到路径检查之外，是为了避免与初次的提示相冲突）

            echo("");
            echo("Being searching ...");

        }

        //路径不符合，继续寻找（此处不可加 else）

        currentPath = fileSearch.conSearch();

        return circleSearch();  //进入循环

    }

    /**
     * 打印提示信息
     */
    private static void prtNotFoundMsg() {

        echo("");
        echo("Unfortunately, no suitable path has been found.");

        echo("");
        echo("Press any key to exit ...");

        input();

    }

    /**
     * 虚假的路径检查
     */
    private static boolean checkPathTest() {
        return true;
    }

    private static boolean checkPathTest(String path) {
        currentPath = path;
        return checkPathTest();
    }

    private static byte eModeTemp = 0;  // 临时的 eMode

    /**
     * 路径检查
     */
    private static Boolean checkPath() {

        //准备工作

        String keyPath = lastPath(currentPath);
        List<String> keyPathList = new ArrayList<>();

        //原神

        keyPathList.add(keyPath + "\\Genshin Impact Game\\YuanShen.exe");
        keyPathList.add(keyPath + "\\Genshin Impact Game\\YuanShen_Data");
        if (keyPathExist(keyPathList)) {
            eModeTemp = 1;
            return true;
        }

        //原神国际服

        keyPathList.clear();
        keyPathList.add(keyPath + "\\Genshin Impact Game\\GenshinImpact.exe");
        keyPathList.add(keyPath + "\\Genshin Impact Game\\GenshinImpact_Data");
        if (keyPathExist(keyPathList)) {
            eModeTemp = 11;
            return true;
        }

        //星铁

        keyPathList.clear();
        keyPathList.add(keyPath + "\\Game\\StarRail.exe");
        keyPathList.add(keyPath + "\\Game\\StarRail_Data");
        if (keyPathExist(keyPathList)) {
            eModeTemp = 2;
            return true;
        }

        //崩坏4

        keyPathList.clear();
        keyPathList.add(keyPath + "\\Games\\HonkaiImpact4.exe");
        keyPathList.add(keyPath + "\\Games\\HonkaiImpact4_Data");
        if (keyPathExist(keyPathList)) {
            eModeTemp = 3;
            return true;
        }

        return false;
    }

    private static boolean checkPath(String path) {
        currentPath = path;
        return checkPath();
    }

    private static boolean keyPathExist(List<String> list) {
        for (String path : list) {
            if (!fileExist(path)) return false;
        }
        return true;
    }

    private static boolean fileExist(String filePath) {
        File exFile = new File(filePath);
        return exFile.exists();
    }

    /**
     * 配置游戏路径
     */
    private static void cfgPath() {

        //clear();

        echo("");
        echo("Selected : ");
        echo(currentPath);

        echo("");
        echo("Being configuring ...");

        sleep(1000);

        String key = "gamePath[" + eModeTemp + "]";
        writeSet(key, currentPath);
        writeSet("eMode", String.valueOf(eModeTemp));


        echo("\r");
        echo("Configured.");

    }


    //用户手动配置


    private static void inputPath() {

        //打印提示信息

        echo("");
        echo("Example 1 : " + "D:\\Program Files\\Genshin Impact");

        echo("");
        echo("Example 2 : " + "\"D:\\Program Files\\Genshin Impact\\Genshin Impact Game\\YuanShen.exe\"");

        echo("");
        echo("Example 3 : " + "\"D:\\Eval\\Desktop\\Genshin Impact.lnk\"");

        echo("");
        echo("Please enter the game path as shown above : ");


        //进入循环

        String input;

        while (true) {
            input = input(); //获取用户输入

            //直接回车
            if (input.equals("")) {
                echo("");
                echo("Input empty, operation canceled.");
                break;
            }

            //检查路径
            currentPath = input;
            if (checkPathInput()) {
                //进行配置
                cfgPath();
                break;
            } else {
                echo("");
                echo("Path not checked through, please re-input : ");
            }

        }

    }

    /**
     * 虚假的输入路径检查
     */
    private static Boolean checkPathInputTest() {
        return true;
    }

    /**
     * 输入路径检查
     */
    private static Boolean checkPathInput() {

        //路径预处理

        currentPath = currentPath.replaceAll("\"", "");  //去除引号
        currentPath = currentPath.replaceAll("/", "\\");  //正杆转反杠
        currentPath = currentPath.replaceAll("\\\\+$", "");
        //System.out.println("currentPath = " + currentPath);

        //进入判断

        File file = new File(currentPath);

        //TIPS : 这路径纠正，简直离谱！强大！！

        if (file.isDirectory()) {

            String launchPath;

            //启动器在当层
            launchPath = currentPath + "\\launcher.exe";
            if (new File(launchPath).exists()) {
                currentPath = launchPath;
                return checkPath();
            }

            //启动器在上层
            launchPath = lastPath(currentPath) + "\\launcher.exe";
            if (new File(launchPath).exists()) {
                currentPath = launchPath;
                return checkPath();
            }

        } else {

            //快捷键方式
            if (currentPath.endsWith(".lnk")) {
                currentPath = getLinkTargetPath(currentPath);
                return checkPath();
            }

            //启动器路径
            if (currentPath.endsWith("launcher.exe")) {
                return checkPath();
            }

            //默认视为游戏程序路径（勿需担心，checkPath 会进行再度检查）

            //currentPath = destPath(currentPath);  //本层文件夹
            //currentPath = lastPath(currentPath);  //上层文件夹
            currentPath = lastPath(currentPath, 2);  //上层文件夹
            currentPath += "\\launcher.exe";  //启动器路径
            return checkPath();

        }
        return false;
    }

    //获取 .lnk 文件的目标路径
    private static String getLinkTargetPath(String linkPath) {
        File file = new File(linkPath);
        WindowsShortcut windowsShortcut;
        try {
            windowsShortcut = new WindowsShortcut(file);
        } catch (IOException | ParseException e) {
            //throw new RuntimeException(e);
            return "";
        }
        return windowsShortcut.getRealFilename();
    }

}
