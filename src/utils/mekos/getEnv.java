package utils.mekos;

public class getEnv {

    public static void main(String[] args) {
        if (System.console() == null) {
            // 在 IDE 等其他环境中运行
            System.out.println("IDEA");
        } else {
            // 在命令行中运行
            System.out.println("CMD");
        }
    }
}
