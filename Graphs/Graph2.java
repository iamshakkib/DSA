import java.lang.*;
import java.io.*;
import java.util.*;
class Graph2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            //ArrayList<Integer>ans = bfs(adj,V,2);
            //for (int i =0 ;i < ans.size (); i++) 
              //  System.out.print (ans.get (i) + " ");
            //System.out.println();
            //System.out.println(isCycle(adj,V)==true ? "True" : "No");
            //boolean[] visited = new boolean[V];
            //dfs(adj,V,2,visited);
            System.out.println(checkForCycle(adj,V) == true ? "True" : "False");
        }
    }

    public static ArrayList<Integer> bfsOfGraph(int V, int node, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> bfs = new ArrayList<>(); 
        boolean vis[] = new boolean[V]; 
        Queue<Integer> q = new LinkedList<>();
        
        q.add(node); 
        vis[node] = true; 
        
        while (!q.isEmpty())
        {
            node = q.poll();
            bfs.add(node); 
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for(Integer it: adj.get(node)) {
                if(vis[it] == false) {
                    vis[it] = true; 
                    q.add(it); 
                } 
            }
        }   
        return bfs;         
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int V, int node, boolean[] visited){
        visited[node] = true;
        System.out.println(node + " ");
        for(int it : adj.get(node)){
            if(!visited[it]){
                visited[it]=true;
                dfs(adj,V,it, visited);
            }
        }
    }

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int V, int node){
       ArrayList<Integer> arr = new ArrayList<>();
       boolean[] visited = new boolean[V];
       Queue<Integer> q = new LinkedList<>();

       q.add(node);
       visited[node] = true;
       while(!q.isEmpty()){
        node = q.poll();
        arr.add(node);
        for(int it : adj.get(node)){
            if(visited[it]==false){
                q.add(it);
                visited[it] = true;
            }
        }
    }
        return arr;
    }

    public static boolean dfsForCycle(ArrayList<ArrayList<Integer>> adj, int node, int par, boolean[] vis){
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                if(dfsForCycle(adj, it, node, vis)) return true;
            } else if(it != par){
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int V){
        boolean[] vis = new boolean[V+1];
        Arrays.fill(vis,false);
        for(int i=1;i<=V;i++){
            if(dfsForCycle(adj,i,-1,vis))
                return true;
        }
        return false;
    }

    public static boolean bfsForCycle(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited){
        ArrayDeque<Pair> dq = new ArrayDeque<>();
        dq.offer(new Pair(node,-1));
        visited[node] = true;
        int node1 = 0;
        int par;
        while(!dq.isEmpty()){
            node = dq.peek().first;
            par = dq.peek().second;
            dq.poll();
            for(int it : adj.get(node1)){
                if(visited[it]==false){
                    dq.offer(new Pair(it,node1));
                    visited[it] = true;
                }
                else if(it != par) return true;
            }
        }
        return false;
    }

    public static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int V){
        boolean visited[] = new boolean[V];
        Arrays.fill(visited,false);
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(bfsForCycle(adj, i, visited))
                    return true;
            }
        }
        return false;
    }
}

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}



/* 0---->1
   ||   /| 
   || /  |/\
    2---->3-

    4 6
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
*/