package recursionDP;

import java.util.HashMap;

public class FibMemo {

	public static void main(String[] args) {
		
		HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
		System.out.println(fib(75, memo));

	}
	
	public static long fib(int n, HashMap<Integer, Integer> m) {
		System.out.println("n = " + n);
		if(m.containsKey(n)) return m.get(n);
		if(n < 2) {
			//System.out.println("Base case <true>");
			return 1;  
		}else {
			//System.out.println("Base case <false>");
		}
		System.out.println("Recursive case " + n + " :  " + "fib(" + (n -1) + ")"+ " + fib(" + (n -2) + ")");
		m.put(n, (int) (fib(n - 1,m) + fib(n - 2,m)));
		return m.get(n);
	}

}
