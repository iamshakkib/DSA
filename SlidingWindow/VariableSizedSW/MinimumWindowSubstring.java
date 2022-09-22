import java.util.*;
import java.io.*;
import java.lang.*;

class MinimumWindowSubstring{
	public static void main(String[] args) {
		String str = "totmtaptat";
		String pat = "tta";
		System.out.println(minimumWindowSubstring(str,pat));
	}
	static int minimumWindowSubstring(String str, String pat){
		int i=0,j=0;
		int size = str.length();
		int k;
		int ans = Integer.MAX_VALUE;
		HashMap<Character,Integer> map = new HashMap<>();
		for(char c : pat.toCharArray()){
			map.put(c,map.getOrDefault(c,0)+1);
		}
		k = map.size();
		while(j<size){
			if(map.containsKey(str.charAt(j))){
				map.put(str.charAt(j),map.getOrDefault(str.charAt(j),0)-1);
				if(map.get(str.charAt(j))==0) k--;
			}
			if(k>0){
				j++;
			}
			else if(k==0){	
				while(k==0){
					if(!map.containsKey(str.charAt(i))){
						i++;
						ans=Math.min(ans,j-i+1);
					}else{
						ans=Math.min(ans,j-i+1);
						map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
						if(map.get(str.charAt(i))>0){
							k++;
						}
						i++;
					}
				}
				j++;
			}
		}
		return ans;
	}
}