package interview.AltiMetric;

import java.util.*;

public class DistictPairInArrayThatSumtoGivenNumber {

    public static void main(String[] args) {
        DistictPairInArrayThatSumtoGivenNumber e = new DistictPairInArrayThatSumtoGivenNumber();

        int[] input = new int[]{6, 12, 3, 9, 9,3, 5, 1};
       // long sum = 12;
       /* Set <Pair> result = e.findAllPairs(input, sum);
        for (Pair p : result) {
            System.out.println("(" + p.getElement1() + "," + p.getElement2() + ")");
        }*/
     //   System.out.println(result.size());
        int k = 12;
        System.out.println("second approach :: "+SumPairs(input, k));
        int i = 0;
        for ( i = 0; i < 10; ++i) {
            System.out.println(i);
        }
        System.out.println(i);
    }

    public static int SumPairs(int[] input, int k) {

        Map<Integer, Integer> pairs = new HashMap <>();
        int tmp = 0;
        for (int data : input) {
            if (pairs.containsKey(k - data) && pairs.get(k - data) == 0) {
                tmp++;
                pairs.put((k - data), pairs.get(k - data) + 1);
                System.out.println("("+data+","+(k-data));
            }
            else if (!pairs.containsKey(data)) {
                pairs.put(data, 0);
            }
        }

        return tmp;
    }

  /* private Set <Pair> findAllPairs(int[] inputList, long sum) {

        Arrays.sort(inputList);
        Set <Integer> distinctNumbers = new HashSet <>(inputList.length);
        for (int num : inputList) {
            distinctNumbers.add(num);
        }

        Set <Integer> usedNumbers = new HashSet <>();

        Set <Pair> result = new HashSet <>();

        for (int num : inputList) {
            Long diff = sum - num;
            if (*//*diff.intValue() != num &&*//* distinctNumbers.contains(diff.intValue()) && !usedNumbers.contains(diff.intValue())) {
                usedNumbers.add(num);

                result.add(new Pair(num, diff.intValue()));
            }
        }

        return result;
    }
}

class Pair {
    private int element1;

    private int element2;


     Pair(int e1, int e2) {
        element1 = e1;
        element2 = e2;
    }

     int getElement1() {
        return element1;
    }

     long getElement2() {
        return element2;
    }

    public int hashCode() {
       // return Objects.hash(element1,element2);
        return (element1 + element2) * element2 + element1;
    }

    public boolean equals(Object other) {

        *//*return Objects.equals(this.element1,((Pair)other).element1) &&
                Objects.equals(this.element2,((Pair)other).element2)  ;*//*
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other;
            return ((this.element1 == otherPair.element1) && (this.element2 == otherPair.element2));
        }
        return false;
    }*/

}