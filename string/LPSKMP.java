import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LPS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
       // int[] arr = LPS(s);
       // System.out.println(Arrays.toString(arr));
        String pat = br.readLine();
        int k = KMP(s,pat);
        System.out.println(k+"count");
    }
    //LPS OR PI ALGORITHM
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
}