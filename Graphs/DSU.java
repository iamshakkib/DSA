import java.util.*;
import java.io.*;
import java.lang.*;

class DSU{
	static int[] parent = new int[100000];
	static int[] rank = new int[100000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		makeSet();
		int m = sc.nextInt();
		while(m-->0){
			int u = sc.nextInt();
			int v = sc.nextInt();
			union(u,v);
		}
		System.out.println(findPar(2)!=findPar(3) == true ? "Diff" : "Same");
	}
	static void makeSet(){
		for(int i=0;i<parent.length;i++){
			parent[i] = i;
			rank[i] = 0;
		}
	}
	static int findPar(int node){
		if(node==parent[node]) return node;
		else return parent[node] = findPar(parent[node]);
	}
	static void union(int u, int v){
		u = findPar(u);
		v = findPar(v);
		if(rank[u]<rank[v]){
			parent[u] = v;
		}else if(rank[v]<rank[u]){
			parent[v] = u;
		}else{
			parent[v] = u;
			rank[u]++;
		}
	}
}