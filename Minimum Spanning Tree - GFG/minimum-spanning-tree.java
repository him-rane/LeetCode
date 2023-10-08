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
class DisjointSet{
    int[]size;
    int[]parent;
    
    public DisjointSet(int n){
        size=new int[n+1];
        parent=new int[n+1];
        for(int i=0;i<=n;i++){
            size[i]=1;
            parent[i]=i;
        }
    }
    
    public int find(int node){
        if(node==parent[node])return node;
        return parent[node]=find(parent[node]);
    }
    
    public void union(int u,int v){
        int parU=find(u);
        int parV=find(v);
        
        if(parU==parV)return;
        
        if(size[parU]<size[parV]){
            parent[parU]=parV;
            size[parV]+=size[parU];
        }else{
            parent[parV]=parU;
            size[parU]+=size[parV];
        }
        
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    DisjointSet ds=new DisjointSet(V);
	    int sum=0;
	    
	     Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            }
        });

        // Print the sorted array
       
	    
	    for(int i=0;i<E;i++){
	       int u=edges[i][0];
	       int v=edges[i][1];
	       int w=edges[i][2];
	       
	       if(ds.find(u)!=ds.find(v)){
	           sum=sum+w;
	           ds.union(u,v);
	       }
	    }
	    
	    return sum;
	    
	    
	    
	}
}