package test;

public class testBackslash {

    public static void main(String[] args) {
        testBackslash1();
        System.out.println();
        testBackslash2();
        System.out.println();
        testBackslash3();
        System.out.println();
        testBackslash4();
        System.out.println();
        testBackslash5();
        System.out.println();
        testBackslash6();
        System.out.println();
    }

    private static void testBackslash1() {
        System.out.print("Hello\r\nWorld");
    }

    private static void testBackslash2() {
        System.out.print("Hello\r\r\nWorld");
    }


    private static void testBackslash3() {
        System.out.print("Hello\r\r\r\nWorld");
    }

    private static void testBackslash4() {
        System.out.print("Hello\r4\nWorld");
    }

    private static void testBackslash5() {
        System.out.print("Hello\r\r5\nWorld");
    }


    private static void testBackslash6() {
        System.out.print("Hello\r\r\r6\nWorld");
    }

}
