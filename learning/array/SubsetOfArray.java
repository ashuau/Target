package learning.array;

public class SubsetOfArray {
    static int count = 0;
    public static void main(String[] args) {
       

        int [] a = {1, 2, 3};
       /* Output: Possible sub sequences –
        {Empty}, {1}, {2}, {3}, {1, 2} ,{1,3}, {2, 3}, {1, 2, 3}*/
       int [] temp = new int[a.length];
        int index = 0;
        printsubSequence(a,index,temp);
        System.out.println("count ::"+count);
    }

    private static void printsubSequence(int[] a,int index,int[] temp) {
        if (index == a.length)
        {
            print(a,temp);
            count++;
            return;
        }
        temp[index] = 1;
        printsubSequence(a,index+1,temp);
        temp[index] = 0;
        printsubSequence(a,index+1,temp);
    }

    private static void print(int a[], int [] temp){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <temp.length ; i++) {
            if(temp[i]==1)
                result.append(a[i]).append(" ");
        }
        if(result.toString().equals(""))
            result = new StringBuilder("{}");
        System.out.println(result);
    }
}
