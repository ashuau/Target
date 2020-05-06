package learning.mathematical;

public class GCDOFMultipleNumbers {

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    // it can be reversed as follows

        // Function to return gcd of a and b
       /* static int gcd(int b, int a)
        {
            if (b == 0)
                return a;
            return gcd(a % b, b);
        }*/

        // Function to find gcd of array of
        // numbers
        static int findGCD(int[] arr, int n)
        {
            int result = arr[0];
            for (int i = 1; i < n; i++)
                result = gcd(arr[i], result);

            return result;
        }

        public static void main(String[] args)
        {
            int[] arr = { 84,120,90 };
            int n = arr.length;
            System.out.println(findGCD(arr, n));
        }
    }

