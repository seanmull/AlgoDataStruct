package bitmanipulation;

public class Debugger {

	public static void main(String[] args) {
		//Debugger: Explain what the following code does: ( ( n & ( n-1)) == 0).
		
		for(int i = 0; i < 40; i++) {
			if(( i & (i-1)) == 0) {
				System.out.println(i + " " + Long.toBinaryString(i) + " " + true);	
			}else {
				System.out.println(i + " " + Long.toBinaryString(i) + " " + false);
			}
		}
		
		//This only returns true if n = 1 followed by a bunch of zeros
		//for example 1, 10, 100, 1000, ..... 1000000.....
		//which makes sense since 1000 & 0111 = 0 this is true for all variants of this.


	}

}
