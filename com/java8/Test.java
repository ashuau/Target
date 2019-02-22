package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

interface Gorilla {

    String move();
}
class GorillaFamily {
    String walk = "walk";

    void everyonePlay(boolean baby) {
        String approach = "amble";
        //approach = "run";
        walk = "moving on";
        play(() -> walk);
        play(() -> baby ? "hitch a ride": "run");
        play(() -> approach);
    }

    void play(Gorilla g) {
        System.out.println(g.move());
    }

}


public class Test {
    public static void main(String[] args) {
        GorillaFamily gf = new GorillaFamily();
        gf.everyonePlay(true);

        Gorilla helloworld = () -> "Hello world";

        System.out.println(helloworld.move());
        System.out.println();

      /*  Thread t1 = new Thread(() -> {

                System.out.println(Thread.currentThread().getName());
                System.out.println("Hello from runnable");
            }
        );

        t1.run();*/

        Arrays.stream(new int[] { 1,2,3,4}).map(n -> 3*n+1)
                .filter(i -> i > 10).average().ifPresent(System.out::println);

    }

}



