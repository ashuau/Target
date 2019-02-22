import java.util.AbstractList;
import java.util.ArrayList;

public class MaxSumTestInArray {

    private static int FindMaxSumInArray(int [] arr, int size)
    {
        /*int sumofOdd = 0, sumofEven = 0, sumOFFirstAndLastElement = arr[0] + arr[size -1];

        for (int i = 0; i < size; i++)
        {
            if (i%2 == 0) {
                sumofOdd = sumofOdd + arr[i];
            }
            else{
                    sumofEven = sumofEven + arr[i];
                }
        }


        if (sumofEven > sumofOdd && sumofEven > sumOFFirstAndLastElement)
        {
            return sumofEven;
        }
        else if (sumofOdd > sumofEven && sumofOdd > sumOFFirstAndLastElement)
        {
            return  sumofOdd;
        }
        else
        {
            return sumOFFirstAndLastElement;
        }*/

        // Best Solution cover all cases
        /*int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < size; i++)
        {
            *//* current max excluding i *//*
            excl_new = (incl > excl) ? incl : excl;

            *//* current max including i *//*
            incl = excl + arr[i];
            excl = excl_new;
        }

        *//* return max of incl and excl *//*
        return ((incl > excl) ? incl : excl);*/


        int dp[] =  new int [size];
        dp[0] = arr[0];
        dp[1] = arr[1];
        dp[2] = arr[0]+arr[2];
        for (int i = 3 ; i < size ; i++) {
            dp[i] = arr[i]+ dp[i-2] > dp[i-3] ? dp[i-2] : dp[i-3];
        }
        int maxi = Integer.MIN_VALUE;
        for (int  i = 0 ; i < size ; i++) {
            maxi = maxi > dp[i] ? maxi : dp[i];
        }
        return maxi;
    }
    public static void main(String [] arg)
    {
        int arr[] = new int[]{30,3,2,10,7};
        System.out.println(FindMaxSumInArray(arr, arr.length));

    }


}
