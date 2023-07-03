package utils.mekos;

import java.io.IOException;

public class clear implements imeko {


    private static final String environment = System.console() == null ? "IDEA" : "CMD";   //在 CMD 中运行还是 IDEA 中运行

    public static void co() {
        if (environment.equals("IDEA")) {
            // IDEA 中不支持清屏操作，打印空行效果不佳，这里仅打印换行
            // System.out.println();
            // IDEA 中不支持清屏操作，打印空行效果不佳，此处不进行任何操作
        } else {
            try {
                clearScreen();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 控制台清屏
     */
    private static void clearScreen() throws IOException, InterruptedException {
        //新建一个 ProcessBuilder，其要执行的命令是 cmd.exe，参数是 /c 和 cls
        new ProcessBuilder("cmd", "/c", "cls")
                //将 ProcessBuilder 对象的输出管道和 Java 的进程进行关联，这个函数的返回值也是一个 ProcessBuilder
                .inheritIO()
                //开始执行 ProcessBuilder 中的命令
                .start()
                //等待 ProcessBuilder 中的清屏命令执行完毕，如果不等待则会出现清屏代码后面的输出被清掉的情况
                .waitFor(); // 清屏命令
    }

}
