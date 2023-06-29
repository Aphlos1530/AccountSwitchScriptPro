package test;

import auto.fileSearch;
//import test.Console.ConsoleUtils;
import utils.*;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static java.lang.Thread.sleep;
import static utils.meko.echo;


public class test {


    @Test
    public void testChinese() {
        echo("");
        echo("No game detected. Please configure the game path : ");
        echo("");
        echo("Please enter options and press enter : ");
    }

    @Test
    public void testTextCode() {
        echo("");
        echo(1001);
        echo("");
        echo(1002);
    }

    @Test
    public void showMaps() {
        printMap.co(readInMap.NO_TO_EN_MAP);
        printMap.co(readInMap.NO_TO_CH_MAP);
        printMap.co(readInMap.NO_TO_JP_MAP);
    }

    @Test
    public void testVar() {
        String eMode = variable.read("eMode");
        System.out.println("eMode=" + eMode);
        if (eMode.equals("1")) variable.write("eMode", "2");
        if (eMode.equals("2")) variable.write("eMode", "1");
        eMode = variable.read("eMode");
        System.out.println("eMode=" + eMode);
    }

    @Test
    public void testJavaFile() {
        File file = new File("");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
    }

    @Test
    public void testPathDest() {
        String path = "G:\\Program Files\\Genshin Impact\\Genshin Impact Game\\YuanShen.exe";
        System.out.println(mekoPath.lastPath(path));
        System.out.println("--------------------------------");
        System.out.println(mekoPath.lastPath(path, 0));
        System.out.println(mekoPath.lastPath(path, 1));
        System.out.println(mekoPath.lastPath(path, 2));
        System.out.println("--------------------------------");
        System.out.println(mekoPath.lastPath(path, 10));
        System.out.println("--------------------------------");
    }

    @Test
    public void testPathDest2() {
        String path = "G:\\Program Files\\Genshin Impact\\Genshin Impact Game\\YuanShen.exe";
        System.out.println(mekoPath.destFile(path));
    }

    @Test
    public void testTimePiece() {
        timePiece.set();
        int count = 0;
        for (int i = 0; i < 255; i++) {
            for (int j = 0; j < 255; j++) {
                for (int k = 0; k < 255; k++) {
                    count++;
                }
            }
        }
        System.out.println("计数：" + count);
        System.out.println("耗时：" + timePiece.get() + "秒");
    }

    @Test
    public void testTimePieceMulti() {
        timePieceMulti.set();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < 16; i++) {
            timePieceMulti.set("inner");
            for (int j = 0; j < 256 * 256 * 256; j++) {
                count++;
                sum += count;
            }
            System.out.println("第" + i + "圈耗时：" + timePieceMulti.get("inner") + "秒");
        }
        System.out.println();
        System.out.println("计数：" + count);
        System.out.println("求和：" + sum);
        System.out.println("耗时：" + timePieceMulti.get() + "秒");
    }

    @Test
    public void testPathDest3() {
//        String path = "G:\\Program Files\\Genshin Impact\\Genshin Impact Game\\YuanShen.exe";
//        timePiece.set();
//        System.out.println(mekoPath.destFile(path));
//        System.out.println("方法一耗时：" + timePiece.get() + "秒");
//        timePiece.set();
//        System.out.println(mekoPath.destFile2(path));
//        System.out.println("方法二耗时：" + timePiece.get() + "秒");
//        timePiece.set();
//        System.out.println(mekoPath.destFile3(path));
//        System.out.println("方法三耗时：" + timePiece.get() + "秒");
    }

    @Test
    public void testPathDest4() {
//        String path = "G:\\Program Files\\Genshin Impact\\Genshin Impact Game\\YuanShen.exe";
//        timePiece.set();
//        for (int i = 0; i < 255; i++) {
//            for (int j = 0; j < 25500; j++) {
//                mekoPath.destFile(path);
//            }
//        }
//        System.out.println("方法一耗时：" + timePiece.get() + "秒");
//        timePiece.set();
//        for (int i = 0; i < 255; i++) {
//            for (int j = 0; j < 25500; j++) {
//                mekoPath.destFile2(path);
//            }
//        }
//        System.out.println("方法二耗时：" + timePiece.get() + "秒");
//        timePiece.set();
//        for (int i = 0; i < 255; i++) {
//            for (int j = 0; j < 25500; j++) {
//                mekoPath.destFile3(path);
//            }
//        }
//        System.out.println("方法三耗时：" + timePiece.get() + "秒");
//        timePiece.set();
//        for (int i = 0; i < 255; i++) {
//            for (int j = 0; j < 25500; j++) {
//                mekoPath.destFile4(path);
//            }
//        }
//        System.out.println("方法四耗时：" + timePiece.get() + "秒");
    }

    @Test
    public void testFileSearch() {
        timePiece.set();
        int count = 0;
        String search = fileSearch.reSearch();
        while (!search.equals("")) {
            count++;
            System.out.println(count + ". " + search);
            search = fileSearch.conSearch();
        }
        System.out.println();
        System.out.println("找到路径：" + count + "个");
        System.out.println("全程耗时：" + timePiece.get() + "秒");
    }

    @Test
    public void testFileSearch2() {
        timePiece.set();
        List<String> list = fileSearch.overSearch();
        int count = 0;
        for (String search : list) {
            count++;
            System.out.println(count + ". " + search);
        }
        System.out.println();
        System.out.println("找到路径：" + count + "个");
        System.out.println("全程耗时：" + timePiece.get() + "秒");
    }

    @Test
    public void testTemp() {
        System.out.println();
        testFileSearch();
        System.out.println();
        testFileSearch2();
    }

    @Test
    public void testConsole() throws InterruptedException {

    }

    @Test
    public void testToFull() {
        String text = "Hello, World! 你好，世界！";
        System.out.println(text);
        String convertedText = halfToFull.convert(text);
        System.out.println(convertedText);
    }

    @Test
    public void testDq(){
        //testDq5.main();
    }

    @Test
    public void testMekoBuilder(){
        mekoBuilder builder = new mekoBuilder("#、┏、┳、┓、┗、┻、┛、┣、╋、┫、@、━、┃");
        builder.replace("#"," ");
        builder.replace("@", "·");
        builder.replace("、", "");
        System.out.println(builder);
    }

    @Test
    public void testMekoBuilder2(){
        mekoBuilder builder = new mekoBuilder("1234567890");
        System.out.println(builder.getString(3,5));
        System.out.println(builder.getString(2,9));
        System.out.println(builder.getString(0,6));
        System.out.println(builder.getString(0,-1));
        System.out.println(builder.getString(-1,5));
        System.out.println(builder.getString(8,4));
    }

    @Test
    public void testMekoBuilder3(){
        mekoBuilder builder = new mekoBuilder("123456789");
        System.out.println(builder);
        System.out.println(builder.getStringEnhance(3,5));
        System.out.println(builder.getStringEnhance(2,9));
        System.out.println(builder.getStringEnhance(0,6));
        System.out.println(builder.getStringEnhance(0,-1));
        System.out.println(builder.getStringEnhance(-1,5));
        System.out.println(builder.getStringEnhance(8,4));
        System.out.println(builder.getStringEnhance(-2,-3));
        System.out.println(builder.getStringEnhance(-6,-5));
        System.out.println(builder.getStringEnhance(-2,1));
        System.out.println(builder.getStringEnhance(2,-1));
    }

}
