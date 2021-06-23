package bitmanipulation;

public class BinaryToString {

	public static void main(String[] args) {
		/*Binary to String: Given a real number between O and 1 (e.g., 0.72) that is passed in as a double, print 
		the binary representation. If the number cannot be represented accurately in binary with at most 32 
		characters, print "ERROR:'*/
		
		double x = 0.25;
		
		//System.out.println(Long.toBinaryString(Double.doubleToRawLongBits(x)));
		
		//Algo found here https://ryanstutorials.net/binary-tutorial/binary-floating-point.php
		
		int bin = 0;
		
		for(int i = 0; i < 31; i++) {
			bin <<= 1;
			x *= 2;
			System.out.println(x);
			if(x >= 1) {
				bin ^= 1;
				x--;
			}	
		}
		if(x == (int)x) {
			System.out.println(Long.toBinaryString(bin));
		}else{
			System.out.println("Error");
		}
		
	}

}
