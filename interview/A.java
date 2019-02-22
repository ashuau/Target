package interview;

class Aa {

    int value;

    public Aa() {

    }

    public void setValue(int v) {
        this.value = v;
    }

}
class B extends Aa {

}
public class A{
    public static void main(String[] args) {
       Aa obj = new B();
    //  B obj2 = new A();
     //  B obj3 = obj;

        int i = 9;
        System.out.println(i >> 6);

    }
}
