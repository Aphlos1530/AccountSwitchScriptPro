package utils;

public class mekoBeginEnd {

    private int begin;

    private int end;

    private int down;

    private int up;

    //构造

    public mekoBeginEnd() {

    }

    //获取

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    //设置

    public void set(int begin, int end) {
        this.begin = begin;
        this.end = end;
        deal();
    }

    public void limit(int down, int up) {
        this.down = down;
        this.up = up;
        deal();
    }


    public void limit(int length) {
        limit(0, length - 1);  //兼容数组下标
    }

    //处理

    private void deal() {
        reLimit();  //反转外区间
        calcMod();  //求取模数
        circle();  //周期循环
        bound();   //越界处理
        reSect();  //反转内区间
    }

    /**
     * 二限反转
     */
    private void reLimit() {
        if (up < down) {
            int temp = up;
            up = down;
            down = temp;
        }
    }

    private int mod;

    /**
     * 求模
     */
    private void calcMod() {
        mod = Math.abs(up - down) + 1;
    }

    /**
     * 周期循环
     */
    private void circle() {
        begin %= mod;
        end %= mod;
    }

    /**
     * 越界处理
     */
    private void bound() {
        if (begin > up) begin -= mod;
        if (end < down) end += mod;
    }

    /**
     * 二界反转
     */
    private void reSect() {
        if (end < begin) {
            int temp = begin;
            begin = end;
            end = temp;
        }
    }


}
