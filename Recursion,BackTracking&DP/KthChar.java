
import java.io.*;
import java.util.*;
class KthChar{
	public static void main(String[] args)throws Exception{
		
		try{
			//Your Solve
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t=Integer.parseInt(br.readLine());
			while(t-->0){
				long k=Long.parseLong(br.readLine());
				System.out.println(kthchar(60,k));
			}
		}catch(Exception e){
			return;
		}
	}
	static char revert(char x){
		if(x=='a')
			return 'c';
		return 'a';
	}
	static char kthchar(long n, long k){
		long middle = 1<<(n-1);
		if(k==middle){
			return 'a';
		}
		else if(k<middle){
			return kthchar(n-1,k);
		}
		else{
			return revert(kthchar(n-1,2*middle-k));
		}
	}
}