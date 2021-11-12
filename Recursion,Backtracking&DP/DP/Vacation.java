import java.io.*;
import java.util.*;
import java.lang.*;

class Vacation{
	static int[] a = new int[10005];
	static int[] b = new int[10005];
	static int[] c = new int[10005];
	static int[][] dp = new int[10005][4];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++){
			String[] s = br.readLine().split(" ");
			a[i] = Integer.parseInt(s[0]);
			b[i] = Integer.parseInt(s[1]);
			c[i] = Integer.parseInt(s[2]);
		}
		    for (int[] row : dp)
            Arrays.fill(row, -1);
		System.out.println(vacation(0,0,n));
	}
	static int vacation(int indx , int prev,int n){
		if(indx == n) return 0;
		if(dp[indx][prev]!=-1) return dp[indx][prev];
		int max = Integer.MAX_VALUE;
		if(prev==0){
			int firsttask = a[indx]+vacation(indx+1,1,n);
			int secondtask = b[indx]+vacation(indx+1,2,n);
			int thirdtask = c[indx]+vacation(indx+1,3,n);
			max = Math.max(firsttask,Math.max(secondtask,thirdtask));
		}
		else if(prev==1){
			int secondtask = b[indx]+vacation(indx+1,2,n);
			int thirdtask = c[indx]+vacation(indx+1,3,n);
			max = Math.max(secondtask,thirdtask);
		}
		else if(prev == 2){
			int firsttask = a[indx]+vacation(indx+1,1,n);
			int thirdtask = c[indx]+vacation(indx+1,3,n);
			max = Math.max(firsttask,thirdtask);
		}
		else{
			int firsttask = a[indx]+vacation(indx+1,1,n);
			int secondtask = b[indx]+vacation(indx+1,2,n);
			max = Math.max(firsttask,secondtask);
		}
		return dp[indx][prev] = max;
	}
}