import java.util.*;
import java.io.*;
import java.lang.*;

class shortestPathInDAG{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		// running for t testcases, where t is an integer
		while(t-->0){
			String[] s = br.readLine().split(" ");
			//taking input of Number of nodes or vertices as V and edges as E
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			for(int i=0;i<V;i++){
				adj.add(i, new ArrayList<Pair>());
			}
			for(int i=0;i<E;i++){
				String[] S = br.readLine().split(" ");

				// taking the edge between nodes u and v

				int u = Integer.parseInt(S[0]);
				int v = Integer.parseInt(S[1]);

				// node with associated weight

				int w = Integer.parseInt(S[2]);
				adj.get(u).add(new Pair(v,w));
			}
			int source = 1;
			shortestPath(source,adj,V);
		}
	}
	static void shortestPath(int s, ArrayList<ArrayList<Pair>> adj, int N)
    {
        int dist[] = new int[N];

        Boolean visited[] = new Boolean[N];
        for (int i = 0; i < N; i++)
            visited[i] = false;

  		// calculating the topo sort using bfs method through kahn's algo

        ArrayDeque<Integer> stack = topoSortKahn(N,adj);

        for (int i = 0; i < N; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;

        while (!stack.isEmpty())
        {
            int node = stack.poll();

            if (dist[node] != Integer.MAX_VALUE)
            {
                for(Pair it: adj.get(node)) {
                    if(dist[node] + it.getWeight() < dist[it.getV()]) {
                        dist[it.getV()] = dist[node] + it.getWeight(); 
                    }
                }
            }
        }

        for (int i = 0; i < N; i++)
        {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( dist[i] + " ");
        }
    }
	static ArrayDeque<Integer> topoSortKahn(int N, ArrayList<ArrayList<Pair>> adj){
		int[] indegree = new int[N];
		for(int i=0;i<N;i++){
			for(Pair it : adj.get(i)){
				indegree[it.getV()]++;
			}
		}
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int i=0;i<N;i++){
			if(indegree[i]==0){
				dq.offerLast(i);
			}
		}
		ArrayDeque<Integer> topo = new ArrayDeque<>();
		int node;
		int indx=0;
		while(!dq.isEmpty()){
			node = dq.poll();
			topo.offerLast(node);
			for(Pair it : adj.get(node)){
				indegree[it.getV()]--;
				if(indegree[it.getV()]==0){
					dq.offerLast(it.getV());
				}
			}
		}
		return topo;
	}
}
class Pair{
	private int v;
	private int weight;
	Pair(int v, int weight){
		this.v = v;
		this.weight = weight;
	}
	int getV(){
		return this.v;
	}
	int getWeight(){
		return this.weight;
	}
}