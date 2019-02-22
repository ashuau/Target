import java.util.Scanner;

public class FactTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number");
        long no = sc.nextLong();
        long fact = 1;
        for (int i = 2; i <= no; i++)
        {
            fact = fact * i;
        }
        System.out.println("Factorial ::"+fact);
    }
}
