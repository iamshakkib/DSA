import java.util.*;
import java.lang.*;
import java.io.*;

class FibXor{
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        try{
			//Your Solve
			int t=Integer.parseInt(br.readLine());
			while(t-->0){

		 			/*String[] s = (br.readLine()).split(" ");
					long a = Long.parseLong(s[0]);
					long b = Long.parseLong(s[1]);
					long n = Long.parseLong(s[2]);
					*/
					
					long a = sc.nextLong();
					long b = sc.nextLong();
					long n = sc.nextLong();
					System.out.println(fibxor(a,b,n));
					//s=null;
					
				}
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
}