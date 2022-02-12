import java.util.*;
import java.io.*;
import java.lang.*;

class tree2{
	public static void main(String[] args) throws IOException {
		LinkedList<Integer> list[] = takeInput();
		bfs2(list,1);
	}
	public static LinkedList<Integer>[] takeInput() throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> list[] = new LinkedList[n+1];
		for(int i=0;i< list.length;i++){
			list[i] = new LinkedList<Integer>();
		}
		for(int i=1;i<=n-1;i++){
			int u,v;
			u = sc.nextInt();
			v = sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		return list;
	}

	public static void bfs(LinkedList<Integer> list[],int root,int parent){
		if(list==null) return;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(root,-1));
		while(!q.isEmpty()){
			int node = q.peek().first;
			int par = q.peek().second;
			q.poll();
			System.out.println(node+" ");
			for(int i=0;i<list[node].size();i++){
			if(list[node].get(i)!=parent)
				q.offer(new Pair(list[node].get(i),parent));
			}
		} 
	}

	public static void bfs2(LinkedList<Integer> list[], int root){
		Queue<Pair> q = new ArrayDeque<>();
		q.offer(new Pair(root,-1));
		while(!q.isEmpty()){
			int node = q.peek().first;
			int par = q.peek().second;
			q.poll();
			System.out.print(node+" ");
			for(var it : list[node]){
				if(it!=par){
					//System.out.println(list[node].get(node)+"df");
					q.offer(new Pair(it,node));
				}
			}
		}
		System.out.println();
	}

	public static void dfs(LinkedList<Integer> list[],int node, int arrival){
		System.out.println(node);
		for(int i=0;i<list[node].size();i++){
			if(list[node].get(i)!=arrival)
				dfs(list,list[node].get(i),node);
		}
	}
}
class Pair{
	int first;
	int second;
	Pair(int first,int second){
		this.first=first;
		this.second = second;
	}
}