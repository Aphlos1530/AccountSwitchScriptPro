package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mekoBuilder {

    StringBuilder builder = new StringBuilder();


    //构造

    public mekoBuilder() {
        builder = new StringBuilder();
    }

    public mekoBuilder(String string) {
        builder = new StringBuilder(string);
    }

    public mekoBuilder(StringBuilder build) {
        builder = build;
    }

    //设置

    public void set(String string) {
        if (builder==null){
            builder = new StringBuilder(string);
        }else {
            //clear();
            builder.setLength(0);
//            System.out.println("builder = "+builder);
            builder.append(string);
//            System.out.println("builder = "+builder);
        }
    }

    public void set(StringBuilder build) {
        if (builder==null){
            builder = build;
        }else {
            //clear();
            builder.setLength(0);
            builder.append(build.toString());
        }
    }

    //获取

    public String getString(int start, int end) {
        if (start < 1 || end < 1) return "";
        if (end > start) return builder.substring(start - 1, end);
        if (end < start) return builder.substring(end - 1, start);
        return "";
    }

    public String getString(int start) {
        return getString(start,builder.length());
    }

    public String getStringEnhance(int start, int end) {
        if (start == 0 || end == 0) return "";
        if (start < 1) start += builder.length() + 1;
        if (end < 1) end += builder.length() + 1;
        if (end > start) return builder.substring(start - 1, end);
        if (end < start) {
            String reversed = builder.substring(end - 1, start);
            return new StringBuilder(reversed).reverse().toString();  //构造新对象以避免改变原有值
        }
        return "";
    }


    public String getStringEnhance(int start) {
        return getStringEnhance(start,builder.length());
    }

    public char charAt(int index) {
        if (index > builder.length()) return ' ';
        return builder.charAt(index - 1);
    }


    //转换

    /** 转字符串 */
    public String toString(){
        return builder.toString();
    }

    /** 转字符数组 */
    public char[] toCharArray(){
        char[] charArray = new char[builder.length()];
        builder.getChars(0, builder.length(), charArray, 0);
        return charArray;
    }

    //替换

    /** 直接替换 */
    public mekoBuilder replaceAll(String oldStr, String newStr) {
        int index = builder.indexOf(oldStr);
        while (index != -1) {
            builder.replace(index, index + oldStr.length(), newStr);
            index = builder.indexOf(oldStr, index + 1);
        }
        return this;
    }

    public mekoBuilder replace(String oldStr, String newStr) {
        return replaceAll(oldStr,newStr);
    }

    /** 替换一次 */
    public mekoBuilder replaceOnce(String oldStr, String newStr, int order) {
        int index = builder.indexOf(oldStr);
        int judex = 0;
        while (index != -1) {
            if (judex == order) {
                builder.replace(index, index + oldStr.length(), newStr);
                return this;
            }
            index = builder.indexOf(oldStr, index + 1);
            judex++;
        }
        return this;
    }

    public mekoBuilder replaceOnce(String oldStr, String newStr) {
        return replaceOnce(oldStr,newStr,1);
    }

    /** 正则替换 */
    public mekoBuilder replaceAllByRegex(String regex, String replacement) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.toString());
        String result = matcher.replaceAll(replacement);
        set(result);
        return this;
    }

    //追加与插入

    public mekoBuilder append(String cont){
        builder.append(cont);
        return this;
    }

    public mekoBuilder append(Integer index,String cont){
        if (index < 0) index = builder.length() + index;
        builder.insert(index,cont);
        return this;
    }

    public mekoBuilder appendMulti(String cont,Integer times){
        builder.append(cont.repeat(times));
        return this;
    }

    public mekoBuilder appendMulti(Integer index,String cont,Integer times){
        if (index < 0) index = builder.length() + index;
        builder.insert(index,cont.repeat(times));
        return this;
    }

    //清空

    public mekoBuilder clear(){
        builder.setLength(0);
        return this;
    }

    //删除

    public mekoBuilder remove(String cont){
        int index = builder.indexOf(cont);
        if (index != -1) {
            builder.delete(index, index + cont.length());
        }
        return this;
    }

    public mekoBuilder remove(Integer index){
        if (index < 0) index = builder.length() + index;
        builder.deleteCharAt(index);
        return this;
    }

//    public mekoBuilder remove(Integer from, Integer to) {
////        if (from < 0) from += builder.length();
////        if (to < 0) to += builder.length();
////
////        int len = to - from + 1;
////        builder.delete(from, len);
//        return this;
//    }

    //长度

    public int length(){
        return builder.length();
    }

}
