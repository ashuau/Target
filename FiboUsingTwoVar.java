public class FiboUsingTwoVar {

    void print(int n){

        int a =0, b =1;
        if (n >=0 )
        {
            System.out.println(a);
        }
        if (n >= 1 )
        {
            System.out.println(b);
        }
        for (int i = 1; i < n; i++)
        {
            b = a+b;
            a = b - a;
            System.out.println(b);
        }
    }

    public  static void main(String [] args)
    {
        FiboUsingTwoVar ob = new FiboUsingTwoVar();
        ob.print(8);
    }
}
