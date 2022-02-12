class CeilingBS{
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,7,15};
		int value = -1;
		int result = ceiling(arr,value);
		System.out.println(result);
	}

	static int ceiling(int[] arr, int value){
		int start = 0;
		int end = arr.length-1;
		if(value > arr[arr.length-1]||value<arr[0])
		return -1;
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
		return start;
	}
}