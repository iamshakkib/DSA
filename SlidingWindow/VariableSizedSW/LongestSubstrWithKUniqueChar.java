import java.util.*;
import java.io.*;
import java.lang.*;
class LongestSubstrWithKUniqueChar{
	public static void main(String[] args) {
		String str = "aabacbebebe";
		int k=3;
		System.out.println(longestSubstrWithKUniqueChar(str,k));
	}
	static int longestSubstrWithKUniqueChar(String str, int k){
		int i=0,j=0;
		int max = Integer.MIN_VALUE;
		int size = str.length();
		HashMap<Character,Integer> map = new HashMap<>();
		while(j<size){
			map.put(str.charAt(j),map.getOrDefault(str.charAt(j),0)+1);
			if(map.size()<k) j++;
			else if(map.size()==k){
				max = Math.max(max,j-i+1);
				j++;
			}
			else if(map.size()>k){
				while(map.size()>k){
					map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)-1);
					if(map.get(str.charAt(i))==0){
						map.remove(str.charAt(i));
					}
					i++;
				}
				j++;
			}
		}
		return max;
	}
}