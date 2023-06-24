package utils;

/** 统一工具方法调用类 */
public class meko {

    public static String swhPath(String path) {return filePath.co(path);}

    public static void echo(Integer code){
        echo.co(code);
    }

    public static void echo(String text){
        echo.co(text);
    }

    public static String readVar(String key) {
        return readVar.co(key);
    }

    public static void writeVar(String key, String value) {
        writeVar.co(key, value);
    }

    public static void waitInput(){
        waitInput.co();
    }

    public static void waitInput(String str){
        waitInput.co(str);
    }

    public static void waitInput(Integer code){
        waitInput.co(code);
    }

    public static String input(){
        return input.co();
    }

    public static String input(String text){
        return input.co(text);
    }

}
