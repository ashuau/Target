package com.java8;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class AggregateFunctionUsage {

    public static void main(String[] args) {

       IntStream avg =  Arrays.stream(new int[]{1,2,3,4,5}).map(n -> 3*n+1).filter(i -> i > 10); //.average()

        int [] arr = avg.toArray();
      // avg.ifPresent(System.out::println);
       // System.out.println(avg.orElse(0));
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
