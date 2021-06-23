package recursionDP;

public class fact {

	public static void main(String[] args) {
		//f(3)
		//n != 1
		//return 3 * Call f(2)
		//f(2)
		//n != 1
		//return 2 * Call f(1)
		//n == 1
		//return 1 => go to ln 11 to get f(2)
		//return 2 * (1) = 2 go to ln 11 to get f(3)
		//return 3 * (2)
		System.out.println(factor(3));

	}
	
	public static int factor(int n) {
		System.out.println("n = " + n);
		if(n == 1) {
			System.out.println("Base case <true>");
			return n;
		}else {
			System.out.println("Base case <false>");
		}
		System.out.println("Recursive case " + n + " :  " + n + " * factor(" + (n -1) + ")");
		int f = n; //solved problem
		int fact = factor(n-1); //unsolved sub-problem
		return f* fact;

	}

}
