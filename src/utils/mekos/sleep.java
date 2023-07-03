package utils.mekos;

public class sleep {

    public static void co(){
        co(1000);
    }

    public static void co(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
