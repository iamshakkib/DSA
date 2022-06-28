import java.io.*;
import java.util.*;
import java.lang.*;

class KruskalsAlgo{
	public static void main(String[] args) {
		int n = 5;
        ArrayList<Node> adj = new ArrayList<Node>();
		adj.add(new Node(0, 1, 2));
		adj.add(new Node(0, 3, 6));
		adj.add(new Node(1, 3, 8));
		adj.add(new Node(1, 2, 3));
		adj.add(new Node(1, 4, 5));
		adj.add(new Node(2, 4, 7));
		kruskalsAlgo(adj,n);
	}
	static int findPar(int u, int[] parent){
		if(u==parent[u]) return u;
		else return parent[u] = findPar(parent[u],parent);
	}
	static void union(int u, int v, int[] parent, int[] rank){
		u = findPar(u,parent);
		v = findPar(v,parent);
		if(rank[u]<rank[v]){
			parent[u] = v;
		}else if(rank[v]<rank[u]){
			parent[v] = u;
		}else{
			parent[v] = u;
			rank[u]++;
		}
	}
	static void kruskalsAlgo(ArrayList<Node> adj, int N){
		Collections.sort(adj, new SortComparator());
		int[] parent = new int[N];
		int[] rank = new int[N];
		for(int i=0;i<N;i++){
			parent[i] = i;
			rank[i] = 0;
		}
		int cost=0;
		ArrayList<Node> mst = new ArrayList<>();
		for(Node it : adj){
			if(findPar(it.u,parent)!=findPar(it.v,parent)){
				cost += it.weight;
				mst.add(it);
				union(it.u,it.v,parent,rank);
			}
		}
		System.out.println(cost);
		for(Node it : mst){
			System.out.println(it.u+"-"+it.v);
		}
	}
}
class Node{
	public int u;
	public int v;
	public int weight;
	Node(int u, int v, int weight){
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
	Node(){}
}
class SortComparator implements Comparator<Node> {
	@Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.weight < node2.weight) 
            return -1; 
        if (node1.weight > node2.weight) 
            return 1; 
        return 0; 
    } 
} 
