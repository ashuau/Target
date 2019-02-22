package learning.mathematical;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PermutationOfGivenString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Set <String> strs = new HashSet<>();
        printPermutation(str,0,str.length()-1,strs);
        System.out.println(strs);
    }

    private static void printPermutation(String str,int startIndex,int endIndex, Set <String>strs) {
        if (startIndex == endIndex){
            System.out.print(str +"\t");
            strs.add(str);
        }
        else{
            for (int i = startIndex; i <= endIndex; i++)
            {
                str = swap(str,startIndex,i);
                printPermutation(str, startIndex+1, endIndex,strs);
              //  str = swap(str,l,i);
            }
        }

    }
    private static String swap(String str,int startindex,int index){
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[startindex] ;
        charArray[startindex] = charArray[index];
        charArray[index] = temp;
        return String.valueOf(charArray);
    }
}
