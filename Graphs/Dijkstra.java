import java.util.*;
import java.io.*;
import java.lang.*;
 
 class Dijkstra{
 	public static void main(String[] args) throws IOException{
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

			// node/vertices with associated weights

			int w = Integer.parseInt(S[2]);
			adj.get(u).add(new Pair(v,w));
		}
		int src = 0;
		dijkstraAlgo(adj,V,src);
 		}
	}
	static void dijkstraAlgo(ArrayList<ArrayList<Pair>> adj, int N, int src){
 		PriorityQueue<Pair> pq= new PriorityQueue<>(N, new Pair());
 		int[] dist = new int[N];
 		for(int i=0;i<N;i++){
 			dist[i] = Integer.MAX_VALUE;
 		}
 		dist[src] = 0;
 		pq.add(new Pair(src,0));
 		while(pq.size()>0){
 			Pair node = pq.poll();
 			for(Pair it : adj.get(node.getV())){
 				if(dist[node.getV()]+it.getWeight()<dist[it.getV()]){
 					dist[it.getV()] = dist[node.getV()]+it.getWeight();
 					pq.add(new Pair(it.getV(),dist[it.getV()]));
 				}
 			}
 		}
 		for(int i=0;i<N;i++){
 			System.out.print(dist[i]+" ");
 		}
 	}
}
// creating the pair class so that min heap able to compare and 
// we can pop the min node according to the weight.
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