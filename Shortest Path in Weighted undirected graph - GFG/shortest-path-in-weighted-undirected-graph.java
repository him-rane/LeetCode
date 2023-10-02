//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Pair{
        int dist;
        int node;
        Pair(int node,int dist){
            this.dist=dist;
            this.node=node;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        
        int[]dist=new int[n+1];
        int[]par=new int[n+1];
        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->x.dist-y.dist);
        
        for(int i=0;i<=n;i++){
            dist[i]=(int)(1e9);
            par[i]=i;
        }
        
        dist[1]=0;
        pq.add(new Pair(1,0));
        
        while(pq.size()>0){
            Pair remPair=pq.poll();
            
            int parNode=remPair.node;
            int parDist=remPair.dist;
            
            for(Pair itr:adj.get(parNode)){
                
                int chldNode=itr.node;
                int chldDist=itr.dist;
                
                if(dist[chldNode]>parDist+chldDist){
                    dist[chldNode]=parDist+chldDist;
                    pq.add(new Pair(chldNode, dist[chldNode]));
                    par[chldNode]=parNode;
                }
                
                
            }
        }
        
    
        List<Integer>path =new ArrayList<>();
        
        if(dist[n]==1e9){
            path.add(-1);
            return path;
        }
        
        int node=n;
        while(par[node]!=node){
            path.add(node);
            node=par[node];
        }
        path.add(1);
        
        Collections.reverse(path);
        return path;
        
        
        
    }
}