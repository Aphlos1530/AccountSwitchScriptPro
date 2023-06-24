package utils;

//import static lang.toChinese.toCh12;
import lang.toChinese;

import static lang.jp.toJp;
//import static meko.readVar.readVar;


public class echo2 {

    public static void co(String str) {
        
//        if (str.equals("\n")) {
//            System.out.println("\n");
//            return;
//        }
        
        //读取语言设置
        //String language="Chinese";

//        String language = readVar("language");

        String language = readVar.co("language");




        //
//        if (language.equals("Chinese")){
//            toCh(str);
//        }


        //String content="";

        switch (language) {

            case "Chinese" -> str= toChinese.co(str);

            case "Japanese" -> str=toJp(str);

        }

        System.out.println(str);
    }

}
