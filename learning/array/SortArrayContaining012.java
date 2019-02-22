package learning.array;

public class SortArrayContaining012 {
    public static void main(String[] args) {
        int arr [] = {1,0,2,2,0,1,2,0};
        sort012(arr);
        for (int a : arr)
        {
            System.out.print(a);
        }
    }

    private static void sort012(int[] arr) {

        int high = arr.length -1;
        int start = 0;
        int temp = 0;
        int low = 0;
            while (start <= high) {
                switch (arr[start]) {
                    case 0:
                        temp = arr[low];
                        arr[low] = 0;
                        arr[start] = temp;
                        low++;
                        start++;
                        break;
                    case 1:
                        start++;
                        break;
                    case 2:
                        temp = arr[high];
                        arr[high] = 2;
                        arr[start] = temp;
                        high--;
                        break;

                }
            }

    }
}
