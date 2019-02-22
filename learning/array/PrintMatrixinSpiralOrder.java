package learning.array;

import java.util.BitSet;

public class PrintMatrixinSpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
       printMatrixInSpiralWay(matrix);
      /* Cake obj = new CakeDecorator() {
           @Override
           public void flavour() {
               System.out.println("annonymous flavour");
           }

           @Override
           public int getAmount() {
               return super.hashCode();
           }
       };
       obj.flavour();*/

    }
    private static void printMatrixInSpiralWay(int[][] matrix){

        int rowStart=0;
        int rowLength=matrix.length-1;

        int colStart=0;
        int colLength = matrix[0].length-1;


        while(rowStart <= rowLength && colStart <= colLength){

            for (int i = rowStart; i <= colLength; i++) {  //First row
                System.out.print(matrix[rowStart][i] + " ");
            }

            for (int j = rowStart+1; j <= rowLength; j++) {  // last column from second element
                System.out.print(matrix[j][colLength] + " ");
            }

            if(rowStart+1 <= rowLength){    // last row from second last element
                for (int k = colLength-1; k >= colStart; k--) {
                    System.out.print(matrix[rowLength][k] + " ");
                }
            }
            if(colStart+1 <= colLength){
                for (int k = rowLength-1; k > rowStart; k--) {
                    System.out.print(matrix[k][colStart] + " ");
                }
            }

            rowStart++;
            rowLength--;
            colStart++;
            colLength--;
        }
    }
}
/*
interface Cake{
    void flavour();
    int getAmount();
}
abstract class CakeDecorator implements Cake{
    private Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    public CakeDecorator() {

    }

    public void flavour() {
        cake.flavour();
    }

    public int getAmount() {
        return cake.getAmount();
    }
}
*/
