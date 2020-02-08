import java.util.*;

 /** 
      * This class helps to test the peak finder class by creating array of dimension 10X10 having random elements.
 */

public class PeakFinderTester

{
    /** 
      * Entry point of the algorithm.
    */

   public static void main(String args[])
   {  
      Random rand = new Random();
      int [][] matrix = new int[10][10];
      int x = 5;
      for(int i=0; i<=9; i++)
      {  
         
         for(int j=0;j<=9;j++)
         {
            matrix[i][j] = rand.nextInt(x);
            x = x+1; 
         }
      }
      matrix[9][6]=99;
      
      PeakFinder array1 = new PeakFinder();
      
      array1.displayMatrix(matrix);
      
      
      
      System.out.println(array1.location(matrix));
      
      
   }
   
}