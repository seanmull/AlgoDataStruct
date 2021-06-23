package recursionDP;

public class Fib {

	public static void main(String[] args) {
		//Pattern is the following
		//0 1
		//1 1
		//2 2
		//3 3
		//4 5
		//5 8
		//6 13
		
		//so the relationship can be generalized
		//as f(n) = f(n-1) + f(n - 2)
		//This is assuming n > 2
		
		//Base case n = 2
		//Recursive case return f(n - 1) + f(n - 2)
		
//               fib(4)
//            /         \
//       fib(3)        fib(2)
//      /     \        /     \
//    fib(2) fib(1)   fib(1) fib(0)
//    /   \	  	
// fib(1) fib(0)	
		
// Study the sequence of the function calls
		
		System.out.println(fib(4));

	}
	
	public static long fib(int n) {
		System.out.println("n = " + n);
		if(n < 2) {
			System.out.println("Base case <true>");
			return 1;  
		}else {
			System.out.println("Base case <false>");
		}
		System.out.println("Recursive case " + n + " :  " + "fib(" + (n -1) + ")"+ " + fib(" + (n -2) + ")");
		int fib1 = (int) fib(n - 1);
		int fib2 = (int) fib(n - 2);
		return fib1 + fib2;
	}

}
