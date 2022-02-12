import java.util.*;
import java.io.*;
import java.lang.*;

class OrderAgnosticBS{
	public static void main(String[] args) {
		int[] arr = {40,50,60,70,80};
		int value = 50;
		System.out.println(orderAgnosticBS(arr,value));
	}

	static int orderAgnosticBS(int[] arr, int value){
		int start = 0;
		int end = arr.length-1;
		boolean asc = arr[start] < arr[end];

		while(start <= end){
			int mid = start + (end-start)/2;
			if(value == arr[mid])
				return mid;
			if(asc){
				if(value<arr[mid]){
					end = mid-1;
				}else{
					start = mid+1;
				}
			}else{
				if(value<arr[mid]){
					start = mid+1;
				}else{
					end = mid-1;
				}
			}
		}
		return -1;
	}
}