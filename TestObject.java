import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.*;


final class Test implements Serializable {

    private final int id;
    private final String name;


   public Test(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId()
    {
        return this.id;
    }
   public String getName() {
        return this.name;
    }
}
public class TestObject {
    enum TransactionType {
        BUY,SELL,DEPOSIT,WITHDRAW;
		/*private int type;
		private String name;
		TransactionType(String name, int type) {
			this.name = name;
			this.type = type;
		}

		public int getType() {
			return type;
		}
		public String getName(){
			return  name;
		}*/
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {




        System.out.println(TransactionType.BUY);



    }


}
