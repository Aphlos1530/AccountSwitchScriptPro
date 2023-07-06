package utils;

public class mekoInterval {

    private int O_L;
    private int O_R;

    private int I_L;
    private int I_R;

    //对外接口

    public void setOuter(int outerLeft, int outerRight) {
        O_L = outerLeft;
        O_R = outerRight;
    }

    public void setInner(int innerLeft, int innerRight) {
        I_L = innerLeft;
        I_R = innerRight;
    }

    public void transform() {
        outerReverse();
        innerMod();
        innerReverse();
    }

    public int getInnerLeft() {
        return I_L;
    }

    public int getInnerRight() {
        return I_R;
    }

    //区间变化

    private void outerReverse() {
        if (O_L > O_R) {
            int o_T = O_L;
            O_L = O_R;
            O_R = o_T;
        }
    }

    private void innerMod() {
        int MOD = O_R - O_L + 1;
        //if (I_L < O_L) I_L = (I_L + O_L) % MOD - O_L;
        //if (I_R > O_R) I_R = (I_R + O_R) % MOD - O_R;

        I_L %= MOD;
        I_R %= MOD;
        if (I_L > O_R) I_L -= MOD;
        if (I_R < O_L) I_R += MOD;
    }

    private void innerReverse() {
        if (I_L > I_R) {
            int I_T = I_L;
            I_L = I_R;
            I_R = I_T;
        }
    }

}
