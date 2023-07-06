package utils;

/** 自定义区间限制类 */
public class mekoBeginEnd {

    private final mekoInterval meir =new mekoInterval();;

    //构造

    public mekoBeginEnd() {

    }

    public mekoBeginEnd(int begin, int end, int down, int up) {
        meir.setInner(begin, end);
        meir.setOuter(down, up);
        meir.transform();
    }

    public mekoBeginEnd(int begin, int end, int length) {
//       new mekoBeginEnd(begin, end, 0, length - 1);

        meir.setInner(begin, end);
        meir.setOuter(0, length-1);
        meir.transform();
    }


    //获取

    public int getBegin() {
        return meir.getInnerLeft();
    }

    public int getEnd() {
        return meir.getInnerRight();
    }

    //设置


    public void set(int begin, int end) {
        meir.setInner(begin, end);
        deal();
    }

    public void limit(int down, int up) {
        meir.setOuter(down, up);
        deal();
    }


    public void limit(int length) {
        limit(0, length - 1);  //兼容数组下标
    }

    //处理

    private void deal() {
        meir.transform();
    }

}
