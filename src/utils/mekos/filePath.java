package utils.mekos;

import java.io.File;

public class filePath implements imeko {

    /**
     * 判断当前工作环境
     */
    private static Boolean jarEnv() {
        return fileExist("../../../data");
    }

    private static Boolean devEnv() {
        return fileExist("target/classes");
    }

    private static Boolean ideaEnv() {
        return fileExist("out/artifacts");
    }

    private static Boolean testEnv() {
        return fileExist("");
    }

    private static Boolean prodEnv() {
        return fileExist("");
    }

    private static Boolean fileExist(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public static String co(String filePath) {
        if (jarEnv()) return "../../../" + filePath;
        return filePath;
    }

}
