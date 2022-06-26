import java.util.*;
import java.io.*;
import java.lang.*;

class CycleDetectDG{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			String[] s = br.readLine().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
			for(int i=0;i<V;i++){
				adj.add(i, new ArrayList<Integer>());
			}
			for(int i=0;i<E;i++){
				String[] S = br.readLine().split(" ");
				int u = Integer.parseInt(S[0]);
				int v = Integer.parseInt(S[1]);
				adj.get(u).add(v);
				adj.get(v).add(u);
			}
			//System.out.println(CycleDetectDgBfs(adj,V)==true ? "True":"False");
			//System.out.println(checkBipartite(adj,V)==true ? "True":"False");
			//System.out.println(isBipartite(adj,V)==true ? "True":"False");
			int src = 0;
			int dest = 7;
			shortestPath(adj,V,src);
		}
	}
	static boolean CycleDetectinDG(int V, ArrayList<ArrayList<Integer>> adj){
		int[] vis = new int[V];
		for(int i=0;i<V;i++){
			if(dfsForCycle(i,vis,adj)) return true;
		}
		return false;
	}

	/*static boolean dfsForCycle(ArrayList<ArrayList<Integer>> adj, int node, int par, int[] vis){
		vis[node] = 2;
		for(int it : adj.get(node)){
			if(vis[it]!=2){
				dfsForCycle(adj,it,node,vis);
			}
			else if(it!=par){
				return true;
			}
		}
		return false;
	}*/

	public static boolean dfsForCycle(int indx, int[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[indx] = 2;
        for(int child : adj.get(indx)){
        	if(vis[child]==1) continue;
        	if(vis[child]==2) return true;
        	if(dfsForCycle(child,vis,adj)) return true;
        }
        vis[indx] = 1;
        return false;
    }

    public static boolean CycleDetectDgBfs(ArrayList<ArrayList<Integer>> adj, int V){
    	ArrayDeque<Integer> dq = new ArrayDeque<>();
    	int[] indegree = new int[V];
    	for(int i=0;i<V;i++){
    		for(int it : adj.get(i)){
    			indegree[it]++;
    		}
    	}
    	for(int i=0;i<V;i++){
    		if(indegree[i]==0){
    			dq.offerLast(i);
    		}
    	}
    	int[] topo = new int[V];
    	int node;
    	int indx=0;
    	int count=0;
    	while(!dq.isEmpty()){
    		node = dq.poll();
    		topo[indx++] = node;
    		for(int it : adj.get(node)){
    			indegree[it]--;
    			if(indegree[it]==0){
    				dq.offerLast(it);
    			}
    		}
    		count++;
    	}
    	if(count == V)
    		return false;
    	else return true;
    }

    static boolean dfsCheck(ArrayList < ArrayList < Integer >> graph, int node, int color[]) {
        for (Integer it: graph.get(node)) {
            if (color[it] == -1) {
                //Color of variable neighbor is the inverted color of variable node
                color[it] = 1 - color[node];

                if (!dfsCheck(graph, it, color))
                    return false;
            } else if (color[it] == color[node]) {
                return false;
            }
        }
        return true;
    }

    static boolean checkBipartite(ArrayList < ArrayList < Integer >> graph, int n) {
        int color[] = new int[n];

        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfsCheck(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int V){
    	int[] color = new int[V];
    	for(int i=0;i<V;i++){
    		color[i] = -1;
    	}
    	for(int i=0;i<V;i++){
    		if(color[i]==-1){
    			if(!bfsBipartite(adj,i,color)) return false;
    		}
    	}
    	return true;
    }

    static boolean bfsBipartite(ArrayList<ArrayList<Integer>> adj, int node, int[] color){
    	color[node] = 1;
    	ArrayDeque<Integer> dq = new ArrayDeque<>();
    	int indx;
    	dq.offerLast(node);
    	while(!dq.isEmpty()){
    		indx = dq.pollLast();
    		for(int it : adj.get(indx)){
    			if(color[it] == -1){
    				dq.offerLast(it);
    				color[it] = 1 - color[indx];
    			}
    			else if(color[it]==color[indx])
    				return false;
    		}
    	}
    	return true;
    }

    static void shortestPath(ArrayList<ArrayList<Integer>> adj, int V, int src){
    	int[] dist = new int[V];
    	for(int i=0;i<V;i++){
    		dist[i] = 100000000;
    	}
    	ArrayDeque<Integer> dq = new ArrayDeque<>();
    	dist[src] = 0;
    	dq.push(src);
    	int node;
    	while(!dq.isEmpty()){
    		node = dq.pollLast();
    		for(int it : adj.get(node)){
    			if(dist[node]+1<dist[it]){
    				dist[it] = dist[node]+1;
    				dq.offerLast(it);
    			}
    		}
    	}
    	for(int i=0;i<V;i++){
    		System.out.print(dist[i]+" ");
    	}
    }
}