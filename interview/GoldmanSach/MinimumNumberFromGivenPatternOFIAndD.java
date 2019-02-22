package interview.GoldmanSach;

import java.util.Stack;

public class MinimumNumberFromGivenPatternOFIAndD {

    public static void main(String[] args) {

        PrintMinNumberForPattern("DDI");
    }

   static void PrintMinNumberForPattern(String seq)
    {
        String result="";
        Stack<Integer> stk = new Stack();
        for (int i = 0; i <= seq.length(); i++)
        {
            stk.push(i + 1);

            if (i == seq.length() || seq.charAt(i) == 'I')
            {
                while (!stk.empty())
                {
                    result +=  String.valueOf(stk.pop());
                }
            }
        }
        System.out.println(result);
    }
}
