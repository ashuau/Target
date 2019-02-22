package learning.mathematical;

public class PowerOfGivenNumberWithoutFunction {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
      double power =  calculatePow(a,b);
        System.out.println("result :: "+power);
    }

    private static double calculatePow(int a, int b){
        if (a == 0 ){
            return 0;
        }
        double result = 1;
        boolean isNegative = false;
        if (b < 0)
        {
            b = -b;
            isNegative = true;
        }
        for (int i =0; i < b; i++){
            result = result * a;
        }
        if (isNegative)
        {
            return 1/result;
        }
        return result;

    }

}
