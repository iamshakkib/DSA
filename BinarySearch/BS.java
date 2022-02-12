import java.util.*;
import java.lang.*;
import java.io.*;

class BS{
	public static void main(String[] args) {
		int[] arr = {-15,-2,0,1,5,10,15};
		int value = 5;
		int result = binarySearch(arr,value);
		System.out.println(result);
	}

	static int binarySearch(int[] arr, int value){
		int start = 0;
		int end = arr.length-1;
		while(start<=end){
			int mid = start + (end-start)/2;
			if(value > arr[mid]){
				start=mid+1;
			}else if(value<arr[mid]){
				end=mid-1;
			}else{
				return mid;
			}
		}
		return -1;
	}
}