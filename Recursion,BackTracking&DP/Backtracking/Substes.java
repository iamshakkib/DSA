import java.util.*;
import java.io.*;
import java.lang.*;

class Subsets{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> array =  new ArrayList<>();
        ArrayList<Integer> mem = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            array.add(Integer.parseInt(br.readLine()));
        }
        int ptr = 0;
        subsets(ptr,array,mem);
    }
    static void subsets(int ptr , ArrayList<Integer> array , ArrayList<Integer> mem){
        if(ptr==array.size()){
            printarray(mem);
            return;
        }
        subsets(ptr+1,array,mem);
        mem.add(array.get(ptr));
        subsets(ptr+1,array,mem);
        mem.remove(mem.size()-1);
    }
    static void printarray(ArrayList<Integer> mem){
        for(int i=0;i<mem.size();i++){
            System.out.print(mem.get(i));
        }
        System.out.println();
    }
}