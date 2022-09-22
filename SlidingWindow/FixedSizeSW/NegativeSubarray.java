import java.io.*;
import java.util.*;
import java.lang.*;
class NegativeSubarray{
	public static void main(String[] args) {
		int[] arr = {-7,2,-1,3,4};
		ArrayList<Integer> temp = negativeNoInEverySubarray(arr,3);
		System.out.println(temp.toString());
	}
	static ArrayList<Integer> negativeNoInEverySubarray(int[] arr,int k){
		int size = arr.length;
		int i=0,j=0;
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayDeque<Integer> list = new ArrayDeque<>();
		while(j<size){
			if(arr[j]<0){
				list.offerLast(arr[j]);
			}
			if(j-i+1<k){
				j++;
			}
			else if(j-i+1==k){
				if(!list.isEmpty()){
					ans.add(list.peekFirst());
					if(list.peekFirst()!=arr[i]){
						i++;
					}else{
						list.pollFirst();
						i++;
					}
				}else ans.add(0);
				j++;
			}			
		}
		return ans;
	}
}