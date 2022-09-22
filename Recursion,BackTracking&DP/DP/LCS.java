import java.util.*;
import java.io.*;
import java.lang.*;

class LCS{
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String arr = br.readLine();
		String brr = br.readLine();
		int n=Math.max(arr.length(),brr.length());
		dp = new int[n];
		Arrays.fill(dp,-1);
		int f = LCS(arr,brr,0,0);
		System.out.println(f);
	}
	static int LCS(String arr,String brr,int i,int j){
		int ans = Integer.MIN_VALUE;	
		if(arr.length()==i||brr.length()==j){
			return 0;
		}
		if(dp[i]!=-1)
			return dp[i];
		if(arr.charAt(i)==brr.charAt(j)){
			ans = Math.max(ans,LCS(arr,brr,i+1,j+1)+1);
		}
		ans = Math.max(ans,LCS(arr,brr,i,j+1));
		ans = Math.max(ans,LCS(arr,brr,i+1,j));
		return dp[i] = ans;
	}
}