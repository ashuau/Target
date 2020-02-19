package learning.array;

public class MaxSumContiguousSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 2, -1, -2, 1, 5, -1,19,20,21};
        int length = arr.length;

        int max_so_far = 0,max_ending_here = 0;
        int startIndex = -1, endIndex = -1,s = 0;

        // Kadane Algorithm

        for (int i = 0; i< length; i++)
        {
            max_ending_here = max_ending_here + arr[i];
            if (max_so_far < max_ending_here)
            {
                max_so_far = max_ending_here;
                startIndex = s;
                endIndex = i;
            }
            else if (max_ending_here < 0 )
            {
                //negativeFound = true;
                max_ending_here = 0;
                s = i + 1;
            }
        }
        System.out.println("max :: "+max_so_far);
        System.out.println("startIndex :: "+startIndex+"\t endIndex :: "+endIndex);
    }
}
