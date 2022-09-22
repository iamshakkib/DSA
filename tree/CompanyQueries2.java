import java.util.LinkedList;
import java.util.Scanner;

class CompanyQueries2{
    static long[][] parent = new long[2*100005][20];
    static long[] level = new long[2*100005];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long q = sc.nextLong();
        LinkedList<Integer> list[] = new LinkedList[(int)n+1];
        for(long i=0;i<=n;i++){
            list[(int)i] = new LinkedList<Integer>();
        }
        for(long i=2;i<=n;i++){
            long u = sc.nextLong();
            list[(int)u].add((int)i);
            list[(int)i].add((int)u);
        }
        dfs(list,1,0,1);
        while(q-->0){
            long u = sc.nextLong();
            long v = sc.nextLong();
            System.out.println(lca(list, u, v));
        }
    }
    static void dfs(LinkedList<Integer> list[],int node, int par, int lev){
        parent[node][0] = par;
        level[node] = lev;
        for(long i=1;i<=19;i++){
            parent[node][(int)i] = parent[(int)parent[(int)node][(int)i-1]][(int)i-1];
        }
        for(var it : list[node]){
            if(it!=par){
                dfs(list,it,node,lev+1);
            }
        }
    }
    static long findKthParent(LinkedList<Integer> list[],long node,long k){
        long count=0;
        while(k>0){
            if((k&1)>=1){
                node = parent[(int)node][(int)count];
            }
            count++;
            k = k>>1;
        }
        return node;
    }
    static long lca(LinkedList<Integer> list[],long u,long v){
        if(level[(int)v]<level[(int)u]) {
            long temp = u;
            u = v;
            v = temp;
        }
        long k = level[(int)v]-level[(int)u];
        v = findKthParent(list, v, k);
        if(u==v) return u;
        for(int i=19;i>=0;i--){
            if(parent[(int)u][i]!=parent[(int)v][i]){
                u = parent[(int)u][i];
                v = parent[(int)v][i];
            }
        }
        return parent[(int)u][0];
    }
}