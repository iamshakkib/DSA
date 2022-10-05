import java.util.*;
import java.io.*;
import java.lang.*;


//tested to gfg
class MAH{
	public static void main(String[] args) {
		long[] arr = { 6,
            2,
            5,
            4,
            5,
            1,
            6};
		System.out.println(MAH(arr));
	}
	static long MAH(long[] hist){
		long[] nslArray = NSL(hist);
		long[] nsrArray = NSR(hist);
		long max=Long.MIN_VALUE;
		for(int i=0;i<hist.length;i++){
			max = Math.max(max,Math.abs(nsrArray[i]-nslArray[i]-1)*hist[i]);
		}
		return max;
	}

	public static long[] NSL(long[] arr) {
        //NSL -1 boundary
        long[] res = new long[arr.length];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.size()==0L) {
                res[i] = -1L;
            } else if (st.size()>0 && arr[i] > arr[st.peekLast()]) {
                res[i] = (long)st.peekLast();
            } else if (st.size()>0L && arr[i] <= arr[st.peekLast()]) {
                while (st.size()>0L && arr[i] <= arr[st.peekLast()]) {
                    st.pollLast();
                }
                if (st.size()>0L) {
                    res[i] = (long)st.peekLast();
                } else {
                    res[i] = -1L;
                }
            }
            st.offerLast(i);
        }
        return res;
    }

    public static long[] NSR(long[] arr) {
        //NSR array.length boundary
        long[] res = new long[arr.length];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (st.size()==0L) {
                res[i] = arr.length;
                st.offerLast(i);
            } else if (st.size()>0L && arr[i] > arr[st.peekLast()]) {
                res[i] = st.peekLast();
            } else if (st.size()>0L && arr[i] <= arr[st.peekLast()]) {
                while (st.size()>0L && arr[i] <= arr[st.peekLast()]) {
                    st.pollLast();
                }
                if (st.size()>0) {
                    res[i] = st.peekLast();
                } else {
                    res[i] = arr.length;
                }
            }
            st.offerLast(i);
        }
        return res;
    }
}