package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList <>();

        System.out.println(Optional.ofNullable(list)); // prints Optional[[]]
        Optional.ofNullable(list).ifPresent(l -> l.add("hello")); // will add "hello to list
        Optional.ofNullable(list).ifPresent(System.out::println);
        System.out.println(list);

      /*  list = null;

     list =   Optional.ofNullable(list).orElse(new ArrayList <>());
     list.add("Hello");
        System.out.println(list);*/

      String str = "null";

      //  System.out.println(Optional.of(null));
    }
}
