// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Knapsack
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(knapSack(w, wt, val, n));
        }
    }




// } Driver Code Ends




    static int [][]dp = new int[1005][1005];
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int indx = 0;
         for(int i=0;i<1001;i++){
             for(int j=0;j<1001;j++){
                 dp[i][j] = -1;
             }
         }
         int temp = f(W,wt,val,n,indx);
         return temp;
    } 
    static int f(int W, int wt[], int val[], int n,int indx){
        if(indx==n)
        return 0;
        if(dp[indx][W]!=-1) return dp[indx][W];
        int steal = Integer.MIN_VALUE;
        int not_steal = Integer.MIN_VALUE;
        if(wt[indx]<=W){
           return dp[indx][W]=Math.max(val[indx]+f(W-wt[indx],wt,val,n,indx+1),f(W,wt,val,n,indx+1));
        }
        else return dp[indx][W]=f(W,wt,val,n,indx+1);
    }
}



