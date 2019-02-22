import java.io.*;


class Employee implements Serializable{
    public String firstName;
    private static final long serialVersionUID = 5462223600l;
    public String lastName;
    static  String companyName;
    transient  String address;
    static transient String companyCEO;

   /* @Override
    public String toString()
    {
        return "Company name :"+companyName + " CEO : "+companyCEO;
    }*/
}

public class SerializationTest {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.firstName = "Vivekananda";
        emp.lastName = "Gautam";

        emp.companyName = "ZOHO";
        //Below part needs to be removed in case address field is made final
        emp.companyCEO = "Sridhar Vembu";
        emp.address = "Estancia";

        try {
            FileOutputStream fileOut = new FileOutputStream("./employee1.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in ./employee1.txt file");
        } catch (IOException i) {
            i.printStackTrace();
        }

        // Deserializing objects
        Employee emp1;
        try {
            FileInputStream fileIn = new FileInputStream("./employee1.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            emp1 = (Employee) in.readObject();
            //in.close();
            //fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("\n Deserializing Employee... \n");
        System.out.println("First Name of Employee: " + emp1.firstName);
        System.out.println("Last Name of Employee: " + emp1.lastName);
        System.out.println("Company Name: "+emp1.companyName);
        System.out.println("Company CEO: "+emp1.companyCEO);
        System.out.println("Company Address: "+emp1.address);
        //System.out.println(emp1.toString());
    }
}