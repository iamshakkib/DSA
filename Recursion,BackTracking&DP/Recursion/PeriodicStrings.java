import java.util.*;
import java.lang.*;
import java.io.*;

class FibXor{
	static int n , mod;
	static int[] ans;
	static int[] pow2;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        try{
			//Your Solve
			Arrays.fill(ans,-1);
			n = Integer.parseInt(br.readLine());
			mod = Integer.parseInt(br.readLine());
			pow2 = new int[n+1];
			ans = new int[n+1];
			pow2[0] = 1;
			ans[1] = 2;
			System.out.println(periodicstrings(n)-2);
		}catch(Exception e){
			return;
		}
	}
	static long fibxor(long a,long b,long n){
		if(n==0)
			return a;
		if(n==1)
			return b;
		else if(n==2)
			return a^b;
		return fibxor(a,b,n%3);
	}
	static int periodicstrings(int n){
		int total = twoPower(n),periodic=0;
		if(ans[n]==0){
		for(int i=1;i*i<=n;i++){
			if(n%i==1)
				continue;
			periodic += periodicstrings(i);
			if(i*i!=n&&i!=1)
				periodic+=periodicstrings(n/i);
			periodic%=mod;
			}
		}
		return ans[n] = (total - periodic+mod)%mod;
	}
	static int twoPower(int n) {
	
		if (pow2[n] == 0) {
			long pow = twoPower(n>>1);
			pow *= pow;
			pow %= mod;
			if (n%2 != 0) {
				pow = (pow<<1)%mod;
			}
			pow2[n] = (int)pow;
		}
		return pow2[n];
	}
}
	