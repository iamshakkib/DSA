import java.util.*;
import java.io.*;
import java.lang.*;

class graph{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<V;i++)
			adj.add(new ArrayList<Integer>());
		addEdge(adj,0,1);
		addEdge(adj,0,4);
		addEdge(adj,1,2);
		addEdge(adj,1,3);
		addEdge(adj,1,4);
		addEdge(adj,2,3);
		addEdge(adj,3,4);
		printgraph(adj);
	}
	static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	static void printgraph(ArrayList<ArrayList<Integer>> adj){
		for(int i=0;i<adj.size();i++){
			System.out.print("head");
			for(int j=0;j<adj.get(i).size();j++){
				System.out.print(" -> "+adj.get(i).get(j));
			}
			System.out.println();
		}
	}
}