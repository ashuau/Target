package OOPS;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.BitSet;

class AException extends Exception {


}
class parent {


    public static   ClassNotFoundException add(int ex) throws AException{

        System.out.println("calling parent");
        return new ClassNotFoundException("skdfk");
    }
}

class child extends parent {

    public static ClassNotFoundException add (int ex) throws AException
    {

        System.out.println("calling child"+ex);
        return new ClassNotFoundException("skdfk");
    }
}


public class MethodOverridingTest {

    public static void main(String[] args) throws AException {

        parent ob1 = new child();
       // Integer i = new Integer(10);
        int i = 10;
        try {

            ob1.add(i);
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
