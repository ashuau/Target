
class a{

    int id;
    String name;
    public a()
    {

    }
    public a(int id, String name)
    {
        this.id=id;
        this.name=name;
    }
    public void setName(String str)
    {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public String toString()
    {
        return "id ::"+id+"\t name ::"+name;
    }

}

class b{

    int id;
    String name;
    public b(int id, String name)
    {
        this.id=id;
        this.name=name;
    }

    public b() {

    }

    public void setName(String str)
    {
        this.name = new String(str);
    }
    public String getName() {
        return this.name;
    }
    public String toString()
    {
        return "id ::"+id+"\t name ::"+name;
    }

}

public class StringTest {
    public static void main(String[] args) {
        a ob1 = new a();
        ob1.setName("hello");
        String str1 = ob1.getName();

        b ob2 = new b();
        ob2.setName("hello");
        String str2 = ob2.getName();
        System.out.println(str1 == str2);

    }
}
