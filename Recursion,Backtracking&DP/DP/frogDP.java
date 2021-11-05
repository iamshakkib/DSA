import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        try {
            FastReader fr = new FastReader();
            FastWriter fw = new FastWriter();
            //int testCases=fr.nextInt();
            //while(testCases-- > 0){
            // write code here
            // out.println("hello world");
            //}
            //out.close();
            int n = fr.nextInt();
            int[] array = new int[n];
            int k = fr.nextInt();
            for(int i=0;i<n;i++){
                array[i]= fr.nextInt();
            }
            dp = new int[n];
            Arrays.fill(dp,-1);
            System.out.println(frogBiterative(array,0,k));
            fw.close();
        } catch (Exception e) {
            return;
        }
    }
    //DP memoization - top down forward from 0 -> n
    static int frogA(int indx,int[] a){
        int n = a.length;
        if(indx==n-1)
            return 0;
        if(dp[indx]!=-1) return dp[indx];
        int onejump = Math.abs(a[indx]-a[indx+1])+frogA(indx+1,a);
        int twojump= Integer.MAX_VALUE;
        if(indx+2<n) {
            twojump = Math.abs(a[indx] - a[indx + 2]) + frogA(indx + 2, a);
        }
        return dp[indx]=Math.min(onejump,twojump);
    }
    //iterative dp - bottom up from reverse
    static int frogAiterative(int[] a){
        int n = a.length;
        dp[0]=0;
        dp[1]=Math.abs(a[1]-a[0]);
        for(int i=2;i<n;i++){
            dp[i]=Math.min(Math.abs(a[i]-a[i-1])+dp[i-1],Math.abs(a[i]-a[i-2])+dp[i-2]);
        }
        return dp[n-1];
    }
    //reverse recursive dp
    static int frogAreverse(int[] array,int indx){
        dp[0]=0;
        dp[1]=Math.abs(array[0]-array[1]);
        if(dp[indx]!=-1){
            return dp[indx];
        }
        int firstjump = Math.abs(array[indx]-array[indx-1])+frogAreverse(array,indx-1);
        int secondjump = Math.abs(array[indx]-array[indx-2])+frogAreverse(array,indx-2);
        
        return dp[indx]=Math.min(firstjump,secondjump);
    }
    //forward iterative dp 
    static int frogAiterativereverse(int[] array){
        dp[array.length-1] = 0;
        dp[array.length-2] = Math.abs(array[array.length-1]-array[array.length-2]);
        for(int i=array.length-2;i>=0;i--){
            dp[i] = Math.abs(array[i]-array[i+1])+dp[i+1];
            if(i+2<array.length){
                dp[i] = Math.min(dp[i],Math.abs(array[i]-array[i+2])+dp[i+2]);
            }
        }
        return dp[0];
    }
    static int frogB(int[] array,int indx,int k){
        int n = array.length;
        //dp[n-1] = 0;
        if(indx==n-1){
            return dp[indx] = 0;
        }
        if(dp[indx]!=-1){
            return dp[indx];
        }
        int cost=Integer.MAX_VALUE;
        for(int steps=1;steps<=k;steps++){
            if(indx+steps<n){
                cost = Math.min(cost,Math.abs(array[indx]-array[indx+steps])+frogB(array,indx+steps,k));
            }else{
                break;
            }
        }
        return dp[indx] = cost;
    }
    static int frogBiterative(int[] array,int indx,int k){
        int n = array.length;
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            dp[i] = Integer.MAX_VALUE;
            for(int step=1;step<=k;step++){
                if(i+step<n){
                    dp[i] = Math.min(dp[i],Math.abs(array[i]-array[i+step])+dp[i+step]);
                }else{
                    break;
                }
            }
        }
        return dp[0];
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
    public static BufferedWriter bw;

    public FastWriter() {
        this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void print(Object object) throws IOException {
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
