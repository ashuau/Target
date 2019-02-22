package learning.mathematical;

public class LCMOFMultipleNumbers {
    // function to find GCD of 'x' and 'y'
    int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }
        return gcd(y % x, x);
    }

    // Returns LCM of array elements
    int lcm(int arr[], int n) {
        int ans = arr[0];

        for (int i = 1; i < n; i++) {
            ans = (arr[i] * ans) / gcd(arr[i], ans);
        }

        return ans;
    }
    //driver method
    public static void main(String[] args) {
        LCMOFMultipleNumbers t1 = new LCMOFMultipleNumbers();
        int a[] = {1, 5, 4, 8};
        System.out.println("LCM is " + t1.lcm(a, a.length));
        long start = System.nanoTime();
        int b[] = {3, 5, 7, 9, 34, 12};
        System.out.println("LCM is:" + t1.lcm(b, b.length));
        double timeElapsed = (System.nanoTime() - start) / 1000000.0;
        System.out.println("time Elapsed ::"+timeElapsed);
    }
}
