// importing necessary class
import java.awt.Point;

 /** 
      * The class to find the peak of a 2D array.
 */

public class PeakFinder
{  
   /** 
      * This method finds the global maximum in a colummn...

      * @param [][]array The array.
      * @param mid the middle index or the middle column of the array.
      * @return maxPoint The location of the global maximum.
   */
   public Point maximum(int [][]array,int mid)
   {  
      Point maxPoint = new Point();
      int max = array[0][mid];
     for (int i = 1; i < array.length; i++) 
        { 
            if (max < array[i][mid]) 
            { 
                  
                // Saving global maximum and its index 
                // to check its neighbours 
                max = array[i][mid]; 
                maxPoint.setLocation(i,mid); 
            } 
        } 
        return maxPoint; 
    
      }
   
    /** 
      * This method prints the array in an attractive format.
      * @param array The array to be printed. 
   */
   public void displayMatrix(int [][] array)
   {
      System.out.println("+----+----+----+----+----+----+----+----+----+----+");
      for(int i=0; i<=9; i++)
      {
         for(int j=0;j<=9;j++)
         {
            if (j == 0)
            {
               System.out.print("| ");
            }
            System.out.printf("%2d | ",array[i][j],i); 
            if (j == 9)
             {
               System.out.print(i);
             }
         }
         
         System.out.println();
         System.out.println("+----+----+----+----+----+----+----+----+----+----+");
         
      }
      System.out.println("  0     1    2    3    4    5    6    7    8    9  \n");
   
   }
   
   
    /** 
      * This method finds the location of a peak element.
      * @param The array for wich the peak is required.
      * @return The location of a peak elemnt(or -1 if there is no peak element.)   
   */

   public String location(int[][] array)
   {
      int high = array[0].length-1;
      int low = 0;
      int mid = 0;;
      int row = 0;
      
      while(low<=high)
      {  
         mid = (low+high)/2;
         row =(int)(maximum(array,mid).getX());
         if(array[row][mid-1]>array[row][mid])
         {
            high = mid-1;
         }
         else if(array[row][mid+1]>array[row][mid])
         {
            low = mid+1;
         }
         else
         {
            return(row+" "+mid);
         }
        
         
      }
      return "-1";
      
   }
}