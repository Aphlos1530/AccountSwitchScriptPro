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
        //circle();
        //bound();
        //aa();


        calcMod();
        originSkew();
        lineSkew();
        boundsHandle();

        //bb();
        //circle();
        innerReverse();


//        boundsHandle();
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

    /**
     * 周期循环
     */
    private void circle() {
        int MOD = O_R - O_L + 1;
        I_L %= MOD;
        I_R %= MOD;
//        if (I_L < O_L) I_L = (I_L + O_L) % MOD - O_L;
//        if (I_R > O_R) I_R = (I_R + O_R) % MOD - O_R;
//        if (I_L < O_L) I_L = (I_L - O_L) % MOD + O_L;
//        if (I_R > O_R) I_R = (I_R - O_R) % MOD + O_R;


        System.out.println("I_L = "+I_L);
        System.out.println("I_R = "+I_R);

//        if (I_L < 0) I_L += MOD;
//        if (I_R < 0) I_R += MOD;
//        System.out.println("I_L = "+I_L);
//        System.out.println("I_R = "+I_R);
    }

    private int MOD;

    //模数计算
    private void calcMod(){
        MOD = O_R - O_L + 1;
    }



    //原点偏移（使得 IL-IR 束缚在正负 LEN 区间内）
    private void originSkew(){
        //int MOD = O_R - O_L + 1;
        I_L %= MOD;
        I_R %= MOD;
    }

    //区间翻转（使得 IL-IR 束缚在 0-LEN 区间内）
    private void aa(){

        //int MOD = O_R - O_L + 1;

        if (I_L < 0) I_L += MOD;
        if (I_R < 0) I_R += MOD;
//



//        int MOD = O_R - O_L + 1;
//
////        I_L+=O_L+MOD;
////        I_R+=O_R-MOD;
//
//        I_L+=O_L;
//        I_R+=O_R;

//
//        innerReverse();
//        System.out.println("I_L = "+I_L);
//        System.out.println("I_R = "+I_R);
//
//
//        int offset =O_L-0;
//        I_L+=offset;
//        I_R+=offset;

//        I_L+=(O_L/MOD)*MOD;
//        I_R+=(O_L/MOD)*MOD;


    }

    //行偏移（使得 IL-IR 与 OL-OR 有交集。这样差距就会小于 1LEN ）
    private void lineSkew(){

//        int offsetLeft = I_L-O_L;
//        int offsetRight = I_R-O_R;
//
//        I_L-=O_L;
//        I_R-=O_R;


        //int MOD = O_R - O_L + 1;


        int LOF = O_L/MOD;//相较于原点的偏移行数（用OL、OR都行）

        I_L+=LOF*MOD;
        I_R+=LOF*MOD;

    }

    /**
     * 越界处理
     */
    private void boundsHandle() {
        //int MOD = O_R - O_L + 1;
//
//        if (I_L > O_R) I_L -= MOD;
//        if (I_R < O_L) I_R += MOD;


        if (I_L < O_L) I_L += MOD;
        if (I_R < O_L) I_R += MOD;


        if (I_L > O_R) I_L -= MOD;
        if (I_R > O_R) I_R -= MOD;

//        if (I_L < O_L) I_L += MOD;
//        if (I_R < O_L) I_R += MOD;
//
//
//        if (I_L > O_R) I_L -= MOD;
//        if (I_R > O_R) I_R -= MOD;
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
