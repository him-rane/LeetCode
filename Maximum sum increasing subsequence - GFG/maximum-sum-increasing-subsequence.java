//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int f(int[]arr,int n,int prev,int[][]dp){
        if(n==0)return 0;
        
         if(prev!=-1 && dp[n][prev]!=-1) return  dp[n][prev];
         
        int notTake=f(arr,n-1,prev,dp);
        int take=0;
        if(prev==-1 || arr[prev]>arr[n-1]){
            take=arr[n-1]+f(arr,n-1,n-1,dp);
        }
        
        if(prev!=-1)dp[n][prev]=Math.max(take,notTake);
        
        return Math.max(take,notTake);
    }
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int[][]dp=new int[n+1][n+1];
	    for(int i=0;i<n+1;i++){
	        for(int j=0;j<n+1;j++){
	            dp[i][j]=-1;
	        }
	    }
	    return f(arr,n,-1,dp);
	}  
}