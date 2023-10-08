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
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    public DisjointSet(int n){
      for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    
    public int find(int node){
         if (node == parent.get(node)) {
            return node;
        }
        int ulp = find(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void union(int u,int v){
        int ulp_u = find(u);
        int ulp_v = find(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
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
        // for (int[] row : edges) {
        //     System.out.println(Arrays.toString(row));
        // }
	    
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