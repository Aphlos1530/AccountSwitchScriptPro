package test;

import auto.WindowsShortcut;
import auto.fileSearch;
import org.junit.Test;
import utils.*;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

import static menu.menu.prtMainMenu;
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
    public void testDq() {
        //testDq5.main();
    }

    @Test
    public void testMekoBuilder() {
        mekoBuilder builder = new mekoBuilder("#、┏、┳、┓、┗、┻、┛、┣、╋、┫、@、━、┃");
        builder.replace("#", " ");
        builder.replace("@", "·");
        builder.replace("、", "");
        System.out.println(builder);
    }

    @Test
    public void testMekoBuilder2() {
        mekoBuilder builder = new mekoBuilder("1234567890");
        System.out.println(builder.getString(3, 5));
        System.out.println(builder.getString(2, 9));
        System.out.println(builder.getString(0, 6));
        System.out.println(builder.getString(0, -1));
        System.out.println(builder.getString(-1, 5));
        System.out.println(builder.getString(8, 4));
    }

    @Test
    public void testMekoBuilder3() {
        mekoBuilder builder = new mekoBuilder("123456789");
        System.out.println(builder);
        System.out.println(builder.getStringEnhance(3, 5));
        System.out.println(builder.getStringEnhance(2, 9));
        System.out.println(builder.getStringEnhance(0, 6));
        System.out.println(builder.getStringEnhance(0, -1));
        System.out.println(builder.getStringEnhance(-1, 5));
        System.out.println(builder.getStringEnhance(8, 4));
        System.out.println(builder.getStringEnhance(-2, -3));
        System.out.println(builder.getStringEnhance(-6, -5));
        System.out.println(builder.getStringEnhance(-2, 1));
        System.out.println(builder.getStringEnhance(2, -1));
    }


    @Test
    public void testPrtMainMenu() {
        int length = 1024;

        timePiece.set();
        prtMainMenu();
        String first = timePiece.get();

        timePiece.set();
        for (int i = 0; i < length - 1; i++) {
            prtMainMenu();
        }
        String later = timePiece.get();

        System.out.println("\n 打印菜单：" + length + "次");
        System.out.println("\n 初次耗时：" + first + "秒");
        System.out.println("\n 后续耗时：" + later + "秒");

        double avg = Double.parseDouble(later) / length;
        DecimalFormat df = new DecimalFormat("#.######");
        System.out.println("\n 后均耗时：" + df.format(avg) + "秒/次");
    }

    @Test
    public void testBackslash() {
        System.out.print("Hello\r");
        System.out.print("World");
        System.out.println();
        System.out.println("123456\r789");
        System.out.println("abc\r12345");
    }

    @Test
    public void testBackslash2() {
        echo("Hello\r");
        echo("World");
        echo("");
        echo("123456\r789");
        echo("abc\r12345");
    }

    @Test
    public void testBackslash3() {
        System.out.println("Hello\r");
        System.out.print("World");
        System.out.println("-");
        System.out.print("Hello\r");
        System.out.println("World");
    }

    @Test
    public void testBackslash4() {
        System.out.print("Hello\r\nWorld");
    }

    @Test
    public void testBackslash5() {
        System.out.print("Hello\r\r\nWorld");
    }


    @Test
    public void testBackslash6() {
        System.out.print("Hello\r\r\r\nWorld");
    }

    @Test
    public void testWindowsShortcut() {
        File file = new File("D:\\Eval\\Desktop\\原神.lnk");
        WindowsShortcut windowsShortcut;
        try {
            windowsShortcut = new WindowsShortcut(file);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        String filename = windowsShortcut.getRealFilename();
        System.out.println(filename);
    }

    @Test
    public void testMekoBeginEnd1() {
        mekoBeginEnd beginEnd = new mekoBeginEnd();
        beginEnd.limit(-2, 3);

        beginEnd.set(0, 3);
        System.out.println(beginEnd.getBegin());
        System.out.println(beginEnd.getEnd());

        System.out.println();
        beginEnd.set(-8, -5);
        System.out.println(beginEnd.getBegin());
        System.out.println(beginEnd.getEnd());

        System.out.println();
        beginEnd.set(-6, 1);
        System.out.println(beginEnd.getBegin());
        System.out.println(beginEnd.getEnd());
    }

    @Test
    public void testMekoBeginEnd2() {
        mekoBeginEnd beginEnd = new mekoBeginEnd();
        beginEnd.limit(-2, 3);

        beginEnd.set(-8, -3);
        System.out.println(beginEnd.getBegin());
        System.out.println(beginEnd.getEnd());

        System.out.println();
        beginEnd.set(-9, 2);
        System.out.println(beginEnd.getBegin());
        System.out.println(beginEnd.getEnd());

        System.out.println();
        beginEnd.set(4, -7);
        System.out.println(beginEnd.getBegin());
        System.out.println(beginEnd.getEnd());
    }

    @Test
    public void testMekoBeginEnd3() {
        mekoBeginEnd beginEnd = new mekoBeginEnd();
        beginEnd.limit(-8, -3);

        beginEnd.set(16, 15);
        System.out.println(beginEnd.getBegin());
        System.out.println(beginEnd.getEnd());

        System.out.println();
        beginEnd.set(-9, 2);
        System.out.println(beginEnd.getBegin());
        System.out.println(beginEnd.getEnd());

        System.out.println();
        beginEnd.set(4, -7);
        System.out.println(beginEnd.getBegin());
        System.out.println(beginEnd.getEnd());
    }


    @Test
    public void testMekoBeginEnd() {
        testMekoBeginEnd1();
        System.out.println("----");
        testMekoBeginEnd2();
        System.out.println("----");
        testMekoBeginEnd3();
    }

    @Test
    public void testMod1() {
        System.out.println(-15 % 6);
        System.out.println(-9 % 6);
        System.out.println(-3 % 6);
        System.out.println(3 % 6);
        System.out.println(9 % 6);
        System.out.println(15 % 6);
        System.out.println(21 % 6);
    }

    @Test
    public void testMod2() {
        System.out.println(-20 % 6);
        System.out.println(-14 % 6);
        System.out.println(-8 % 6);
        System.out.println(-2 % 6);
        System.out.println(4 % 6);
        System.out.println(10 % 6);
        System.out.println(16 % 6);
    }

    @Test
    public void testMod3() {
        System.out.println((-14 - 2) % 6 + 2);
        System.out.println((-13 - 2) % 6 + 2);
        System.out.println((-12 - 2) % 6 + 2);
        System.out.println((-11 - 2) % 6 + 2);
        System.out.println("------------");
        System.out.println(-14 % 6);
        System.out.println(-13 % 6);
        System.out.println(-12 % 6);
        System.out.println(-11 % 6);
        System.out.println("LEFT = " + (-2 % 6));
        System.out.println();
        System.out.println("RIGHT = " + (3 % 6));
        System.out.println(10 % 6);
        System.out.println(11 % 6);
        System.out.println(12 % 6);
        System.out.println(13 % 6);
        System.out.println("------------");
        System.out.println((10 + 3) % 6 - 3);
        System.out.println((11 + 3) % 6 - 3);
        System.out.println((12 + 3) % 6 - 3);
        System.out.println((13 + 3) % 6 - 3);
    }

//    @Test
//    public void testMekoBeginEnd5() {
//        System.out.println((-7 - 2) % 6 + 2);
//        System.out.println((5 - 2) % 6 + 2);
//        System.out.println((-7 - 2) % 6 + 2);
//        System.out.println((4 - 2) % 6 + 2);
//        System.out.println("------------");
//        System.out.println("LEFT = " + (-2 % 6));
//        System.out.println();
//        System.out.println("RIGHT = " + (3 % 6));
//        System.out.println("------------");
//        System.out.println((8 + 3) % 6 - 3);
//        System.out.println((2 + 3) % 6 - 3);
//        System.out.println((-13 + 3) % 6 - 3);
//        System.out.println((-3 + 3) % 6 - 3);
//    }


    @Test
    public void testMekoBeginEnd6() {
        mekoBeginEnd meb = new mekoBeginEnd(24, 25, 1225);
        System.out.println(meb.getBegin());
        System.out.println(meb.getEnd());
    }

    @Test
    public void testMekoInterval() {
        mekoInterval mei = new mekoInterval();
        mei.setOuter(-2, 3);

        mei.setInner(-7, 8);
        mei.transform();
        System.out.println(mei.getInnerLeft());
        System.out.println(mei.getInnerRight());

        System.out.println();
        mei.setInner(5, 2);
        mei.transform();
        System.out.println(mei.getInnerLeft());
        System.out.println(mei.getInnerRight());

        System.out.println();
        mei.setInner(-7, -13);
        mei.transform();
        System.out.println(mei.getInnerLeft());
        System.out.println(mei.getInnerRight());

        System.out.println();
        mei.setInner(4, -3);
        mei.transform();
        System.out.println(mei.getInnerLeft());
        System.out.println(mei.getInnerRight());
    }

    @Test
    public void testMekoInterval2() {
        mekoInterval meir = new mekoInterval();
        meir.setInner(24,25);
        meir.setOuter(0,1225);
        meir.transform();
        System.out.println(meir.getInnerLeft());
        System.out.println(meir.getInnerRight());
    }

}
