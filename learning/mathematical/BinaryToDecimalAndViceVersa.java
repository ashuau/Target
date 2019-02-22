package learning.mathematical;

public class BinaryToDecimalAndViceVersa {

    public static void main(String[] args) {
        int binary = 1111 ;
        int decimal = findDecimal(binary);
        System.out.println("binary to Decimal :: "+decimal);

        int deci = 10;
        int bin = findBinary(deci);
        System.out.println("decimal to binary :: "+bin);
    }

    private static int findBinary(int decimal) {

        int result = 0, k = 0;

        while (decimal > 0 ) {
            int rem = decimal % 2;
            result += rem * Math.pow(10, k++);
            decimal = decimal / 2;

        }
        return result;
    }

    private static int findDecimal(int binary) {

        int result = 0, k = 0;

        while (binary > 0 ) {

            int rem = binary % 10;

            result +=  rem * Math.pow(2,k++);
            binary = binary / 10;

        }
        return result;
    }
}
