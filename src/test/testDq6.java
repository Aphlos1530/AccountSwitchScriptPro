package test;

import utils.halfToFull;

public class testDq6 {

    public static void main(String[] args) {
        test9();
    }

    public static void test9() {
        String[] lines = {
//                "",
//                "* * * * * * * * *",
////                "*                   *",
//                "*      主菜单      *",
////                "*                   *",
//                "*    一、账号切换     *",
////                "*                   *",
//                "*    二、账号管理     *",
////                "*                   *",
//                "*    三、设置       *",
////                "*                   *",
//                "*    四、问题修复     *",
////                "*                   *",
//                "*    六、帮助       *",
////                "*                   *",
//                "*    负一、退出      *",
////                "*                   *",
//                "* * * * * * * * *",
                "",
                " ┏━━━━━━━━━━━━━━━━━━━━━━┓ ",
                " ┃           ┃ ",
                " ┃    主菜单    ┃ ",
                " ┃           ┃ ",
                " ┃  一、账号切换   ┃ ",
                " ┃           ┃ ",
                " ┃  二、账号管理   ┃ ",
                " ┃           ┃ ",
                " ┃  三、设置     ┃ ",
                " ┃           ┃ ",
                " ┃  四、问题修复   ┃ ",
                " ┃           ┃ ",
                " ┃  五、打开启动器  ┃ ",
                " ┃           ┃ ",
                " ┃  六、帮助     ┃ ",
                " ┃           ┃ ",
                " ┃  负一、退出    ┃ ",
                " ┃           ┃ ",
                " ┗━━━━━━━━━━━━━━━━━━━━━━┛ ",
                "",
                "模拟：",
                " ┏━━━━━━━━━━━━━━━━━━━━┓ ",
                " ┃          ┃ ",
                " ┃   主菜单    ┃ ",
                " ┃          ┃ ",
                " ┃ 一、账号切换   ┃ ",
                " ┃          ┃ ",
                " ┃ 二、账号管理   ┃ ",
                " ┃          ┃ ",
                " ┃ 三、设置     ┃ ",
                " ┃          ┃ ",
                " ┃ 四、问题修复   ┃ ",
                " ┃          ┃ ",
                " ┃ 五、打开启动器  ┃ ",
                " ┃          ┃ ",
                " ┃ 六、帮助     ┃ ",
                " ┃          ┃ ",
                " ┃ 负一、退出    ┃ ",
                " ┃          ┃ ",
                " ┗━━━━━━━━━━━━━━━━━━━━┛ ",
                "模拟2：",
                " ┏━━━━━━━━━━━━━━━━━━┓ ",
                " ┃         ┃ ",
                " ┃   主菜单   ┃ ",
                " ┃         ┃ ",
                " ┃ 一、账号切换  ┃ ",
                " ┃         ┃ ",
                " ┃ 二、账号管理  ┃ ",
                " ┃         ┃ ",
                " ┃ 三、设置    ┃ ",
                " ┃         ┃ ",
                " ┃ 四、问题修复  ┃ ",
                " ┃         ┃ ",
                " ┃ 五、打开启动器 ┃ ",
                " ┃         ┃ ",
                " ┃ 六、帮助    ┃ ",
                " ┃         ┃ ",
                " ┃ 负一、退出   ┃ ",
                " ┃         ┃ ",
                " ┗━━━━━━━━━━━━━━━━━━┛ ",
//                "",
//                "",
//                " ┏━━━━━━━━━━━━━━━━━━━━━━┓ ",
//                " ┃           ┃ ",
//                " ┃    主菜单    ┃ ",
//                " ┃           ┃ ",
//                " ┃  1. 账号切换   ┃ ",
//                " ┃           ┃ ",
//                " ┃  2. 账号管理   ┃ ",
//                " ┃           ┃ ",
//                " ┃  3. 设置     ┃ ",
//                " ┃           ┃ ",
//                " ┃  4. 问题修复   ┃ ",
//                " ┃           ┃ ",
//                " ┃  5. 打开启动器  ┃ ",
//                " ┃           ┃ ",
//                " ┃  6. 帮助     ┃ ",
//                " ┃           ┃ ",
//                " ┃  -1. 退出    ┃ ",
//                " ┃           ┃ ",
//                " ┗━━━━━━━━━━━━━━━━━━━━━━┛ ",
////                "",
                "",
                " ┏━━━━━━━━━━━━━━━━━━━━━━┓ ",
                " ┃           ┃ ",
                " ┃    主菜单    ┃ ",
                " ┃           ┃ ",
                " ┃  1.账号切换   ┃ ",
                " ┃           ┃ ",
                " ┃  2.账号管理   ┃ ",
                " ┃           ┃ ",
                " ┃  3.设置     ┃ ",
                " ┃           ┃ ",
                " ┃  4.问题修复   ┃ ",
                " ┃           ┃ ",
                " ┃  5.打开启动器  ┃ ",
                " ┃           ┃ ",
                " ┃  6.帮助     ┃ ",
                " ┃           ┃ ",
                " ┃  -1.退出    ┃ ",
                " ┃           ┃ ",
                " ┗━━━━━━━━━━━━━━━━━━━━━━┛ ",
//                "",
        };
        int maxLength = 0;
        for (String line : lines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }
        int index=0;
        for (String line : lines) {
            //if (index==1) {System.out.println(line);index++; continue;}
            String paddedLine = line.replace(" ", "\u3000");
//            paddedLine = paddedLine.replace("*", "\uff0a");
            //paddedLine = paddedLine.replace("*", "\uff03");
//            paddedLine = paddedLine.replace("1", "一");
//            paddedLine = paddedLine.replace("2", "二");
//            paddedLine = paddedLine.replace("3", "三");
//            paddedLine = paddedLine.replace("4", "四");
//            paddedLine = paddedLine.replace("6", "六");
//            paddedLine = paddedLine.replace("-1", "负一");

            paddedLine= halfToFull.convert(paddedLine);
            System.out.println(paddedLine + " ".repeat(maxLength - paddedLine.length()));
            //System.out.println();
            index++;
        }
    }
}
