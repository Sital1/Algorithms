import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DPKnapsack
{
   List <String> items = new ArrayList<String>();
   List <Integer> weight = new ArrayList<>();
   List <Integer> value = new ArrayList<>();
   private int count;
    private int maxCapacity;
   private int[][] P;
   private int[][] T;
   List <String> solutionList = new ArrayList<String>();
   List <String> solutionList1 = new ArrayList<String>();
   
   
   public DPKnapsack(int capacity, String itemFile) 
   {
     maxCapacity = capacity;
     items.add("");
     weight.add(0);
     value.add(0);

    try
     {
         File inFile = new File(itemFile);
         Scanner in = new Scanner(inFile);
         while(in.hasNextLine())
         {
            Scanner line = new Scanner(in.nextLine());
             while(line.hasNext())
             {
                items.add(line.next());
                weight.add(Integer.parseInt(line.next()));
                value.add(Integer.parseInt(line.next()));
             }
         }
         count = items.size();
         in.close();
     }
     
     catch(FileNotFoundException e)
   {
          System.out.println("File not found");
         
       }

    }

    public void optimalValue(int maxWeight)
    {
        
        P = new int[count+1][maxWeight + 1];
        // boolean[][] keep = new boolean[count][maxWeight];
        T = new int[count+1][maxWeight + 1];
        for(int m = 0; m <= maxWeight; m++)
        {
            P[0][m] =  0;          
        }

        for(int m = 0;m < count; m++)
        {
            P[m][0] = 0;
        }

        for (int i = 1; i < count; i++)
        {
            for(int j = 1; j <= maxWeight; j++)
            {
                if(weight.get(i) > j)
                {
                    P[i][j] = P[i-1][j];
                }

                else
                {
                    if (P[i-1][j] > value.get(i) + P[i-1][j - weight.get(i)])
                    {
                        P[i][j] = P[i-1][j];
                    }

                    else
                    {
                        P[i][j] = value.get(i) + P[i-1][j - weight.get(i)];
                        T[i][j] = 1;    
                        
                    }
                    
                }
                // System.out.print(P[i][j] + " ");
            }
            // System.out.println();

            
        }

    }

   

    public int optimalWeight(int maxWeight)
    {
        optimalValue(maxWeight);
        int optimalWeight = 0;
        int k = maxWeight;
        for(int i = count; i >= 1; i--)
        {
            if(T[i][k] == 1)
            {
                optimalWeight += weight.get(i);
                solutionList.add(items.get(i));
                k = k - weight.get(i);
                

            }
        }

        return optimalWeight;

    }

    public String solution(int maxWeight)
    {
        
        String solution = "";
        for(int i = 0; i < solutionList.size(); i++)
        {
            solution += solutionList.get(i) + " ";
        }

        return solution;
    }

    public boolean contains(String item, int maxWeight)
    {
        // optimalValue(maxWeight);
        if(solutionList.contains(item))
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public int optimalNumber(int maxWeight)
    {
        return solutionList.size();
    }

  

    public int optimalNumber()
    {
        return solutionList1.size();
    }

    public int optimalWeight()
    {
        optimalValue(maxCapacity);
        int optimalWeight = 0;
        int k = maxCapacity;
        for(int i = count; i >= 1; i--)
        {
            if(T[i][k] == 1)
            {
                optimalWeight += weight.get(i);
                solutionList1.add(items.get(i));
                k = k - weight.get(i);
                

            }
        }

        return optimalWeight;

    }
    public boolean contains(String item)
    {
        if(solutionList1.contains(item))
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public String solution()
    {
        String solution = "";
        for(int i = 0; i < solutionList1.size(); i++)
        {
            solution += solutionList1.get(i) + " ";
        }

        return solution;
    }

    

    

}



