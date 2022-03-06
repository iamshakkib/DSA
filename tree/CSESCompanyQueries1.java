import java.util.LinkedList;
import java.util.Scanner;

class CSESCompanyQueries1{
    static int[][] parent = new int[2*100005][20];
    static int[] level = new int[2*100005];
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            LinkedList<Integer> list[] = new LinkedList[n+1];
            for(int i=0;i<=n;i++){
                list[i] = new LinkedList<Integer>();
            }
            for(int i=2;i<=n;i++){
                int u = sc.nextInt();
                list[i].add(u);
                list[u].add(i);
            }
            //dfsForPrinting(list, 1, 0);
            dfs(list, 1, 0, 1);
            while(q-->0){
                int v = sc.nextInt();
                int k = sc.nextInt();
                //System.out.println(v+" v and k"+k);
                int z = findKthParent(list,v,k);
                System.out.println(z ==0 ? -1 : z);
            }
        }
    }
    static void dfs(LinkedList<Integer> list[],int node, int par, int lev){
        parent[node][0] = par;
        level[node] = lev;
        for(int i=1;i<=19;i++){
            parent[node][i] = parent[parent[node][i-1]][i-1];
        }
        for(var it : list[node]){
            if(it!=par){
                dfs(list,it,node,lev+1);
            }
        }
    }
    static int findKthParent(LinkedList<Integer> list[],int node,int k){
        int count=0;
        while(k>0){
            if((k&1)>=1){
                node = parent[node][count];
            }
            count++;
            k = k>>1;
        }
        return node;
    }
    static int lca(LinkedList<Integer> list[],int u,int v){
        if(level[v]<level[u]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int k = level[v]-level[u];
        v = findKthParent(list, v, k);
        if(u==v) return u;
        for(int i=20;i>=0;i--){
            if(parent[u][i]!=parent[v][i]){
                u = parent[u][i];
                v = parent[v][i];
            }
        }
        return parent[u][0];
    }
    static LinkedList<Integer>[] takeInput(){
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            LinkedList<Integer> list[] = new LinkedList[n+1];
            for(int i=0;i<list.length;i++){
                list[i] = new LinkedList<Integer>();
            }
            int u,v;
            for(int i=0;i<n-1;i++){
                u = sc.nextInt();
                v = sc.nextInt();
                list[u].add(v);
                list[v].add(u);
            }
            return list;
        }
    }
    static void dfsForPrinting(LinkedList<Integer> list[],int node, int par){
        System.out.println(node);
        for(var it : list[node]){
            if(it != par){
                dfsForPrinting(list, it, node);
            }
        }
    }
    
}