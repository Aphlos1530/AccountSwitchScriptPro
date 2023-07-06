package utils;

public class mekoBeginEnd {

    public int begin;

    public int end;

    private int down;

    private int up;

    //构造

    public mekoBeginEnd(int begin, int end, int down, int up) {
        set(begin, end, down, up);
        new mekoBeginEnd();
    }

    public mekoBeginEnd(int begin, int end, int length) {
        set(begin, end, length);
        new mekoBeginEnd();
    }

    public mekoBeginEnd() {

    }

    //获取

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    //重设

    public void set(int begin, int end, int down, int up) {
        this.begin = begin;
        this.end = end;
        this.down = down;
        this.up = up;
        limit();
    }

    public void set(int begin, int end, int length) {
        set(begin, end, 0, length - 1);  //兼容数组下标
    }

    //处理

    private void limit() {
        reverse();  //反转
        circle();   //周期
        reverse();  //??
    }

    private void reverse() {
        if (up < down) swapUpDown();
        if (end < begin) swapBeginEnd();
    }

    private void swapUpDown() {
        int temp = up;
        up = down;
        down = temp;
    }

    private void swapBeginEnd() {
        int temp = begin;
        begin = end;
        end = temp;
    }

    private void circle() {
        int mod = up - down + 1;  //先判反转
        begin %= mod;
        end %= mod;
    }

}
