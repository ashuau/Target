package learning.mathematical;

import java.util.*;


public class FindMaxAndMinFromGivenNumber{

    public static void main(String []args){

        int n = 1000;

        List <String> numbers = new ArrayList <>();

        String str = String.valueOf(n);

        int start = 0;
        int end = str.length() -1;

        findPermutation(str,start,end,numbers);

        // numbers.stream().forEach(System.out::println);

        /*int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
*/
       /* for (String number : numbers) {

            int num = Integer.parseInt(number);

            if (num > maximum) {

                maximum = num;
            }
            if (num < minimum) {
                minimum = num;
            }

        }*/

      Optional max =  numbers.stream().max(Comparator.naturalOrder());
        System.out.println(max.get());

        Optional <String> min = numbers.stream().min(Comparator.naturalOrder());
        System.out.println(min.get());
     //   System.out.println("max ::"+maximum+"\t min:: "+minimum);

        // Another Approach

        /**
         * As number is long, store the number as string, sort the string after converting it to char array if there is no
         * leading zero, return this string,
         * if there is any leading zero, swap first element of string with first non-zero element of string,
         * and return the string.
         */

    }


    private static void  findPermutation(String str, int start, int end, List <String> numbers) {

        if (start == end) {

            numbers.add(str);
        }

        else {

            for (int i = start; i <= end; i++) {

                // char c = str.charAt(i);
                str = swap(str, start, i);

                findPermutation(str, start+1, end, numbers);
            }
        }

    }

    private static  String swap(String str, int start, int index) {

        char temp;

        char [] charArray = str.toCharArray();

        temp = charArray[start];
        charArray[start] = charArray[index];
        charArray[index] = temp;
        return String.valueOf(charArray);
    }


}
