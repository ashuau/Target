/**
 * Created by Lenovo on 6/11/2017.
 */
public class SwapWithoutThirdVariable {
    public static void main(String[] arg)
    {
        int a =12330;
        int b =120;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a +"\t"+b);
    }
}
