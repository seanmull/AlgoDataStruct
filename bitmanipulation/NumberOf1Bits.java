package bitmanipulation;

public class NumberOf1Bits {

	public static void main(String[] args) {
		/*Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

		Note:

		Note that in some languages such as Java, there is no unsigned integer type. 
		In this case, the input will be given as a signed integer type.
		 It should not affect your implementation, as the integer's internal
		  binary representation is the same, whether it is signed or unsigned.
		In Java, the compiler represents the signed integers using 2's complement notation. 
		Therefore, in Example 3, the input represents the signed integer. -3.
		 

		Example 1:

		Input: n = 00000000000000000000000000001011
		Output: 3
		Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
		
		Example 2:

		Input: n = 00000000000000000000000010000000
		Output: 1
		Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
		
		Example 3:

		Input: n = 11111111111111111111111111111101
		Output: 31
		Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
		 

		Constraints:

		The input must be a binary string of length 32
		 

		Follow up: If this function is called many times, how would you optimize it?
		*/
		
		
		//String n = "00000000000000000000000000001011";
		String n = "11111111111111111111111111111101";
		char[] charN = new char[32];
		charN = n.toCharArray();
		int num = 0;
		int power = 0;
		int count = 0;
		
		//Convert binary string to int
		for(int i = charN.length - 1; i > -1; i--) {
			if(charN[i] == '1') num += Math.pow(2, power);
			power++;		
		}
		
		//Count off the 1's as they get pushed
		while(num > 0) {
			if((num & 1) == 1) count++;
			num >>= 1;
		}
		
		System.out.println(count);
	}

}
