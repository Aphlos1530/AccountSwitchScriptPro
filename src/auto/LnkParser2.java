package auto;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class LnkParser2 {

    // http://www.oschina.net/code/snippet_12_274

    public static void main(String[] args) throws Exception {
        //new LnkParser(new File("e:/eclipse.lnk"));
        new LnkParser2(new File("D:\\Eval\\Desktop\\原神.lnk"));
    }

    public LnkParser2(File f) throws Exception {
        parse(f);
    }

    private boolean is_dir;

    public boolean isDirectory() {
        return is_dir;
    }

    private String real_file;

    public String getRealFilename() {
        return real_file;
    }

    public void parse(File f) throws Exception {

        // read the entire file into a byte buffer
        //将整个文件读入字节缓冲区

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
        byte[] link = baos.toByteArray();

        // get the flags byte
        //获取flags字节

        byte flags = link[0x14];

        // get the file attributes byte
        //获取文件属性字节

        final int file_att_offset = 0x18;
        byte fileAttrs = link[file_att_offset];
        byte is_dir_mask = (byte) 0x10;
        is_dir = (fileAttrs & is_dir_mask) > 0;

        // if the shell settings are present, skip them
        //如果存在shell设置，跳过它们


        final int shell_offset = 0x4c;
        int shell_len = 0;
        if ((flags & 0x1) > 0) {
            // the plus 2 accounts for the length marker itself
            //+ 2表示长度标记本身
            shell_len = bytes2short(link) + 2;
        }

        // get to the file settings
        //进入文件设置

        int file_start = 0x4c + shell_len;

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


}