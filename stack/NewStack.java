import java.util.*;
import java.io.*;
import java.lang.*;

class NewStack{
	public static void main(String[] args) {
		int[] arr = {4,5,2,10,8};
		ArrayList<Integer> list = nsr(arr);
		Collections.reverse(list);
		System.out.println(list.toString());
	}

	//ngr tested to gfg
	static ArrayList<Integer> ngr(int[] arr){
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		ArrayList<Integer> ans = new ArrayList<>();
		int j=arr.length;
		for(j=arr.length-1;j>=0;j--){
			System.out.println(arr[j]+" iteration");
			if(dq.size()==0){
				dq.offerLast(arr[j]);
				ans.add(-1);
				System.out.println(arr[j]+" if loop");
			}
			else{
				System.out.println(arr[j]+" else loop");
				if(arr[j]<dq.peekLast()){
					ans.add(dq.peekLast());
					dq.offerLast(arr[j]); 
					System.out.println("last element in dq "+dq.peekLast());
				}else{
					while(dq.size()>0&&arr[j]>=dq.peekLast()){
						dq.pollLast();
					}
					if(dq.size()==0){
							ans.add(-1);
						}else{
							ans.add(dq.peekLast());
						}
					dq.offerLast(arr[j]);
				}
			}
		}
		return ans;
	}

//	1 	3	 2 	  4

	static ArrayList<Integer> ngl(int[] arr){
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int j=0;j<arr.length;j++){
			if(dq.size()==0){
				dq.offerLast(arr[j]);
				ans.add(-1);
			}else{
				while(dq.size()>0&&arr[j]>dq.peekLast()){
					dq.pollLast();
				}
				if(dq.size()==0){
					dq.offerLast(arr[j]);
					ans.add(-1);
				}else{
					ans.add(dq.peekLast());
				}
				dq.offerLast(arr[j]);
			}
		}
		return ans;
	}

	// 4 5 2 10 8

	static ArrayList<Integer> nsl(int[] arr){
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int i=0;i<arr.length;i++){
			if(dq.size()==0){
				dq.offerLast(arr[i]);
				ans.add(-1);
			}else{
				while(dq.size()>0&&arr[i]<dq.peekLast()){
					dq.pollLast();
				}
				if(dq.size()==0){
					ans.add(-1);
				}else{
					ans.add(dq.peekLast());
				}
				dq.offerLast(arr[i]);
			}
		}
		return ans;
	}

	static ArrayList<Integer> nsr(int[] arr){
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		int j = arr.length;
		for(int i=j-1;i>=0;i--){
			if(dq.size()==0){
				dq.offerLast(arr[i]);
				ans.add(-1);
			}else{
				while(dq.size()>0&&arr[i]<dq.peekLast()){
					dq.pollLast();
				}
				if(dq.size()==0){
					ans.add(-1);
				}else{
					ans.add(dq.peekLast());
				}
				dq.offerLast(arr[i]);
			}
		}
		return ans;
	}
}