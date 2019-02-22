package interview.Pramati;

import java.util.*;

public class TreeMapQuestion {
    public static void main(String[] args) {

        List <String> list = new ArrayList <>();
        list.add("Laddu");
        list.add("Jalebi");list.add("Gulab-Jamun");list.add("Gulab-Jamun");list.add("Gajar-Halwa");
        list.add("Gajar-Halwa");
        Map<String, Integer> map = new TreeMap <>(Collections.reverseOrder());

        for (String s : list) {

            if (map.containsKey(s)){
                int val = map.get(s);
                map.put(s, ++val);

            }
            else {
                map.put(s,1);
            }
        }
        Set set = map.entrySet();
        Iterator i = set.iterator();

        // Traverse map and print elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        /*Collection <Integer> values = map.values();

        Iterator <String> itr = map.keySet().iterator();*/
        int max = 0; String result = null;

        LinkedList <Map.Entry<String,Integer>> llist = new LinkedList <>(map.entrySet());
        // if two sweets have same vote count then select the sweets that come in last (Alphabetic order)
       for (Map.Entry<String,Integer> entry : llist){

           /* String s = itr.next();
            int temp = map.get(s);*/

            if (entry.getValue() > max){
                max = entry.getValue();
                result = entry.getKey();

            }
           /* else if (temp == max) {
                result = s;
            }
*/
        }

        System.out.println("result ::"+result);
    }
}
