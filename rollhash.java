import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class RollHashSubStr {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String goodBad = br.readLine();
        int k = Integer.parseInt(br.readLine());
        System.out.println(GoodSubStr(s,goodBad,k));
    }
    static void SubStr(String s){
        String str = "";
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            String sb = "";
            for(int j=i;j<sb.length();j++){
               sb+=sb.charAt(j);
               set.add(sb);
            }
        }
        for(String ss:set)
            System.out.println(ss+" ");
    }
    static int blackbox(String s){
        int pr = 1;
        int mod = 1000000007;
        int hash = 0;
        for(int i=0;i<s.length();i++){
            hash = (hash+((s.charAt(i)-'a'+1)*pr)%mod)%mod;
        }
        return hash;
    }
    static int findUniqueSubStr(String s){
        HashSet<Integer> set = new HashSet<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            int mod = 1000000007;
            int hash = 0;
            int pr = 1;
            for(int j=i;j<n;j++){
                hash = (hash+((s.charAt(j)-'a'+1)*pr)%mod)%mod;
                set.add(hash);
                pr = (pr*31)%mod;
            }
        }
        return set.size();
    }
    static int GoodSubStr(String s,String goodbad,int k){
        HashSet<Long> set = new HashSet<>();
        int n = s.length();
        long mod = 1000000007;
        for(int i=0;i<n;i++){
            long hash1 = 0,hash2=0;
            long pr1 = 1,pr2 = 1;
            long count=0;
            for(int j=i;j<n;j++){
                if(goodbad.charAt(s.charAt(j)-'a')=='0') count++;
                if(count>k) break;
                //hash1 = (hash1+((s.charAt(j)-'a'+1)*pr1)%mod)%mod;
                hash1 = (hash1+((s.charAt(j)-'a'+1)*pr1)%mod)%mod;
                pr1++;
                pr1 = (pr1*313)%mod;
                //hash2=(hash2+((s.charAt(j)-'a'+1)*pr2)%mod)%mod;
                //pr2=(pr2*29)%mod;
                //set.add(new Pair(hash1,hash2));
                set.add(hash1);
            }
        }
        return set.size();
    }
    static void compareSubstring(BufferedReader br)throws IOException{
        String s=br.readLine();
        int n = s.length();
        long[] prefix = new long[n];
        long mod = 1000000009;
        long hash=0;
        long pr=1;
        long[] powerr = new long[n];
        for(int i=0;i<n;i++){
            hash = (hash+(s.charAt(i)-'a'+1)%mod)%mod;
            prefix[i] = hash;
            powerr[i] = power(pr,mod-2,mod);
            pr = (pr*31)%mod;
        }
        int q = Integer.parseInt(br.readLine());
        while(q-->0){
            long l1,r1,l2,r2;
            l1 = Integer.parseInt(br.readLine());
            r1 = Integer.parseInt(br.readLine());
            l2 = Integer.parseInt(br.readLine());
            r2 = Integer.parseInt(br.readLine());
            int hash1 = computehash(prefix,powerr,l1,r1,mod);
            int hash2 = (int) computehash(prefix,powerr,l2,r2,mod);
            if(hash1==hash2)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    private static long computehash(long[] prefix, long[] powerr, long l, long r, long mod) {
        long hash = (int) prefix[(int) r];
        if(l>0) hash = (int) ((hash-prefix[(int) (l-1)]+mod)%mod);
        hash = (int) (hash*powerr[(int) l]);
        return hash;
    }


    static int power(long pr,long m)
    {
        long m0 = m;
        int y = 0, x = 1;

        if (m == 1)
            return 0;

        while (pr > 1) {
            // q is quotient
            int q = (int) (pr / m);

            int t = (int) m;

            // m is remainder now, process
            // same as Euclid's algo
            m = pr % m;
            pr = t;
            t = y;

            // Update x and y
            y = x - q * y;
            x = t;
        }

        // Make x positive
        if (x < 0)
            x += m0;

        return x;
    }
}
class Pair implements Comparable<Pair> {
    long x, y;
    Pair(long x, long y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Pair o) {
        return Long.compare(this.x,o.x);
    }
}