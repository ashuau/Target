/**
 * Created by Lenovo on 6/11/2017.
 */
import java.io.Serializable;

public class Employee2 implements Serializable{
    public String firstName;
    private static final long serialVersionUID = 5462223600l;
    public String lastName;
    static  String companyName;
    transient  String address;
    static transient String companyCEO;

    @Override
    public String toString()
    {
        return "Company name :"+companyName + " CEO : "+companyCEO;
    }
}

class superEmployee implements Serializable{
}