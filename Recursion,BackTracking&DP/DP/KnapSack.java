import java.io.*;
import java.util.*;
import java.lang.*;

class KnapSack{
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		String[] t = br.readLine().split(" ");
		int W = Integer.parseInt(br.readLine());
		int n = s.length;
		int[] w = new int[n];
		int[] v = new int[n];
		dp = new int[n];
		Arrays.fill(dp,-1);
		for(int i=0;i<n;i++){
			w[i] = Integer.parseInt(s[i]);
			v[i] = Integer.parseInt(t[i]);
		}
		System.out.println(knapsack(w,v,n,W,0));

	}
	static int knapsack(int[] w, int[] v, int n, int W, int i){
		if(i==n||W==0)
			return 0;
		if(dp[i]!=-1){
			return dp[i];
		}
		int ans=knapsack(w,v,n,W,i+1);
		if(W>=w[i]){
			ans = Math.max(ans,knapsack(w,v,n,W-w[i],i+1)+v[i]);
		}
		return dp[i] = ans;
	}
}