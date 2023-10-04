//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static class Pair{
        int node;
        int dist;
     
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    
	    ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
	  
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int i=0;i<E;i++){
	        int u=edges[i][0];
	        int v=edges[i][1];
	        int w=edges[i][2];
	        adj.get(u).add(new Pair(v,w));
	        adj.get(v).add(new Pair(u,w));
	    }
	    
	    PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->x.dist-y.dist);
	    boolean[]vis=new boolean[V];
	    
	    pq.add(new Pair(0,0));
	    int sum=0;
	    
	    
	    while(pq.size()>0){
	        Pair remPair=pq.poll();
	        
	        int parNode=remPair.node;
	        int parDist=remPair.dist;
	        
	        if(vis[parNode]==true)continue;
	        
	        vis[parNode]=true;
	        sum+=parDist;
	        
	        for(Pair itr:adj.get(parNode)){
	            int adjNode=itr.node;
	            int adjDist=itr.dist;
	            
	            if(vis[adjNode]==false)pq.add(new Pair(adjNode,adjDist));
	        }
	        
	    }
	    
	    return sum;
	    
	    
	 
	    
	}
	
	
	
	
	
	
	
	
}