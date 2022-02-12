/*import java.util.*;
import java.io.*;
import java.lang.*;
class Trisq{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			int b = Integer.parseInt(br.readLine());
			System.out.println(triangles(b));
		}
	}
	static int triangles(int b){
		if(b<4)
			return 0;
		return (b/2 -1 + triangles(b-2));
	}
}
*/
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.math.*;

class CP {
    static int mod=1000000007;
    static long fact[] =new long[1000007];
    static int sieve[] = new int[100005];
    static int N = 100000;
    static long []spf = new long[1000005];
    static long []hash = new long[1000001];
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            while(testCases-- > 0){
                // write code here
                int b = in.nextInt();
                System.out.println(triangles(b));
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static int triangles(int b){
		if(b<4)
			return 0;
		return (b/2 -1 + triangles(b-2));
	}
    static int[] LPS(String s){
        int[] lps = new int[s.length()];
        int i=1,len=0;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                lps[i] = len+1;
                i++;
                len++;
            }
            else{
                if(len!=0){
                    len = lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    static int KMP(String s,String pat){
        int[] lpspat = LPS(pat);
        int len=0;int i=0;int j=0;
        int lenP = pat.length();
        int lenS = s.length();
        int count=0;
        while(i<lenS){
            if(s.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j!=0)
                    j=lpspat[j-1];
                else
                    i++;
            }

            if(j>=lenP) {
                count++;
                j=lpspat[j-1];
            }
        }
        return count;
    }
    static int gcd(int a, int b, int x, int y)
    {
        // Base Case
        if (a == 0)
        {
            x = 0;
            y = 1;
            return b;
        }

        int x1=1, y1=1; // To store results of recursive call
        int gcd = gcd(b%a, a, x1, y1);

        // Update x and y using results of recursive
        // call
        x = y1 - (b/a) * x1;
        y = x1;

        return gcd;
    }
    static int binarysearch(int []arr,int n) throws IOException{
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==n)
                return mid;
            else if(arr[mid]<n){
                low = mid+1;
            }
            else if(arr[mid]>n){
                high = mid-1;
            }

        }
        return -1;
    }
    static long nCr(long n,long r){
        long i=0;
        long res = 1;
        for(i=0;i<r;i++){
            res=(res*(n-i))/(i+1);
        }
        return res;
    }
    static long fact(long n){
        long sum=1;
        for(long i=1;i<=n;i++){
            sum*=i;
        }
        return sum;
    }
    static void precompute(){
        fact[0] =1;
        for(int i=1;i<=1000000;i++){
            fact[i]=(fact[i-1]*i)%mod;
        }
    }
    static long modPow(long base, long n){
        long ans=1;
        while(n>0){
            if(n%2==0){
                base = (base*base)%mod;
                n=n/2;
            }else{
                ans = (ans*base)%mod;
                n=n-1;
            }
        }
        return ans;
    }
    static int firstoccurence(int[] nums,int target){
        int start = 0;
        int end = nums.length -1;
        int res = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target==nums[mid]){
                res=mid;
                end = mid-1;
            }
            else if(target<nums[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return res;
    }
    static int lastoccurence(int[] nums,int target){
        int start=0;
        int end = nums.length-1;
        int res= -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target==nums[mid]){
                res = mid;
                start = mid+1;
            }
            else if(target<nums[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return res;
    }
    static boolean prime(int n){
        int count=1;
        for(int i=2;i*i<=n;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
    static void generatesieve(){
        for(int i=2;i<=N;i++)
            sieve[i] = 1;
        for(int j=2;j*j<=N;j++){
            if(sieve[j]==0)
                continue;
            for(int k=2*j;k<=N;k=k+j){
                sieve[k] = 0;
            }
        }
    }
    static void printprimes(int l,int r){
        generatesieve();
        for(int i=l;i<=r;i++){
            if(sieve[i]==1){
                System.out.println(i);
            }
        }
    }

    static void createSPF() {
        for (int i = 2; i <= spf.length; i++) spf[i] = i;

        for (int j = 2; j * j <= spf.length; j++) {
            if (spf[j] != j) continue;

            for (int k = j * j; k <= spf.length; k = k + j) {
                if(spf[k]==k) spf[k] = j;
            }
        }
    }
    static void printinFactors(long n) {
        while(n!=1) {
            System.out.println(spf[(int)n]+" ");
            n = n / spf[(int)n];
        }
    }
    static void segmentedsieve()throws IOException{
        FastReader fr = new FastReader();
        int l = fr.nextInt();
        int r = fr.nextInt();
        int N = (int)Math.sqrt(r);
        int []segsieve = new int[N+1];
        for(int i=1;i<=N;i++)
            segsieve[i] = 1;
        for(int j=2;j*j<=N;j++){
            if(segsieve[j]==1){
                for(int k=j*j;k<=N;k=k+j){
                    segsieve[k]=0;
                }
            }
        }
        ArrayList<Integer> prime = new ArrayList<>(N+1);
        for(int i=2;i<=N;i++){
            if(segsieve[i]==1){
                prime.add(i);
            }
        }
        int size = r-l+1;
        int []dummy = new int[size+1];
        for(int i=0;i<=size;i++){
            dummy[i] = 1;
        }
        for(int q : prime){
            int firstmultiple = (l/q)*q;
            if(l%q!=0){
                firstmultiple+=q;
            }
            for(int k=firstmultiple;k<=r;k+=q){
                if(k!=q){
                    dummy[k-l] = 0;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        int count=0;
        for(int m=l;m<=r;m++){
            if(dummy[m-l]==1){
                list.add(m);
                //count++;
            }
        }

        //System.out.println(count);
        for(int n : list){
            if(n!=1){
                System.out.println(n);
            }
        }
        System.out.println();
    }
}
class FastReader
{
    //I don't understand how this works lmao
    private int BS = 1 << 16;
    private char NC = (char) 0;
    private byte[] buf = new byte[BS];
    private int bId = 0, size = 0;
    private char c = NC;
    private double cnt = 1;
    private BufferedInputStream in;

    public FastReader() {
        in = new BufferedInputStream(System.in, BS);
    }

    public FastReader(String s) {
        try {
            in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
        } catch (Exception e) {
            in = new BufferedInputStream(System.in, BS);
        }
    }

    private char getChar() {
        while (bId == size) {
            try {
                size = in.read(buf);
            } catch (Exception e) {
                return NC;
            }
            if (size == -1) return NC;
            bId = 0;
        }
        return (char) buf[bId++];
    }

    public int nextInt() {
        return (int) nextLong();
    }

    public int[] nextInts(int N) {
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = (int) nextLong();
        }
        return res;
    }

    public long[] nextLongs(int N) {
        long[] res = new long[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextLong();
        }
        return res;
    }

    public long nextLong() {
        cnt = 1;
        boolean neg = false;
        if (c == NC) c = getChar();
        for (; (c < '0' || c > '9'); c = getChar()) {
            if (c == '-') neg = true;
        }
        long res = 0;
        for (; c >= '0' && c <= '9'; c = getChar()) {
            res = (res << 3) + (res << 1) + c - '0';
            cnt *= 10;
        }
        return neg ? -res : res;
    }

    public double nextDouble() {
        double cur = nextLong();
        return c != '.' ? cur : cur + nextLong() / cnt;
    }

    public double[] nextDoubles(int N) {
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextDouble();
        }
        return res;
    }

    public String next() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = getChar();
        while (c > 32) {
            res.append(c);
            c = getChar();
        }
        return res.toString();
    }

    public String nextLine() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = getChar();
        while (c != '\n') {
            res.append(c);
            c = getChar();
        }
        return res.toString();
    }

    public boolean hasNext() {
        if (c > 32) return true;
        while (true) {
            c = getChar();
            if (c == NC) return false;
            else if (c > 32) return true;
        }
    }
}
//use for codeforces!
class FastWriter {
    private final BufferedWriter bw;

    public FastWriter() {
        this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void print(Object object) throws IOException {
        bw.append("" + object);
    }

    public void println(Object object) throws IOException {
        print(object);
        bw.append("\n");
    }

    public void close() throws IOException {
        bw.close();
    }
}