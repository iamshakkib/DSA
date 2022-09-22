import java.util.*;
import java.io.*;
import java.lang.*;

class postFixtoInfix{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			postfixtoinfix(br.readLine());
		}
	}
	static boolean isOperand(char text){
		if(text>='0'&&text<='9'||text>='A'&&text<='Z'||text>='a'&&text<='z'){
			return true;
		}
		return false;
	}
	static boolean isOperator(char text){
		if(text=='+'||text=='-'||text=='*'||text=='/'||text=='^'||text=='%'){
			return true;
		}
		return false;
	}
	static void postfixtoinfix(String postfix){
		int size = postfix.length();
		ArrayDeque<String> dq = new ArrayDeque<>();
		String aux="";
		String op1="";
		String op2="";
		boolean isValid=true;
		for(int i=0;i<size&&isValid;i++){
			if(isOperator(postfix.charAt(i))){
				if(dq.size()>1){
					op1 = dq.pollLast();
					op2 = dq.pollLast();
					aux = "("+op2+postfix.charAt(i)+op1+")";
					dq.offerLast(aux);
				}
				else{
					isValid=false;
				}
			}
			else if(isOperand(postfix.charAt(i))){
				aux=""+postfix.charAt(i);
				dq.offerLast(aux);
			}
			else{
				isValid=false;
			}
		}
		if(isValid==false){
			System.out.println("invalid"+postfix);
		}
		else{
			System.out.println("infix"+dq.pollLast());
		}
	}
}