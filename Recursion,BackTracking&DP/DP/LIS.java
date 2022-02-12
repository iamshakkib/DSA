import java.util.*;
import java.io.*;
import java.lang.*;

class LIS{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(s[i]);
		}
		System.out.println(lis(arr,0,Integer.MIN_VALUE));
	}
	static int lis(int[] arr, int i, int prev){
		if(i==arr.length)
			return 0;
		int something=0;
		int excl = lis(arr,i+1,prev);
		if(arr[i]>prev)
		something = 1+lis(arr,i+1,arr[i]);
		//else lis(arr,cur+1);
		return Math.max(excl,something);
	}
}