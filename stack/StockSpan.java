import java.util.*;
import java.io.*;
import java.lang.*;

class StockSpan{
	public static void main(String[] args) {
		int[] arr = {100,80,60,70,60,75,85};
		int[] ans = nglIndex(arr);
		for(int i=0;i<ans.length;i++){
			ans[i]=i-ans[i];
		}
		for(int i:ans){
			System.out.print(i+" ");
		}
	}
	static int[] nglIndex(int[] arr){
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int i=0;i<arr.length;i++){
			if(dq.size()==0){
				dq.offerLast(i);
				ans.add(-1);
			}else{
				while(dq.size()>0&&arr[i]>arr[dq.peekLast()]){
					dq.pollLast();
				}
				if(dq.size()==0){
					ans.add(-1);
				}else{
					ans.add(dq.peekLast());
				}
				dq.offerLast(i);
			}
		}
		int[] object = ans.stream().mapToInt(i -> i).toArray();
		return object;
	}
}