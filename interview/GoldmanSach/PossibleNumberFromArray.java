package interview.GoldmanSach;
import java.util.*;
public class PossibleNumberFromArray {

    static String findOutPossibleNumbersFromArray(int [] numberArray)
    {
        int len = numberArray.length;
        String [] str = new String[len];
        List <String> res = new ArrayList<>();

        for (int i =0; i<len;i++)
        {
            str[i] = String.valueOf(numberArray[i]);
            if (str[i].contains("1") && str[i].contains("2") && str[i].contains("3"))
            {
                res.add(str[i]);
            }
        }
        if (res.size() == 0)
        {
            return "-1";
        }
        Integer [] a = new Integer[res.size()];
        int i =0;
        List <Integer> l = new ArrayList <>();
        while (i < res.size())
        {
            l.add(Integer.parseInt(res.get(i)));
            i++;
        }
        Collections.sort(l);
        int size = res.size();
        String resS = "";
        for ( i = 0;i<size;i++)
        {

            resS = resS + l.get(i);
            if (i+1 != size)
            {
                resS = resS + ",";
            }

        }
        return resS;
    }
    public static void main(String[] args) {
        int number [] = {123321123,1234,5678,4132};
        System.out.println(findOutPossibleNumbersFromArray(number));
      /*  String str1 = "123321123";
        String str2 = "1234";
        List <String> list = new ArrayList();
        list.add(str1);
        list.add(str2);
        Integer [] a = new Integer[list.size()];

       // list.clear();
         int s = a.length;
         int i =0;
         List <Integer> l = new ArrayList <>();
         while (i < s)
        {
            l.add(Integer.parseInt(list.get(i)));
            i++;

        }
        Collections.sort(l);
        System.out.println(l);*/

    }
}
