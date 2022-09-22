import java.io.*;
import java.lang.*;
import java.util.*;

class CountAnagramInASubarray{
	public static void main(String[] args) {
		String str = "aabaabaa";
		String pat = "aaba";
		System.out.println(countAnagramInASubarray(str,pat));
	}
	static int countAnagramInASubarray(String str, String pat){
		HashMap<Character,Integer> map = new HashMap<>();
		for(char c : pat.toCharArray()){
			map.put(c,map.getOrDefault(c,0)+1);
		}
		int size = str.length();
		int window = pat.length();
		int disCount = map.size();
		int ans=0;
		int i=0,j=0;
		while(j<size){
			if(map.containsKey(str.charAt(j))){
				map.put(str.charAt(j),map.getOrDefault(str.charAt(j),0)-1);
				if(map.get(str.charAt(j))==0) disCount--;
			}
			if(j-i+1<window){
				j++;
			}
			else if(j-i+1==window){
				if(disCount==0) ans++;
				if(map.containsKey(str.charAt(i))){
					map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
					if(map.get(str.charAt(i))==1) disCount++;
				}	
				j++;
				i++;
			}
		}
		return ans;
	}
}