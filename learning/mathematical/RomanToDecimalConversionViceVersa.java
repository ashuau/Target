package learning.mathematical;

public class RomanToDecimalConversionViceVersa {

   int Val(char c)
   {
       switch (c)
       {
           case 'I':
               return  1;
           case 'V':
               return  5;
           case 'L':
               return 50;
           case 'C':
               return 100;
           case 'D':
               return 500;
           case 'M':
               return 1000;
       }
       return  -1;
   }

    int getDecimal(String str)
    {
        int result = 0;
        for (int i = 0; i < str.length(); i++)
        {
            int a = Val(str.charAt(i));
            if (i+1 < str.length())
            {
                int b = Val(str.charAt(i+1));
                if (a >= b)
                {
                    result = result + a;
                }
                else
                {
                    result = result + b -a;
                    i++;
                }

            }
            else{
                result = result + a;
            }

        }
        return result;
    }
    public static void main(String[] args) {
        RomanToDecimalConversionViceVersa object = new RomanToDecimalConversionViceVersa();
        String str = "CDV";
        System.out.println("Decimal number :: "+object.getDecimal(str));
        int number = 3549;
        System.out.println(decimalToRoman(number));
    }

    // Function to calculate roman equivalent
    static String decimalToRoman(int num) // to 3999 upper limit
    {
        // storing roman values of digits from 0-9
        // when placed at different places
        String m[] = {"", "M", "MM", "MMM"};
        String c[] = {"", "C", "CC", "CCC", "CD", "D",
                "DC", "DCC", "DCCC", "CM"};
        String x[] = {"", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX", "LXXX", "XC"};
        String i[] = {"", "I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX"};

        // Converting to roman
        String thousands = m[num/1000];
        String hundreds = c[(num%1000)/100];
        String tens = x[(num%100)/10];
        String ones = i[num%10];

        String ans = thousands + hundreds + tens + ones;

        return ans;
    }



}

