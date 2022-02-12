// Java program to count maximum consecutive
// 1's in a binary array.
import java.util.*;
class two{
	
	// Returns count of maximum consecutive 1's
	// in binary array arr[0..n-1]
	static ArrayDeque<Integer> getMaxLength(int arr[], int n)
	{
		
		int count = 0; //initialize count
		int result = 0; //initialize max
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayDeque<Integer> dq = new ArrayDeque<>();
	
		for (int i = 0; i < n; i++)
		{
			
			// Reset count when 0 is found
		
			int max = -1;
			int max2=-1;
			if(arr[i]==0){
				if(!dq.isEmpty()){
					while(!dq.isEmpty()){
					dq.pollLast();
				}
			}					

			}
			else{
				dq.offerLast(arr[i]);
				//dq.offerLast(i);

			}
			
		}
	
		return dq;
	}
	
	// Driver method
	public static void main(String[] args)
	{
		int[] arr = {0,1,0,1,1,0,0,1,1,1,0,1};
		int n = arr.length;
		
		ArrayDeque<Integer> b = getMaxLength(arr, n);
		System.out.println(b.size());
		for(int i=0;i<b.size();i++){
			System.out.print(b.pollLast()+" ");
		}
	}
}

// This code is contributed by Anant Agarwal.
