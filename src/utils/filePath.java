package utils;

import java.io.File;

public class filePath implements imeko {

    /**
     * 判断当前工作环境
     */
    private static Boolean devEnv() {
        String filePath = "data/test.txt";
        File file = new File(filePath);
        return file.exists();
    }

    public static String co(String filePath) {
        if (!devEnv()) return "../../../" + filePath;
        return filePath;
    }

}
