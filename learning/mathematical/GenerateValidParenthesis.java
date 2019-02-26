package learning.mathematical;


public class GenerateValidParenthesis {
    public static void main(String[] args) {
        int n = 2;
      //  printParentheses(n);
        generate(n,n,"");
    }

        public static void generate(int openP, int closeP, String string) {
            if (openP == 0 && closeP == 0) // mean all opening and closing in
                // string,
                // print it
                System.out.println(string);
            if (openP > closeP) // means closing parentheses is more than open ones
                return;
            if (openP > 0)
                generate(openP - 1, closeP, string + "("); // put ( and
            // reduce
            // the count by
            // 1
            if (closeP > 0)
                generate(openP, closeP - 1, string + ")"); // put ) and
            // reduce
            // the count by
            // 1
        }

       // public static void printParentheses(int n) {
          //  generate(n , n, "");
      //  }

    // Another way to get
    /*
    static void _printParenthesis(char str[], int pos, int n, int open, int close)
    {
        if(close == n)
        {
            // print the possible combinations
            for(int i=0;i<str.length;i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        }
        else
        {
            if(open > close) {
                str[pos] = '}';
                _printParenthesis(str, pos+1, n, open, close+1);
            }
            if(open < n) {
                str[pos] = '{';
                _printParenthesis(str, pos+1, n, open+1, close);
            }
        }
    }

    // Wrapper over _printParenthesis()
    static void printParenthesis(char str[], int n)
    {
        if(n > 0)
        _printParenthesis(str, 0, n, 0, 0);
        return;
    }
     */

}
