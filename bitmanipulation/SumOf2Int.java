package bitmanipulation;

public class SumOf2Int {

	public static void main(String[] args) {
		/*Given two integers a and b, return the sum of the two integers without using the operators + and -.

				 

				Example 1:

				Input: a = 1, b = 2
				Output: 3
				Example 2:

				Input: a = 2, b = 3
				Output: 5
				 

				Constraints:

				-1000 <= a, b <= 1000*/
		
				// 1 01  2 10 3 11
		
				//11 ^ 1 = 10
		
				/*int a = -56; //10
				int b = 2; //10
				int c = 0;
				boolean carryOver = false;
				int i = 0;
				
				
				while(i != 32) {
					//Case 1 both are 1
					if((int)(a & (1 << i)) == (1 << i) && (int) (b & (1 << i)) == (1 << i)) {
						if(!carryOver) {
							carryOver = true;
						}else {
							c ^= (1 << i);
						}
					}
					
					//Case 2 one or the other is 1
					if(((int)(a & (1 << i)) == (1 << i) && (int) (~b & (1 << i)) == (1 << i)) ||
					   ((int)(~a & (1 << i)) == (1 << i) && (int) (b & (1 << i)) == (1 << i))) {
						 if(!carryOver) c ^= (1 << i);
					}
					
					//Case 3 both are 0
					if(((int)(~a & (1 << i)) == (1 << i) && (int) (~b & (1 << i)) == (1 << i))) {
						 if(carryOver) {
							 c ^= (1 << i);
							 carryOver = false;
						 }
					}
					i++;
				}
				
				
				System.out.println(c);
				System.out.println(carryOver);*/
		
				/*int a = 2;
				int b = -3;
				
				while(a > 0) {
					a--;
					b++;
				}
				while(a < 0) {
					b--;
					a++;
				}*/
				//System.out.println(b);
		
				int y = 3;
				int x = 2;
		
				while (y != 0) 
				{
				
					// carry now contains common
					// set bits of x and y
				int carry = x & y; //10, 01 & 100 = 0
				System.out.println(Long.toBinaryString(x) + " " + Long.toBinaryString(y) + " " + Long.toBinaryString(carry));
 
				// Sum of bits of x and 
				// y where at least one 
				// of the bits is not set
				x = x ^ y; //01, 01 ^ 100 = 101
				System.out.println(Long.toBinaryString(x) + " " + Long.toBinaryString(y) + " " + Long.toBinaryString(carry));
 
				// Carry is shifted by 
				// one so that adding it 
				// to x gives the required sum
				y = carry << 1; //100, 0 << 1 = 0
				}
				System.out.println(x);
				
				//11
				//10
				
				
				
			
				
				
		

				

		

	}

}
