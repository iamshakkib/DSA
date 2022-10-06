import java.util.*;
import java.lang.*;
import java.io.*;

class TrappingRainWater{
	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(trappingRainWater(arr)+" ans");
	}
	static int trappingRainWater(int[] arr){
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		int[] ansL = new int[arr.length];
		int[] ansR = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			if(dq.size()==0){
				dq.offerLast(arr[i]);
				ansL[i]=dq.peekLast();
			}else{
				if(dq.peekLast()>arr[i]){
					ansL[i]=dq.peekLast();
				}else{
					ansL[i]=arr[i];
					dq.offerLast(arr[i]);
				}
			}
		}
		System.out.println(Arrays.toString(ansL));
		System.out.println(dq.toString());
		dq.clear();
		for(int i=arr.length-1;i>=0;i--){
			if(dq.size()==0){
				dq.offerLast(arr[i]);
				ansR[i]=dq.peekLast();
			}else{
				if(dq.peekLast()>arr[i]){
					ansR[i]=dq.peekLast();
				}else{
					ansR[i]=arr[i];
					dq.offerLast(arr[i]);
				}
			}
		}
		System.out.println(Arrays.toString(ansR));
		int sum=0;
		for(int i=0;i<arr.length;i++){
			sum+=Math.min(ansR[i],ansL[i])-arr[i];
		}
		return sum;
	}
}