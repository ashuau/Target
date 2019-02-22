package com.java8;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class DistinctChar{

  /*  private String name;
    private String number;

    public DistinctChar(String name, String no)
    {
        this.name = name;
        this.number = no;

    }*/

    public static Predicate<String> isPatternMatched(String prefix)
    {
       return   name -> name.startsWith(prefix);

       // return null;
    }

    public static Function<String,DistinctChar> getchars()
    {
        /*names-> names.(name -> {
            if (name.startsWith("A")){
                DistinctChar dc = new DistinctChar(name,name.chars().distinct().count());
                //System.out.println(name +" contains "+name.chars().distinct().count());
            }
        });*/

        return null;
    }
}
public class LambdaTest {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Angela", "Aaron","AAroon", "Bob", "Claire", "David","David");
      Map m =   names.stream().collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()
        ));
        System.out.println(m);
        String nm = "MMMM";
        System.out.println(nm.chars().allMatch(ch -> ch == 'M' || ch == 'N'));
      //  names.forEach(name -> System.out.println(name));
        //names.forEach( System.out::println);
      /*  names.stream().filter(name-> name.startsWith("A"))
                .forEach(name -> System.out.println(name +" has "+name.chars().distinct().count()));*/
        names.stream().filter(DistinctChar.isPatternMatched("B")).forEach(name ->
                System.out.println(name +" has "+name.chars().distinct().count()));
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        //items.forEach((K,V)-> System.out.println(K + "  "+V));

        /*Long c = names.stream()
                .filter(name -> name.startsWith("A"))
                //.collect(Collectors.toList());
                . distinct().count();*/
        //String name = "HelloaaH";
        //names.stream().filter(getchars());

        //System.out.println(count);
        String str = " I am a good good ";
        String [] arr = str.split(" ");
        System.out.println(Arrays.stream(arr).distinct().collect(Collectors.toList()));
    }
}
