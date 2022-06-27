import java.util.*;
import java.io.*;
import java.lang.*;
class PrimsAlgo{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			String[] s = br.readLine().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
			for(int i=0;i<V;i++) adj.add(i,new ArrayList<Pair>());
			for(int i=0;i<E;i++){
				String[] S = br.readLine().split(" ");
				int u = Integer.parseInt(S[0]);
				int v = Integer.parseInt(S[1]);
				int w = Integer.parseInt(S[2]);
				adj.get(u).add(new Pair(v,w));
				adj.get(v).add(new Pair(u,w));
			}
			primsAlgo(adj,V);
		}
	}
	static void primsAlgo(ArrayList<ArrayList<Pair>> adj, int N){
		int[] key = new int[N];
		int[] parent = new int[N];
		boolean[] mstSet = new boolean[N];
		for(int i=0;i<N;i++){
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		//Using Min heap for so that we could get the minimum pair just like dijkstra's algo 
		PriorityQueue<Pair> pq = new PriorityQueue<>(N,new Pair());
		key[0] = 0;
		parent[0] = -1;
		pq.add(new Pair(key[0],0));
		while(!pq.isEmpty()){
			int u = pq.poll().getV();
			mstSet[u] = true;
			//same as bfs && same logic for dijkstra's 
			for(Pair it : adj.get(u)){
				if(mstSet[it.getV()]==false && it.getWeight()<key[it.getV()]){
					parent[it.getV()] = u;
					key[it.getV()] = it.getWeight();
					pq.add(new Pair(it.getV(),key[it.getV()]));
				}
			}
		}
		for(int i=1;i<N;i++){
			System.out.println(parent[i]+"-"+i);
		}
	}
}
class Pair implements Comparator<Pair>{
	private int v;
	private int weight;
	Pair(int v, int weight){
		this.v = v;
		this.weight = weight;
	}

	Pair(){}

	int getV(){
		return this.v;
	}
	int getWeight(){
		return this.weight;
	}

	@Override
	public int compare(Pair pair1, Pair pair2){
		if(pair1.weight < pair2.weight) return -1;
		if(pair1.weight > pair2.weight) return 1;
		return 0;
	}
}