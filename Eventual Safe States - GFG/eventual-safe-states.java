//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean DFS(int v,List<List<Integer>>adj, boolean[]vis,boolean[]rec,boolean[]safeNode){
        vis[v]=true;
        rec[v]=true;
        
        for(int u:adj.get(v)){
            if(vis[u]==false){
                if(DFS(u,adj,vis,rec,safeNode))return true;
            }else if(rec[u]==true)return true;
            
        }
        
        safeNode[v]=true;
        rec[v]=false;
        return false;
        
        
    }   

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        
        boolean[]vis=new boolean[V];
        boolean[]rec=new boolean[V];
        boolean[]safeNode=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                DFS(i,adj,vis,rec,safeNode);
            }
        }
        
        List<Integer>ls=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(safeNode[i])ls.add(i);
        }
        
        return ls;
    }
}
