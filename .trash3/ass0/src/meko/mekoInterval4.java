package utils;

/**
 * 自定义区间限制类
 */
public class mekoInterval {

    private int O_L;
    private int O_R;

    private int I_L;
    private int I_R;

    //设置

    public void setOuter(int outerLeft, int outerRight) {
        O_L = outerLeft;
        O_R = outerRight;
    }

    public void setInner(int innerLeft, int innerRight) {
        I_L = innerLeft;
        I_R = innerRight;
    }

    //获取

    public int getInnerLeft() {
        return I_L;
    }

    public int getInnerRight() {
        return I_R;
    }

    //处理

    public void transform() {
        outerReverse();
        calcMod();
        originSkew();
        intervalFlip();
        lineSkew();
        boundsHandle();
        innerReverse();
    }

    /**
     * 外区间反转
     */
    private void outerReverse() {
        if (O_L > O_R) {
            int o_T = O_L;
            O_L = O_R;
            O_R = o_T;
        }
    }

    private int MOD;

    /**
     * 模数计算
     */
    private void calcMod() {
        MOD = O_R - O_L + 1;
    }

    /**
     * 原点偏移（使得 IL-IR 束缚在正负 LEN 区间内）
     */
    private void originSkew() {
        I_L %= MOD;
        I_R %= MOD;
    }

    /**
     * 区间翻转（使得 IL-IR 束缚在 0-LEN 区间内）
     */
    private void intervalFlip() {
        if (I_L < 0) I_L += MOD;
        if (I_R < 0) I_R += MOD;
    }

    /**
     * 行偏移（使得 IL-IR 与 OL-OR 有交集。这样差距就会小于 1LEN ）
     */
    private void lineSkew() {

        int LOF = O_L / MOD;//相较于原点的偏移行数（用OL、OR都行）

        //修正行数

        I_L += LOF * MOD;
        I_R += LOF * MOD;

    }

    /**
     * 越界处理（ IL-IR 并不一定与 OL-OR 重合，因此可能会有一些值出现在两边，即上下行）
     */
    private void boundsHandle() {

        //这里并不确定，也不适合确定谁大谁小，谁左谁右（即使确定了左右，在修正后也还要再确定一次）

        //超出下边界

        if (I_L < O_L) I_L += MOD;
        if (I_R < O_L) I_R += MOD;

        //超出上边界

        if (I_L > O_R) I_L -= MOD;
        if (I_R > O_R) I_R -= MOD;

    }

    /**
     * 内区间反转
     */
    private void innerReverse() {
        if (I_L > I_R) {
            int I_T = I_L;
            I_L = I_R;
            I_R = I_T;
        }
    }

}
