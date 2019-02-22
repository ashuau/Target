package learning.array;

import java.util.Arrays;

public class FindSecondSmallestInArray {

    public static void main(String[] args) {

        int [] arr = {50,5,10,3,2,1,6,1};

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;


        for (int i : arr) {

            if (i < first) {

                second = first;
                first = i;
            }
            else if (i < second && i != first) { // second condition for duplicate elements
                second = i;
            }

        }
        System.out.println(first +"\t"+second);

      // java8 way

       /*int small =  Arrays.stream(arr).min().getAsInt();

        System.out.println(Arrays.stream(arr).filter(e -> e > small).findFirst().orElse(-1));*/
    }
}
