//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
          //code here
          int[][]mat=new int[n][n];
           for(int i=0;i<n;i++){
                  for(int j=0;j<n;j++){
                      if(i!=j)mat[i][j]=Integer.MAX_VALUE;
                  }
              
              
          }
          
          for(int i=0;i<m;i++){
              int u=edges[i][0];
              int v=edges[i][1];
              int w=edges[i][2];
              
              mat[u][v]=w;
              mat[v][u]=w;
              
             
              
          };
          
          for(int i=0;i<n;i++)mat[i][i]=0;
          
          for(int k=0;k<n;k++){
              for(int i=0;i<n;i++){
                  for(int j=0;j<n;j++){
                      
                       if(mat[i][k]==Integer.MAX_VALUE || mat[k][j]==Integer.MAX_VALUE)continue;
                       mat[i][j]=Math.min(mat[i][j],mat[i][k]+mat[k][j]);
                  }
              }
          }
             
        int minCount=n;
        int city=-1;
         for(int i=0;i<n;i++){
             int count=0;
              for(int j=0;j<n;j++){
                    if(mat[i][j]<=distanceThreshold)count++;
              }
              if(count<=minCount){
                city=i;
                minCount=count;
              }
          }
          
          return city;
              
          
      }
}
