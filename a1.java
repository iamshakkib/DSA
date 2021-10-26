import java.io.*;
import java.util.*;

public class a1 {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("in.txt"));
			System.setOut(new PrintStream(new FileOutputStream("out.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			System.out.println(n);
		}
	}
}