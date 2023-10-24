//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int mat[][], int n, int m) {
        // code here
        int maxOnes=-1,row=-1;

        for(int i=0;i<n;i++){
            
            int left=0,right=m-1;
            
            while(left<=right){
                
                int mid=(left+right)/2;
    
                if(mat[i][mid]==1){
                    if(m-mid>maxOnes){
                        maxOnes=m-mid;
                        row=i;
                    }
                   right=mid-1;
                }else left=mid+1;
                
            }

        }
        
        return row;
    }
}