package utils;

import static java.io.File.*;

public class mekoPath {

    /**
     * 文件路径
     */
    public static String destPath(String path) {
        return lastPath(path, 1);
    }

    /**
     * 文件名称
     */
    public static String destFile(String path) {
        int lastSlashIndex = Math.max(path.lastIndexOf("/"), path.lastIndexOf("\\"));
        return path.substring(lastSlashIndex + 1);
    }

    /**
     * 上一级目录
     */
    public static String lastPath(String path) {
        return lastPath(path, 1);
    }

    /**
     * 上多级目录
     */
    public static String lastPath(String path, Integer level) {

        path = path.replace("/", ",").replace("\\", ",");
        String[] split = path.split(",");

        StringBuilder newPath = new StringBuilder();
        for (int index = 0; index < split.length - level; index++) {
            if (index != 0) newPath.append(separator);
            newPath.append(split[index]);
        }
        return String.valueOf(newPath);

    }

}
