class MaxSubarrayOfSumK{
	public static void main(String[] args) {
		int[] arr = {4,1,1,1,2,3,5};
		int k = 5;
		System.out.println(maxSubarrayOfSumK(arr,k));
	}
	static int maxSubarrayOfSumK(int[] arr, int cond){
		int i=0,j=0;
		int max=Integer.MIN_VALUE;
		int size=arr.length;
		int sum=0;
		while(j<size){
			sum+=arr[j];
			if(sum<cond){
				j++;
			}
			else if(sum==cond){
				max=Math.max(max,j-i+1);
				j++;
			}
			else if(sum>cond){
				while(sum>cond){
					sum-=arr[i];
					i++;
				}
				j++;
			}
		}
		return max;
	}
}