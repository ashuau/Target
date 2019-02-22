package com.java8;
import java.util.*;
import java.util.stream.IntStream;



public class PrintRepeatedNumbersForGivenPattern {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an Input");

        String input = "0 FOR 5 1 2";

        input = input.replaceAll(" FOR ", "_times_");
        System.out.println(input);

        List<String> result = new ArrayList<>();
        Arrays.stream(input.split(" ")).forEach(str -> {
            if (!str.contains("times")) {
                result.add(str);
            }
            else {
                String[] pattern = str.split("_times_");
                IntStream.range(0, Integer.parseInt(pattern[1])).forEach(element -> result.add(pattern[0]));
            }
        });
        System.out.println(result);


    }
}

