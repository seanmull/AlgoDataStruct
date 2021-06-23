package bitmanipulation;

public class PairWiseSwap {

	public static void main(String[] args) {
		//Pairwise Swap: Write a program to swap odd and even bits in an integer with as few instructions as 
		//possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on). 
		
		//Input: 10110010 178
		//Output:01110001 113
		
		int x = 113;
		int r = x;
		int count = 0;
		
		System.out.println(Long.toBinaryString(x));
		while(r != 0) {
			r >>= 1;
			count++;
		}
		
		for(int i = 0; i < count; i = i + 2) {
			if((int) (x & (1 << i)) == 0 && (int) (x & (1 << i + 1)) == 1 << i + 1) { // 10
				x |= (1 << i);
				x &= ~(1 << i + 1);
				continue;
			}
			
			if((int) (x & (1 << i)) == 1 << i && (int) (x & (1 << i + 1)) == 0) { // 01
				x |= (1 << i + 1);
				x &= ~(1 << i);
			}
		}
		
		System.out.println(Long.toBinaryString(x));
		System.out.println(x);

	}

}
