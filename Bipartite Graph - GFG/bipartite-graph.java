//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends




class Solution
{
   public static boolean dfs(int v,ArrayList<ArrayList<Integer>>adj,int[]col){
        
        
        for(int u:adj.get(v)){
            if(col[u]==-1){
                col[u]=col[v]==0?1:0;
                 if(dfs(u,adj,col)==false)return false;
            }else{
                if(col[u]==col[v])return false;
            }
        }
        return true;
        
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[]col=new int[V];
        Arrays.fill(col,-1);
        for(int i=0;i<V;i++){
           
            if(col[i]==-1){ 
                
                col[i]=0;
                if(!dfs(i,adj,col))return false;
                
                }
            }
        
        return true;
}
}