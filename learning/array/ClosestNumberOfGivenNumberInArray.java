package learning.array;

import java.util.Arrays;

public class ClosestNumberOfGivenNumberInArray {
    public static void main(String[] args) {
        int[] array = {2,5,6,7,8,8,9};
        int no = 4;
        System.out.printf("closest number of %d :: %d ",no, findClosestForSortedArray(array,no));

       /* array = new int[]{7, 2, 6, 5, 8, 9, 8};
        no = 6;
        System.out.println("unsorted array ::"+findClosestForUnSortedArray(array,no));*/

    }

    private static int findClosestForSortedArray(int[] arr, int number) {

        int len = arr.length;
        int smallestDiff = Math.abs(number - arr[0]);
        int targetIndex = 0;
        // loop through first element
        for (int i = 1; i < len; i++) {

            if (smallestDiff > Math.abs(number - arr[i]))
            {
                smallestDiff = Math.abs(number - arr[i]);
                targetIndex = i;
            }
        }

        return arr[targetIndex];

    }

    private static int findClosestForUnSortedArray(int arr[], int number){
        Arrays.sort(arr);
        int len = arr.length;

        if (number < arr[0]) {
            return arr[0];
        }
        else if (number > arr[len - 1]) {
            return arr[len - 1];
        }

        int mid = 0;
        int start = 0;

            while (start < len) {

             mid = start + (len - start)/2;

            if (arr[mid] == number) {

                return arr[mid];

            }
            else if (number < arr[mid]) {
                if (mid > 0 && number > arr[mid - 1])
                    return getClosest(arr[mid - 1], arr[mid], number);

                len = mid -1;
            }
            else {
                if (mid < len - 1 && number < arr[mid + 1])
                   return   getClosest(arr[mid], arr[mid + 1], number);
                start = mid + 1;
            }
        }
        return arr[mid];
    }

    private static int getClosest(int val1, int val2,
                                  int target)
    {
        if (target - val1 >= val2 - target)
            return val2;
        else
            return val1;
    }
}
