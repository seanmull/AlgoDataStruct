package tabulationDP;

public class fibTab {

	public static void main(String[] args) {
		System.out.println(fib(50));

	}
	
	public static long fib(int n) {
		long[] a = new long[n+1];
		a[1] = 1;
		for(int i = 0; i < a.length - 1; i++) {
			a[i+1] += a[i];
			if(i < a.length - 2) a[i+2] += a[i];
		}
		return a[n];

	}

}
