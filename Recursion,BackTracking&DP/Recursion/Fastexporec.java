import java.util.*;
import java.lang.*;
import java.io.*;

class Fastexporec{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 try {
		 	int t = Integer.parseInt(br.readLine());
			while(t-->0){
			long x,y,p;
			long sum=0;
			String[] s = (br.readLine()).split(" ");
			x = Long.parseLong(s[0]);
			y = Long.parseLong(s[1]);
			p = Long.parseLong(s[2]);
			if(x==1)
				System.out.println((y+1)%p);
			else{
			for(long i=1;i<=y;i++){
				sum+=power(x,i,p)%p;
			}
				System.out.println((sum+1)%p);
			}
		}
            
        	}catch (Exception e) {
            return;
        }
	}
	static long fastExpo(long a,long n){
		if(n==0)
			return 1;

		long f = fastExpo(a,n/2);

		return ((n&1L)==1L?a:1)*(f*f);
	}
	static long fastExpoIterative(long a, long n){
		long res = 1;
		while(n>0){
			if ((n & 1) != 0){
            res = res * a;
        	}
			n=n/2;
			a=a*a;
		}
		return res;
	}
  static long power(long x, long y, long p)
  {
    long res = 1; // Initialize result
 
    x = x % p; // Update x if it is more than or
    // equal to p
 
    if (x == 0)
      return 0; // In case x is divisible by p;
 
    while (y > 0)
    {
 
      // If y is odd, multiply x with result
      if ((y & 1) != 0)
        res = (res * x) % p;
 
      // y must be even now
      y = y >> 1; // y = y/2
      x = (x * x) % p;
    }
    return res;
  }
}