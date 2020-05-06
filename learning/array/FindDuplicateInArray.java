package learning.array;

/**
 * To Find single duplicate element using XOR
 * The array should be in sequential order<br>
 *
 * XOR x with itself even number of times<br>
 * x ^ x = 0<br>
 * x ^ x ^ x ^ x = (x ^ x) ^ (x ^ x) = 0 ^ 0 = 0<br>
 *  <br>
 *  <br>
 * XOR x with itself odd number of times<br>
 * (x ^ x ^ x) = (x ^ (x ^ x)) = (x ^ 0) = x<br>
 * (x ^ x ^ x ^ x ^ x) = (x ^ (x ^ x) ^ (x ^ x)) = (x ^ 0 ^ 0) = x
 */
public class FindDuplicateInArray {
    public static void main(String[] args) {
        int[] a = {4,5,4,6,7,8};
        System.out.println(findDuplicate(a,8));
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
            System.out.println("j :: "+j);
            //again doing xor operation with all elements to find the duplicate
            for (k = 0; k < a.length; k++) {
                j = j ^ a[k];
            }

            return j;
        }
    }
}
