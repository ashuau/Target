package com.java8;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicatesFromListHorizontallyAndVerticallyInHashMap {
    public static void main(String[] args) {
        Map <String,List<Integer>> map = new LinkedHashMap <>();

        List <Integer> data = new CopyOnWriteArrayList <>();
        data.add(1);data.add(2);data.add(3);data.add(2);

        map.put("hello",data);
        data = new CopyOnWriteArrayList <>();
        data.add(3);data.add(2);data.add(5);data.add(3);
        map.put("world",data);

        data = new CopyOnWriteArrayList <>();
        data.add(3);data.add(2);data.add(5);data.add(7);
        map.put("india",data);


        System.out.println(map);
        Set<Integer> set = new LinkedHashSet <>();
      /*map =   map.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(),e->e.getValue().stream()

              .distinct()

                .collect(Collectors.toList())));
        System.out.println(map);*/
        Collection <List<Integer>> test = map.values();

      /*  BooleanTypeOnBiwiseOperator.forEach(list -> list.forEach(v -> {

            if (set.contains(v)) {

                list.remove(v);
            }
            else {
                set.add(v);
            }
        }));*/

/*
BooleanTypeOnBiwiseOperator.forEach(list -> list.forEach(v -> {

    if (set.contains(v))
        list.removeIf(v -> set.contains(v));
    else
        set.add(v);
}));
*/



        /*Set<Integer> nameCache = new HashSet<>();

        Collection <List<Integer>> BooleanTypeOnBiwiseOperator = map.values();

        for (List<Integer> list : BooleanTypeOnBiwiseOperator) {
            for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
                int element = it.next();
                if (nameCache.contains(element)) {
                    it.remove();
                } else {
                    nameCache.add(element);
                }
            }
        }*/

        System.out.println(map);

    }



}
