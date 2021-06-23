package bitmanipulation;

public class ReverseBits {

	public static void main(String[] args) {
		/*Reverse bits of a given 32 bits unsigned integer.

		Note:

		Note that in some languages such as Java, there is no unsigned integer type. 
		In this case, both input and output will be given as a signed integer type. 
		They should not affect your implementation, as the integer's internal binary representation 
		is the same, whether it is signed or unsigned.
		In Java, the compiler represents the signed integers using 2's complement notation. 
		Therefore, in Example 2 above, the input represents the signed 
		integer -3 and the output represents the signed integer -1073741825.
		Follow up:

		If this function is called many times, how would you optimize it?

		Example 1:

		Input: n = 00000010100101000001111010011100
		Output:    964176192 (00111001011110000010100101000000)
		Explanation: The input binary string 00000010100101000001111010011100 represents 
		the unsigned integer 43261596, so return 
		964176192 which its binary representation is 00111001011110000010100101000000.
		
		Example 2:

		Input: n = 11111111111111111111111111111101
		Output:   3221225471 (10111111111111111111111111111111)
		Explanation: The input binary string 11111111111111111111111111111101 
		represents the unsigned integer 4294967293, so return 3221225471 
		which its binary representation is 10111111111111111111111111111111.
		 
		Constraints:

		The input must be a binary string of length 32*/
		
		
		//String n = "11111111111111111111111111111101"; //3221225471
		String n = "00000010100101000001111010011100"; //964176192
		char[] nChars = new char[32];
		nChars = n.toCharArray();
		long b = 0;  //does not have unsigned int so grab some more memory
		int a = 0;

		
		//Convert string to int
		for(int i = nChars.length - 1 ; i > 0; i--) { 
			if(nChars[i] == '1') b += Math.pow(2, a);
			a++;
		}
		
		long r = b;
		long rev = 0;
		int count = 0;
		
		System.out.println(b); //43261596
		
		//Count how many bits used in b but don't kill the number
		while(r > 0) {  
			r >>= 1;
			count++;
		}
		
		System.out.println(count);
		
		//Take bits from n and read them in reverse for rev
		while(b > 0) {
			System.out.println(Long.toBinaryString(b) + " " + Long.toBinaryString(rev));
			rev <<= 1; //shift rev to left this creates a zero to bottom bit
			if((int)(b & 1) == 1) { //if bottom bit in n is 1
				rev ^= 1;  //flip bottom bit in rev
			}
			b >>= 1; //shift n to right
		}
		
		//Shift left for all the leading zeros were in n
		rev <<= 32-count;

		
		//1011 ^ 001 = 1010  only the last
		//n & 1 == 1 would only be true if n had 1 on the right most bit
		//rev ^= 1 this flips the bottom bit to 0 since it has to be 1
		
		System.out.println(rev + " " + Long.toBinaryString(rev)); 
		

		
		
		
		

	}

}
