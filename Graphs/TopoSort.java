import java.util.*;
import java.io.*;
import java.lang.*;

class TopoSort{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0){
			String[] s = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int u,v;
			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
			for(int i=0;i<V;i++){
				adj.add(i,new ArrayList<Integer>());
			}
			for(int i=0;i<E;i++){
				String[] S = br.readLine().split(" ");
				u = Integer.parseInt(S[0]);
				v = Integer.parseInt(S[1]);
				adj.get(u).add(v);
			}
			int[] arr = topoSortKahn(V,adj);
			//int[] arr = topoSort(V,adj);
			//for(int i=arr.length-1;i>=0;i--){
			//	System.out.print(arr[i]+" ");
			//}
			for(int i=0;i<arr.length;i++){
				System.out.print(arr[i]+" ");
			}
		}
	}

	static void findTopoSort(int node,int[] vis, ArrayList<ArrayList<Integer>> adj, ArrayDeque<Integer> dq){
		vis[node] = 1;
		for(int it : adj.get(node)){
			if(vis[it]==0)
				findTopoSort(it,vis,adj,dq);
		}
		dq.offerLast(node);
	}

	static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj){
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		int[] vis = new int[N];
		for(int i=0;i<N;i++){
			if(vis[i]==0){
				findTopoSort(i,vis,adj,dq);
			}
		}
		int indx=0;
		int[] topo = new int[N];
		while(!dq.isEmpty()){
			topo[indx++] = dq.poll();
		}
		return topo;
	}

	static int[] topoSortKahn(int N, ArrayList<ArrayList<Integer>> adj){
		int[] indegree = new int[N];
		for(int i=0;i<N;i++){
			for(int it : adj.get(i)){
				indegree[it]++;
			}
		}
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int i=0;i<N;i++){
			if(indegree[i]==0){
				dq.offerLast(i);
			}
		}
		int[] topo = new int[N];
		int node;
		int indx=0;
		while(!dq.isEmpty()){
			node = dq.poll();
			topo[indx++] = node;
			for(int it : adj.get(node)){
				indegree[it]--;
				if(indegree[it]==0){
					dq.offerLast(it);
				}
			}
		}
		return topo;
	}
}