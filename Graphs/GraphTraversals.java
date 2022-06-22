import java.util.*;
import java.io.*;
import java.lang.*;

class GraphTraversals{

	static int N = 4;
	static int visited[] = new int[N];
	static int distance[] = new int[N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		//int E = sc.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0;i<=V;i++){
			adj.add(new ArrayList<Integer>());
		}
		for(int i=0;i<V;i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		BFS(2,adj);
	}
	static ArrayList<Integer> bfs(int node, ArrayList<ArrayList<Integer>> adj, int v){
		boolean[] visited = new boolean[v+1];
		ArrayList<Integer> bfs = new ArrayList<>();
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.offer(node);
		visited[node] = true;
		while(!dq.isEmpty()){
			int curr = dq.pollLast();
			visited[curr] = true;
			bfs.add(curr);
			for(int child : adj.get(curr)){
				if(!visited[child]){
					dq.offer(child);
					visited[child] = true;
				}
			}
		}
		return bfs;
	}
	public static void BFS(int node,ArrayList<ArrayList<Integer>> adj) {
		visited[node] = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(node);
		distance[node] = 0;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr+" ");
			for(int child : adj.get(curr)) {
				if(visited[child] == 0) {
					q.offer(child);
					distance[child] = distance[curr] + 1;
					visited[child] = 1;
				}
			}
		}
		
	}
}