package recursionDP;

import java.util.ArrayList;

public class Scratch {
	
	ArrayList <Integer> test = new ArrayList <Integer> ();
    
	public static void main(String[] args) {
		int i = 0;
		int j = 1;
		
		System.out.println(i + j);
	}
	
	
	/*public static void main(String[] args) {
		int[][] a = {{3}};
		int n = 3;
		System.out.println(fact(n, twoDimCopy(a)));
	}
	
	public static int fact(int n, int[][] a1) { //3, 2, 1
		//a1 = new int[1][1];
		a1[0][0] = 2;
		if(n == 0) { 
			return 1;
		}else {
			int x = n;
			return n * fact(n-1,a1); //f[2] = 6, f[1] = 2, f[0] = 1
		}
	}
	
	public static int[][] twoDimCopy(int[][] ori){
		int[][] b = new int[ori.length][ori[0].length];
		for(int i = 0; i < ori.length; i++) {
			b[i] = (int[])ori[i].clone();
		}
		return b;	
	}
	
	/*public static void main(String[] args) {
	int n = 6;  //0,1,1
	System.out.println(Arrays.toString(fibs(n)));
}

public static int[] fibs(int n) {
	int[] fibs = new int[n];
	if(n == 1) return fibs;
	if(n > 1) fibs[1] = 1;
	for(int i = 2; i < n; i++) {
		fibs[i] = fib(i);
	}
	return fibs;
}

public static int fib(int n) {
	if(n == 1) return 1;
	if(n == 0) return 0;
	return fib(n-1) + fib(n-2); //f[2] = fib(1) + fib(0)
}*/

}
