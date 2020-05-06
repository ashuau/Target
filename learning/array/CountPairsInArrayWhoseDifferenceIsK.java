package learning.array;

import java.util.*;

public class CountPairsInArrayWhoseDifferenceIsK {

        // Complete the pairs function below.
           static int pairs(int target, int[] arr) {
            int count = 0;

            Arrays.sort(arr);

               int i = 0;
               int startIndex = 0;
            while(startIndex < arr.length)
            {
                if(arr[startIndex] - arr[i] == target) // if found increment start index and i since next elements will
                                                       // be greater than
                {
                    count++;
                    i++;
                    startIndex++;
                }
                else if(arr[startIndex] - arr[i] > target) // following the start index
                    i++;
                else
                    startIndex++; // else moving forward with start index
            }
            return count;

        }

        public static void main(String[] args) {
            int k = 2;

            int[] arr = {1,4,8,10,10};

            int result = pairs(k, arr);

            System.out.println("result:: "+result);

           }
}


