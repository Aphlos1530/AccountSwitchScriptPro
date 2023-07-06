package auto;

import utils.mekoBeginEnd;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class LnkParser2 {

    // http://www.oschina.net/code/snippet_12_274

    public static void main(String[] args) throws Exception {
        //new LnkParser(new File("e:/eclipse.lnk"));
        //new LnkParser2(new File("D:\\Eval\\Desktop\\原神.lnk"));

//        byte[] array1 = FileToByteArray1(new File("D:\\Eval\\Desktop\\原神.lnk"));
//        byte[] array2 = FileToByteArray2(new File("D:\\Eval\\Desktop\\原神.lnk"));
//
//        System.out.println(Arrays.equals(array1, array2));
//
//        boolean isDir1 = isDirectory(array1);
//
//        boolean isDir2 = getBitFlag(array1[0x18], 4);
//
//        System.out.println(isDir1==isDir2);
//
//
//
//        boolean isDir3 = getBitFlag(array1[0x18], 129);
//        System.out.println(isDir3);
//
//
//        boolean bitFlag = getBitFlag(array1, 0x18, 0x14, 4);
//        System.out.println(isDir2 == bitFlag);


        String path = "D:\\Eval\\Desktop\\原神.lnk";

//        path = "D:\\Eval\\快捷方式\\我的快捷访问\\ASS-Pro.lnk";

//        path = "D:\\Eval\\Desktop\\CCC.lnk";

//        path = "D:\\Eval\\Desktop\\WePE64.lnk";

//        path="D:\\Eval\\Desktop\\liblnk-main.lnk";

//        path="D:\\Eval\\Desktop\\Launch4j.lnk";

        path="D:\\Eval\\Desktop\\QQ音乐.lnk";


        byte[] link = FileToByteArray2(new File(path));


//        for (int i = 0; i < 13; i++) {
////            System.out.println(i + " : " + getBitFlag(link, 0x18, 0x19, i));
//            System.out.println(i + " : " + getBitFlag(link, 0x18, i));
//        }


        for (int i = 0; i < 7; i++) {
            System.out.println(i + " : " + getBitFlag(link, 0x14, i));
        }

    }

    public LnkParser2(File f) throws Exception {
        parse(f);
    }

    private boolean is_dir;

//    public boolean isDirectory() {
//        return is_dir;
//    }

    private String real_file;

    public String getRealFilename() {
        return real_file;
    }


    private static byte[] FileToByteArray1(File f) throws IOException {
        FileInputStream fis = new FileInputStream(f);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[256];
        while (true) {
            int num = fis.read(buff);
            if (num == -1) {
                break;
            }
            baos.write(buff, 0, num);
        }
        fis.close();
       return baos.toByteArray();
    }

    public static byte[] FileToByteArray2(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }


    //Step1 : read the entire file into a byte buffer  //将整个文件读入字节缓冲区

    public static byte[] fileToByteArray(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }


    /*
     *
     *
     * file_att_offset=0x18
     *
     *
     *
     *
     *   // get the file attributes byte
        //获取文件属性字节
     *
     */

//    public boolean isDirectory(byte[] link) {
//        byte fileAttrs = link[0x18];  // get the file attributes byte  //获取文件属性字节
//        byte is_dir_mask = (byte) 0x10;
//        return (fileAttrs & is_dir_mask) > 0;
//    }

//    private static final byte IS_DIR_MASK = 0x10;
//    private static final byte FILE_ATTR_OFFSET = 0x18;
//    public boolean isDirectory(byte[] link) {
//        byte fileAttrs = link[FILE_ATTR_OFFSET];  // get the file attributes byte  //获取文件属性字节
//        return (fileAttrs & IS_DIR_MASK) != 0;
//    }
//    

    public static boolean isDirectory(byte[] link) {
        byte IS_DIR_MASK = 0x10;  //00010000
        byte FILE_ATTR_OFFSET = 0x18;
        byte fileAttrs = link[FILE_ATTR_OFFSET];  // get the file attributes byte  //获取文件属性字节
        return (fileAttrs & IS_DIR_MASK) != 0;  //Bit[4]是否为1
    }

    public static boolean isDirectoryNew(byte[] link) {
        return getBitFlag(link[0x18], 4);
    }



    // if the shell settings are present, skip them
    //如果存在shell设置，跳过它们

    public static boolean haveShellSetting(byte[] link){
        return getBitFlag(link[0x14],0);
    }



    public void parse(File file) throws Exception {

        // read the entire file into a byte buffer
        //将整个文件读入字节缓冲区

//        FileInputStream fis = new FileInputStream(f);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        byte[] buff = new byte[256];
//        while (true) {
//            int num = fis.read(buff);
//            if (num == -1) {
//                break;
//            }
//            baos.write(buff, 0, num);
//        }
//        fis.close();
        byte[] link = fileToByteArray(file);



        // get the file attributes byte
        //获取文件属性字节

        //final int file_att_offset = 0x18;
//        byte fileAttrs = link[0x18];
//        byte is_dir_mask = (byte) 0x10;
//        is_dir = (fileAttrs & is_dir_mask) > 0;



        // if the shell settings are present, skip them
        //如果存在shell设置，跳过它们






        int shell_len = 0;

//        // get the flags byte
//        //获取flags字节
//
//        byte flags = link[0x14];
//        byte IS_SHELL_MASK = 0x1;//00000001
//
////        if ((flags & 0x1) > 0) {
////            // the plus 2 accounts for the length marker itself
////            //+ 2表示长度标记本身
////            shell_len = bytes2short(link) + 2;
////        }
//
//        if ((flags & IS_SHELL_MASK) != 0) {//Shell Item Id List 段
//            // the plus 2 accounts for the length marker itself
//            //+ 2表示长度标记本身
//            shell_len = bytes2short(link) + 2;
//        }

        if (haveShellSetting(link)){
            shell_len = bytes2short(link) + 2;
        }




        // get to the file settings
        //进入文件设置

        final int shell_offset = 0x4c;

        int file_start = shell_offset + shell_len;

        // get the local volume and local system values
        //获取本地卷和本地系统的值

        int local_sys_off = link[file_start + 0x10] + file_start;
        real_file = getNullDelimitedString(link, local_sys_off);

        System.out.println("real filename = " + real_file);

    }

    static String getNullDelimitedString(byte[] bytes, int off) {
        int len = 0;

        // count bytes until the null character (0)
        //统计字节数，直到空字符(0)

        while (bytes[off + len] != 0) {
            len++;
        }
        return new String(bytes, off, len);
    }


    static int bytes2short(byte[] bytes) {
        return bytes[76] | (bytes[76 + 1] << 8);
    }


    //附加工具类


    //获取掩码（标志位从右往左，从0开始）
    private static byte getBitMask(byte b) {
        return switch (b) {
            case 0 -> 0x1;   //0000_0001
            case 1 -> 0x2;   //0000_0010
            case 2 -> 0x4;   //0000_0100
            case 3 -> 0x8;   //0000_1000
            case 4 -> 0x10;  //0001_0000
            case 5 -> 0x20;  //0010_0000
            case 6 -> 0x40;  //0100_0000
            case 7 -> -0x80; //1000_0000
            default -> 0x0;  //0000_0000
        };
    }

    //获取标志位
    private static boolean getBitFlag(byte srd, byte ord) {
        byte msk = getBitMask(ord);
        return (srd & msk) != 0;
    }

    private static boolean getBitFlag(byte srd, int ord) {
        if (ord > 7 || ord < 0) return false;
        return getBitFlag(srd, (byte) ord);
    }


    //待优化
    private static boolean getBitFlag(byte[] srd, int begin, int ord) {
        int end = begin + ord / 8;
        if (end > srd.length) end = srd.length;
        return getBitFlag(srd, begin, end, ord);
    }

    private static boolean getBitFlag(byte[] srd, int bgn, int end, int ord) {
//        System.out.println("ord : " + ord);
//        System.out.println("begin : " + bgn);
//        System.out.println("end : " + end);
//        System.out.println("length = "+srd.length);

        //内部调用
        mekoBeginEnd meb = new mekoBeginEnd(bgn, end, srd.length);
        bgn = meb.getBegin();
        end = meb.getEnd();


//        System.out.println("begin : " + bgn);
//        System.out.println("end : " + end);

        int len = end - bgn + 1;


        if (ord < 0 || ord > len * 8 - 1) {
//            System.out.println("fffffffff");
            return false;
        }
        int index = ord / 8;
        int judex = ord % 8;

//        System.out.println("index = "+index);
//        System.out.println("judex = "+judex);

        byte part = srd[bgn + index];

//        System.out.println(part);

        return getBitFlag(part, judex);
    }


}