package test;

import asc.*;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;

public class test {

    @Test
    // Failure
    public void test1() {
        String eMode = config.get("eMode");
        System.out.println("eMode="+eMode);
        if (eMode.equals("1")) config.set("eMode","2");
        if (eMode.equals("2")) config.set("eMode","1");
        eMode = config.get("eMode");
        System.out.println("eMode="+eMode);
    }

    @Test
    // Failure
    public void test2() {
        String eMode = config2.get("eMode");
        System.out.println("eMode="+eMode);
        if (eMode.equals("1")) config2.set("eMode","2");
        if (eMode.equals("2")) config2.set("eMode","1");
        eMode = config2.get("eMode");
        System.out.println("eMode="+eMode);
    }

    @Test
    // Successful
    public void test3() {
        String eMode = config3.get("eMode");
        System.out.println("eMode="+eMode);
        if (eMode.equals("1")) config3.set("eMode","2");
        if (eMode.equals("2")) config3.set("eMode","1");
        eMode = config3.get("eMode");
        System.out.println("eMode="+eMode);
    }

    @Test
    // Successful
    public void test4() {
        String eMode = config4.get("eMode");
        System.out.println("eMode="+eMode);
        if (eMode.equals("1")) config4.set("eMode","2");
        if (eMode.equals("2")) config4.set("eMode","1");
        eMode = config4.get("eMode");
        System.out.println("eMode="+eMode);
    }


    @Test
    // Successful
    public void test5() {
        String eMode = config5.get("eMode");
        System.out.println("eMode="+eMode);
        if (eMode.equals("1")) config5.set("eMode","2");
        else if (eMode.equals("2")) config5.set("eMode","1");
        else config5.set("eMode","999");
        eMode = config5.get("eMode");
        System.out.println("eMode="+eMode);
    }

    @Test
    // Successful
    public void test6() {
        config6 config6 = new config6();
        String eMode = config6.get("eMode");
        System.out.println("eMode="+eMode);
        if (eMode.equals("1")) config6.set("eMode","2");
        if (eMode.equals("2")) config6.set("eMode","1");
        eMode = config6.get("eMode");
        System.out.println("eMode="+eMode);
    }

    @Test
    // Successful
    public void teatIFH1() throws IOException {
        IniFileHandler handler = new IniFileHandler("src/data/config.ini");
        String value = handler.getProperty("key1");
        System.out.println("Value of key1: " + value);
        //handler.setProperty("key1", "new value");
        Random random = new Random();
        int randomNumber = random.nextInt();
        int randomInRange = Math.abs(randomNumber) % 100;
        handler.setProperty("key1", String.valueOf(randomInRange));
        value = handler.getProperty("key1");
        System.out.println("Value of key1 after: " + value);
    }


}
