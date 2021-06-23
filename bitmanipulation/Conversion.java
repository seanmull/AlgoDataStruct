package bitmanipulation;

public class Conversion {

	public static void main(String[] args) {
		/*Conversion: Write a function to determine the number of bits you would need to flip to convert 
		integer A to integer B. 
		EXAMPLE 
		Input: 29 (or: 11101), 15 (or: 01111) 
		Output: 2 */
		
		int a = 29;
		int b = 15;
		int c = a ^ b;
		int count = 0;
		
		while(c != 0) {
			if((int)(c & 1) == 1) count++;
			c >>= 1;
		}
		
		System.out.println(count);

	}

}
