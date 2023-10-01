//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
   static class Pair{
        int ed;
        int wt;
        Pair(int ed, int wt){
            this.ed=ed;
            this.wt=wt;
        }
    }
    public static void dfs(int v,ArrayList<ArrayList<Pair>>adj,boolean[]vis,Stack<Integer>st){
        vis[v]=true;
        for(Pair itr:adj.get(v)){
            int u=itr.ed;
            if(vis[u]==false)dfs(u,adj,vis,st);
        }
        st.add(v);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		//Making ADJ list out of array
		ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
		for(int i=0;i<N;i++)adj.add(new ArrayList<>());
		for(int i=0;i<M;i++){
		    adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
		}
		
		//calling DFS
		boolean[]vis=new boolean[N];
		Stack<Integer>st=new Stack<>();
		for(int i=0;i<N;i++){
		    if(vis[i]==false)dfs(i,adj,vis,st);
		}
		
		//cal the sortes dist
		int[]dist=new int[N];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0]=0;
		while(st.size()>0){
		    int v=st.pop();
		    for(Pair itr:adj.get(v)){
		        int u=itr.ed;
		        int w=itr.wt;
		        
		        if(dist[v]!=Integer.MAX_VALUE)dist[u]=Math.min(dist[u],w+dist[v]);
		    }
		}
		
		for (int i = 0; i < N; i++) {
          if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
       
		
		return dist;
		
	}
}