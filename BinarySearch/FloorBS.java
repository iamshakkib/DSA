class FloorBS {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7};
        int target = 8;
        System.out.println(floor(arr, target));
    }
    // in floor we return end because start will over pass end 
    // and returning start means returning ceiling and return 
    // end means returning floor
    static int floor(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        int mid;
        if(target > arr[arr.length-1]||target<arr[0])
        return -1;
        while(start <= end){
            mid = start + (end - start)/2;
            if(target < arr[mid]){
                end = mid-1;
            }else if(target > arr[mid]){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return end;
    }
}
