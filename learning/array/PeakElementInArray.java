package learning.array;
/**
 * e.g (1,8,10,12,7,6,5,4) output = 12
 This will work only for distinct elements in array. Also,
 Array should be in increasing-decreasing, decreasing-increasing,
 only increasing or decreasing order.
 */
public class PeakElementInArray {
    public static void main(String[] args) {
        //int arr[] = {5, 10, 20, 25,28};
       //int arr [] = {25,20,10,5};
        //int arr [] = {5,10,15,20,25,22,21,19};
        int arr [] = {25,20,10,5,7,9,15};
        int length = arr.length;
        int low =0, high = length;
        int mid = (low + high)/2;

        while (low <= high){
           /* if (mid-1 == 0 && arr[mid-1] > arr[mid])
            {
                System.out.println(arr[0]);
                break;
            }
            else if (mid+1 > high)
            {
                System.out.println(arr[high]);
                break;
            }*/
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                System.out.println(arr[mid]);
                break;
            }
            else if (arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]) // Right part
            {
               // low = mid + 1;
                low = mid+1;
                mid = (low+high)/2;
               if (mid == high-1)
                {
                    System.out.println(arr[mid]);
                    break;
                }

            }
            else if (arr[mid] < arr[mid-1] && arr[mid] > arr[mid+1]) // left part
            {
                high = mid - 1;
                mid = (low +high)/2 ;
                if (mid == 0)
                {
                    System.out.println(arr[0]);
                    break;
                }
            }

        }
    }

}
