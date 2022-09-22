import java.util.*;
import java.io.*;
import java.lang.*;

class Permutation{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> array =  new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            array.add(Integer.parseInt(br.readLine()));
        }
        int ptr = 0;
        permutation(ptr,array);
    }
    static void permutation(int ptr , ArrayList<Integer> array){
        if(ptr==array.size()){
            //printarray(array);
            System.out.println(Arrays.toString(array.toArray()));
            return;
        }
       for(int i=ptr;i<array.size();i++){
            Collections.swap(array,i,ptr);
            permutation(ptr+1,array);
            Collections.swap(array,i,ptr);
       }
    }
    static void printarray(ArrayList<Integer> mem){
        for(int i=0;i<mem.size();i++){
            System.out.print(mem.get(i));
        }
        System.out.println();
    }
}