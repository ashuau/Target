package learning.array;

/**
 * To Find single duplicate element using XOR
 * The array should be in sequential order
 */
public class FindDuplicateInArray {
    public static void main(String[] args) {
        int[] a = {4,5,4,6,7};
        System.out.println(findDuplicate(a,7));
    }

    static int findDuplicate(int [] a,int range){
        int k,i,j=a[0];

        if (a[0] == a[1]){ // if first two element is same
           return a[0];
        }
        else {
            for (i = a[1]; i <= range; i++) {
                j = j ^ i;
            }
            //again doing xor operation with all elements
            for (k = 0; k < a.length; k++) {
                j = j ^ a[k];
            }

            return j;
        }
    }
}
