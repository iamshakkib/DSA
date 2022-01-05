import java.util.*;
import java.io.*;
import java.lang.*;

class test{
	public static void main(String[] args)throws IOException{
		Scanner sc = new Scanner(System.in);
		//Node<Integer> root = takeInput(sc);
		Node<Integer> root = takeInputLevelWise();
		printLevelWise(root);
		//System.out.println("count of nodes is "+countnode(root));
		//System.out.println("the largest node is "+largest(root));
		//System.out.println("height : "+height(root));
		//int k = sc.nextInt();
		//printAtk(root,k);
		//System.out.println(leafNode(root));
		//postorder(root);
		//preorder(root);
	}

	public static Node<Integer> takeInput(Scanner sc) throws IOException{

		System.out.println("Enter the next node data");
		Integer n = sc.nextInt();
		Node<Integer> root = new Node<Integer>(n);
		System.out.println("Enter the no. of children");
		Integer childcount = sc.nextInt();
		for(int i=0;i<childcount;i++)
		{
			Node<Integer> child = takeInput(sc);
			root.children.add(child);
		}
		return root;
	}
	public static void print(Node<Integer> root) throws IOException{
		String s = root.data+":";
		for(int i=0;i<root.children.size();i++){
			s = (String)(s+root.children.get(i).data+",");
		}
		System.out.println(s);
		for(int i=0;i<root.children.size();i++){
			print(root.children.get(i));
		}
	}
	public static Node<Integer> takeInputLevelWise() throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter root");
		int root = sc.nextInt();
		Node<Integer> bada = new Node<Integer>(root);
		Queue<Node<Integer>> q = new LinkedList<Node<Integer>>();
		q.add(bada);
		while(!q.isEmpty()){
			Node<Integer> temp = q.poll();
			System.out.println("Enter the no. of childrens of "+temp.data);
			int child = sc.nextInt();
			for(int i=0;i<child;i++){
				System.out.println("Enter the "+(i+1)+"th children of "+temp.data);
				int n = sc.nextInt();
				Node<Integer> children = new Node<Integer>(n);
				q.add(children);
				temp.children.add(children);
			}
		}
		return bada;
	}
	public static void printLevelWise(Node<Integer> root){
		Queue<Node<Integer>> q = new LinkedList<Node<Integer>>();

		Node<Integer> f = root;
		q.add(f);
		while(!q.isEmpty()){
			Node<Integer> temp = q.poll();
			String s= temp.data+":";
			for(int i=0;i<temp.children.size();i++){
				s = (s+temp.children.get(i).data+" ");
				q.add(temp.children.get(i));
			}
			System.out.println(s);
		}
	}
	public static int countnode(Node<Integer> root){
		if(root==null){
			return 0;
		}
		int count=1;
		for(int i=0;i<root.children.size();i++){
			count+=countnode(root.children.get(i));
		}
		return count;
	}
	public static int largest(Node<Integer> root){
		if(root==null){
			return Integer.MIN_VALUE;
		}
		int ans = root.data;
		for(int i=0;i<root.children.size();i++){
			int largestchild = largest(root.children.get(i));
			if(ans<largestchild)
			ans = largestchild;
		}
		return ans;
	}
	public static int height(Node<Integer> root){
		int ans=0;
		int count=0;
		for(int i=0;i<root.children.size();i++){
			count += height(root.children.get(i));
			if(ans<count)
			ans = count;
			count=0;
		}
		return ans+1;
	}
	public static void printAtk(Node<Integer> root, int k){
		if(k<0){
			return;
		}
		if(k==0){
			System.out.println("node at k : "+root.data);
			return;
		}
		for(int i=0;i<root.children.size();i++){
			printAtk(root.children.get(i),k-1);
		}
	}
	public static int leafNode(Node<Integer> root){
		int faisal = 0;
		if(root.children.size()==0)
		return 1;
		for(int i=0;i<root.children.size();i++){
			faisal += leafNode(root.children.get(i));
		}
		return faisal;
	}
	public static void postorder(Node<Integer> root){
		if(root==null){
			return;
		}
		for(int i=0;i<root.children.size();i++){
			postorder(root.children.get(i));
		}
		System.out.println(root.data);
	}
	public static void preorder(Node<Integer> root){
		if(root==null)
		return;
		System.out.println(root.data+" ");
		for(int i=0;i<root.children.size();i++){
			preorder(root.children.get(i));
		}
	}
}
class Node<T>{
	T data;
	ArrayList<Node<T>> children;
	Node(T data){
		this.data = data;
		children = new ArrayList<>();
	}
}