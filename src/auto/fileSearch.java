package auto;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fileSearch {


    private static int MAX_DEPTH = 10; // 最大搜索深度
    private static List<String> IGNORE_DIRS = Arrays.asList("Windows", "Program Files", "Program Files (x86)"); // 要屏蔽的目录
    private static List<String> PRIORITY_DIRS = List.of("Genshin Impact"); // 优先搜索的目录

    static {
        MAX_DEPTH = 5;
        IGNORE_DIRS = Arrays.asList("ProgramData", "Windows", "Recovery", "Boot", "EFI", "PerfLogs", "Users", "Temp", "WpSystem");
        PRIORITY_DIRS = Arrays.asList("Program Files", "Genshin Impact", "Genshin Impact Game", "YuanShen", "原神", "游戏");


        //fileName = "YuanShen.exe";

        fileName = "launcher.exe";
    }


    private static Integer depth;

    private static Integer index;

    private static String fileName;


    private static final List<List<File>> fileLily = new ArrayList<>();

    private static final List<String> foundPathList = new ArrayList<>();

    private static String foundPath;

//    private static Integer foundCount = 0;


    private static Integer fileCount = 0;

    private static Integer direCount = 0;

    private static Boolean followFlag = false;


    private static Boolean overMode;


    private static Byte searchMode;


//    public static void co() {
//
//        MAX_DEPTH = 5;
//        fileName = "YuanShen.exe";
//
////        MAX_DEPTH = 4;
////        fileName = "launcher.exe";
//
////        MAX_DEPTH = 4;
////        fileName = "StarRail.exe";
//
//        long begin = System.currentTimeMillis(); // 记录程序开始时间
//        try {
//            first();
//        } catch (Exception e) {
//            //throw new RuntimeException(e);
//            //System.out.println(foundPath.get(foundPath.size()-1));
//
//        } finally {
//
//
//            long end = System.currentTimeMillis(); // 记录程序开始时间
//            System.out.println("\n程序总耗时：" + calcSecond(begin, end) + " 秒");
//
//
//            System.out.println();
//            System.out.println("找到路径：" + foundPath.size() + "个");
//            for (int i = 0; i < foundPath.size(); i++) {
//                System.out.println();
//                System.out.println((i + 1) + ". " + foundPath.get(i));
//            }
//
//            System.out.println();
//            System.out.println("遍历文件：" + fileCount + "个，文件夹" + direCount + "个");
//        }
//
//
////        System.out.println();
////        System.out.println("找到路径："+foundPath.size()+"个");
////        for (int i = 0; i < foundPath.size(); i++) {
////            System.out.println();
////            System.out.println((i+1) + ". " + foundPath.get(i));
////        }
////
////        System.out.println();
////        System.out.println("遍历文件："+ fileCount +"个，文件夹"+ direCount +"个");
//    }


    private static void first() throws Exception {

        // 清空缓存数据

        fileCount = 0;

        direCount = 0;


        //Integer depth = 0;

        fileLily.clear();

        foundPathList.clear();





        File[] roots = File.listRoots();  // 盘符


        fileLily.add(List.of(roots));



//        long startTime = System.currentTimeMillis();

//        long endTime = System.currentTimeMillis();

//        for (depth = 1; depth <= MAX_DEPTH; depth++) {
//
//            fileLily.add(new ArrayList<>());
//
////            startTime = System.currentTimeMillis();
//
//            enzyme(fileLily.get(depth - 1));
//
////            endTime = System.currentTimeMillis();
//
////            System.out.println("\n第" + depth + "层耗时：" + calcSecond(startTime, endTime) + " 秒");
//
//        }

        circle();



//        List<File> fileList = fileLily.get(depth - 1);
////        enzyme(fileLily.get(depth - 1),index);
//        enzyme(fileList,index);


    }


//    private static String calcSecond(long startTime, long endTime) {
//        long elapsed = endTime - startTime;
//        DecimalFormat df = new DecimalFormat("#.###");
//        return df.format(elapsed / 1000.0);
//    }


//    private static void enzymolysis(){
//
//    }




    private static void follow() throws Exception {


        foundPath="";

//        followFlag=true;

//        fileCount = 0;
//
//        direCount = 0;


        //Integer depth = 0;

//        File[] roots = File.listRoots();  // 盘符
//
//
//        fileLily.add(List.of(roots));


//        for (depth = 1; depth <= MAX_DEPTH; depth++) {
//
//            //fileLily.add(new ArrayList<>());
//
//            startTime = System.currentTimeMillis();
//
//            enzyme(fileLily.get(depth - 1));
//
//            endTime = System.currentTimeMillis();
//
//            System.out.println("\n第" + depth + "层耗时：" + calcSecond(startTime, endTime) + " 秒");
//
//        }


//        System.out.println("follow-depth = "+depth);//////////////
//        System.out.println("follow-index = "+index);///////////


//        List<File> fileList = fileLily.get(depth - 1);
////        enzyme(fileLily.get(depth - 1),index);
//        enzyme(fileList,index);



//        long startTime = System.currentTimeMillis();

//        long endTime = System.currentTimeMillis();
//
//        for (; depth <= MAX_DEPTH; depth++) {
//
//            fileLily.add(new ArrayList<>());
//
////            startTime = System.currentTimeMillis();
//
//            enzyme(fileLily.get(depth - 1));
//
////            endTime = System.currentTimeMillis();
//
////            System.out.println("\n第" + depth + "层耗时：" + calcSecond(startTime, endTime) + " 秒");
//
//        }


//        circle(depth);

//        circle(depth+1);


//        List<File> fileList = fileLily.get(depth - 1);
//        enzymeNew(fileList);
//
//
//        circleNew();

//        followFlag=false;



                List<File> fileList = fileLily.get(depth - 1);
//        enzyme(fileLily.get(depth - 1),index);
        enzyme(fileList,index+1);
//        depth++;
//        circle();
        circle(depth+1);

    }

//    private static void circleNew() throws Exception {
//
//        if (!followFlag) depth=1;
//
//        while (depth <= MAX_DEPTH) {
//
////            System.out.println("circle-depth = "+depth);////////////
//
//
//            //System.out.println("index = "+index);
//
//            fileLily.add(new ArrayList<>());
//
////            if (!followFlag){
////
////                fileLily.add(new ArrayList<>());
////            }
////
////
//////
//////            if (index==0){
//////
//////            }
////
//////            startTime = System.currentTimeMillis();
////
////            enzyme(fileLily.get(depth - 1));
//
////            endTime = System.currentTimeMillis();
//
////            System.out.println("\n第" + depth + "层耗时：" + calcSecond(startTime, endTime) + " 秒");
//
//
//
////            if (fileLily.get(depth)==null){
////                fileLily.add(new ArrayList<>());
////            }
//
//            enzymeNew(fileLily.get(depth - 1));
//
//            depth++;
//
//        }
//    }


    private static void circle() throws Exception {
        circle(1);
    }

    private static void circle(Integer from) throws Exception {

        for (depth = from; depth <= MAX_DEPTH; depth++) {

//            System.out.println("circle-depth = "+depth);/////////////////


            //System.out.println("index = "+index);


            fileLily.add(new ArrayList<>());
//
//
////
////            if (index==0){
////
////            }
//
////            startTime = System.currentTimeMillis();
//
//            enzyme(fileLily.get(depth - 1));

//            endTime = System.currentTimeMillis();

//            System.out.println("\n第" + depth + "层耗时：" + calcSecond(startTime, endTime) + " 秒");



//            if (fileLily.get(depth)==null){
//                fileLily.add(new ArrayList<>());
//            }

            enzyme(fileLily.get(depth - 1));

        }
    }


//    private static void enzymolysis(){
//


//    public static void main(String[] args) {
//
////        long startTime = System.currentTimeMillis(); // 记录程序开始时间
//
//        co();
//
////        long endTime = System.currentTimeMillis(); // 记录程序结束时间
//
////        long elapsedTime = endTime - startTime; // 计算程序耗时
////        double seconds = (double) elapsedTime /1000;
////        DecimalFormat df = new DecimalFormat("#.###");
////        String result = df.format(seconds);
////        System.out.println();
////        System.out.println("程序总耗时：" + result + " 秒");
////        System.out.println();
//
////        System.out.println("\n程序总耗时：" + calcSecond(startTime,endTime) + " 秒");
//    }


    // 酶解
//    private static void enzymeNew(List<File> list) throws Exception {
//
////        if (!followFlag) index=0;
////        else index++;
//
////        //index=followFlag?(index+1):0;
////
//
//        while (index < list.size()) {
//
//            System.out.println("enzyme-index = "+index);
//            //System.out.println();
//
//            File[] fileArray = list.get(index).listFiles();  //获取子目录
//            if (fileArray != null) {
//                pick(fileArray);
//            }
//
//            index++;
//        }
//
//        System.out.println("第"+depth+"层酶解完成");
//        System.out.println("depth = "+depth);
//        System.out.println("index = "+index);
//    }

    private static void enzyme(List<File> list) throws Exception {
        enzyme(list,0);
    }

    private static void enzyme(List<File> list,Integer from) throws Exception {
        for (index =from ;index < list.size(); index++) {

//            System.out.println("enzyme-index = "+index);/////////////
            //System.out.println();

            File[] fileArray = list.get(index).listFiles();  //获取子目录
            if (fileArray != null) {
                pick(fileArray);
            }
        }

//        System.out.println("第"+depth+"层酶解完成");///////////////
//        System.out.println("depth = "+depth);//////////////
//        System.out.println("index = "+index);///////////////////


    }


    private static void pick(File[] fileArray) throws Exception {
        for (File file : fileArray) {
            if (file.isDirectory()) {
                direCount++;
                if (isIgnoreDir(file)) {
                    continue;  // 跳过
                }
                fileLily.get(depth).add(file);  // 添加该文件夹（用于下一层搜索）
            } else {
                fileCount++;
                if (file.getName().equals(fileName)) {
//                    foundPath.add(file.getAbsolutePath());  // 添加路径
//                    if (searchMode==1) {
//                        // 全部退出
//                        throw new Exception("退出内层函数"); // 抛出异常，直接退到外层函数
//                    }
//                    foundHandle(file);

//                    foundPathList.add(file.getAbsolutePath());  // 添加该路径（已找到文件）


//                    if (searchMode == 0) {
////                        throw new Exception("Exit the inner function."); // 抛出异常，直接退到外层函数
//
//
////                        System.out.println("0000000000000");
//                        foundPathList.add(file.getAbsolutePath());  // 添加该路径（已找到文件）
//                    }


                    if (overMode){
                        foundPathList.add(file.getAbsolutePath());  // 添加该路径（已找到文件）

                    }else {

                        foundPath=file.getAbsolutePath();
                        //index++;
                        throw new Exception("Exit the inner function."); // 抛出异常，直接退到外层函数
                    }

//                    if (searchMode == 1) {
////                        System.out.println("1111111111111");
//
////                        System.out.println();
////                        System.out.println("---------------------------");
////                        System.out.println();
//
//                        foundPath=file.getAbsolutePath();
//                        //index++;
//                        throw new Exception("Exit the inner function."); // 抛出异常，直接退到外层函数
//                    }


                }
            }
        }
    }

    private static void foundHandle(File file) throws Exception {
        // 检查路径
//        if (checkPath(file)) {

//            System.out.println();
//            System.out.println(file.getAbsolutePath());

//            foundPath.add(file.getAbsolutePath());  // 添加路径
//            if (searchMode == 2) {
//                throw new Exception("退出内层函数"); // 抛出异常，直接退到外层函数
//            }
//        }
    }


    //  待优化
//    private static boolean checkPath(File file) {
//        String keyPath = "";
//        if (fileName.equals("YuanShen.exe")) {
//            file = new File(file.getParent());
//            String gamePath = file.getName();
//            //System.out.println("gamePath = "+gamePath);
//            if (!gamePath.equals("Genshin Impact Game")) return false;
//            keyPath = file.getParent() + "\\launcher.exe";
//        }
//        if (fileName.equals("launcher.exe")) {
//            keyPath = file.getParent() + "\\Genshin Impact Game\\YuanShen.exe";
//        }
//
//
//        //System.out.println("keyPath = "+keyPath);
//        //System.out.println("filePath = "+file);
//
//        File exFile = new File(keyPath);
//        return exFile.exists();
//    }


    private static boolean isIgnoreDir(File dir) {
        String dirName = dir.getName();
        for (String ignoreDir : IGNORE_DIRS) {
            if (dirName.equalsIgnoreCase(ignoreDir)) {
                return true;
            }
            if (dirName.contains("$")||dirName.contains("@")) {
                return true;
            }
        }
        return false;
    }




    ////////////////////////////////////////////////////////////////////////////////


    /** 不间断搜索 */
    public static List<String> overSearch(String srhFile, Integer srhDepth) {
        MAX_DEPTH = srhDepth;
        fileName = srhFile;
        overMode=true;
        try {
            first();
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }
        return foundPathList;
    }

    public static List<String> overSearch(String srhFile) {
        fileName = srhFile;
        return overSearch(fileName,4);
    }

    public static List<String> overSearch() {
        return overSearch("launcher.exe");
    }

    /** 开始接力搜索 */
    public static String reSearch(String srhFile, Integer srhDepth) {
        MAX_DEPTH = srhDepth;
        fileName = srhFile;
        overMode=false;
        try {
            first();
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }
        return foundPath;
    }

    public static String reSearch(String srhFile) {
        fileName = srhFile;
        return reSearch(fileName,6);
    }

    public static String reSearch() {
        return reSearch("launcher.exe");
    }

    /** 继续接力搜索 */
    public static String conSearch() {
        try {
            follow();
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }
        return foundPath;
    }

}
