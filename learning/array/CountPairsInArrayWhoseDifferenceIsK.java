package learning.array;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class CountPairsInArrayWhoseDifferenceIsK {

        // Complete the pairs function below.
           static int pairs(int target, int[] arr) {
           long startTime =  System.nanoTime();
            System.out.println("start time ::"+startTime);
            int count = 0;
          /* List items = Arrays.stream(arr).boxed().collect(Collectors.toList());
            System.out.println(items);*/

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

            long endTime = System.nanoTime();
            System.out.println("end time ::"+endTime);
            long diff = endTime - startTime;
            System.out.println("time ::"+diff/1000000.0);
            return count;

        }

        public static void main(String[] args) {
            int k = 2;

            int[] arr = {1,4,8,10,12};

            int result = pairs(k, arr);

            System.out.println("result:: "+result);

        }
}


