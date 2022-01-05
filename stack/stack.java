//contains standard implementation of most important stack questions
import java.util.*;
public class histo {
    public static void main(String[] args) {
        int[] arr = {4,5,2,10,8};
        //ArrayList<Integer> b = NGR(arr);
        //for(int i=b.size()-1;i>=0;i--)
          //  System.out.println(b.get(i));
        //ArrayList<Integer> c = NGL(arr);
        //for(int i=0;i<c.size();i++)
          //  System.out.println(c.get(i));
        //ArrayList<Integer> d = NSL(arr);
        //for(int i=0;i<d.size();i++)
          //  System.out.println(d.get(i));
        //ArrayList<Integer> e = NSR(arr);
        //for(int i=e.size()-1;i>=0;i--)
          //  System.out.println(e.get(i));
    }
    static ArrayList<Integer> NGR(int[] arr) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            if(dq.size()==0){
                a.add(-1);
            }
            else if(dq.size()>0&&dq.peekLast()>arr[i]){
                a.add(dq.peekLast());
            }
            else if(dq.size()>0&&dq.peekLast()<=arr[i]){
                while(dq.size()>0&&dq.peekLast()<=arr[i]){
                    dq.pollLast();
                }
                if(dq.size()==0)
                    a.add(-1);
                else
                    a.add(dq.peekLast());
            }
            dq.offerLast(arr[i]);
        }
        return a;
    }
    static ArrayList<Integer> NGL(int[] arr){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;
        for(int i=0;i<=n-1;i++){
            if(dq.size()==0){
                a.add(-1);
            }
            else if(dq.size()>0&&dq.peekLast()>arr[i]){
                a.add(dq.peekLast());
            }
            else if(dq.size()>0&&dq.peekLast()<=arr[i]){
                while(dq.size()>0&&dq.peekLast()<=arr[i]){
                    dq.pollLast();
                }
                if(dq.size()==0)
                    a.add(-1);
                else
                    a.add(dq.peekLast());
            }
            dq.offerLast(arr[i]);
        }
        return a;
    }
    static ArrayList<Integer> NSL(int[] arr){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;
        for(int i=0;i<=n-1;i++){
            if(dq.size()==0){
                a.add(-1);
            }
            else if(dq.size()>0&&dq.peekLast()<arr[i]){
                a.add(dq.peekLast());
            }
            else if(dq.size()>0&&dq.peekLast()>=arr[i]){
                while(dq.size()>0&&dq.peekLast()>=arr[i]){
                    dq.pollLast();
                }
                if(dq.size()==0)
                    a.add(-1);
                else
                    a.add(dq.peekLast());
            }
            dq.offerLast(arr[i]);
        }
        return a;
    }
    static ArrayList<Integer> NSR(int[] arr) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            if(dq.size()==0){
                a.add(-1);
            }
            else if(dq.size()>0&&dq.peekLast()<arr[i]){
                a.add(dq.peekLast());
            }
            else if(dq.size()>0&&dq.peekLast()>=arr[i]){
                while(dq.size()>0&&dq.peekLast()>=arr[i]){
                    dq.pollLast();
                }
                if(dq.size()==0)
                    a.add(-1);
                else
                    a.add(dq.peekLast());
            }
            dq.offerLast(arr[i]);
        }
        return a;
    }
}