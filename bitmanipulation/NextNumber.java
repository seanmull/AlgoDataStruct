package bitmanipulation;

public class NextNumber {

	public static void main(String[] args) {
		/*Next Number: Given a positive integer, print the next smallest and the next largest number that 
		have the same number of 1 bits in their binary representation.*/
		
		int x = 13456; //101
		int numOfFlipedBits = countOneBits(x);
		int smallest = 0; //next smallest 3 11
		int largest = 0; //next largest 6 110
		
		//System.out.println(numOfFlipedBits);
		
		for(int i = x - 1; i > 0; i--) {
			if(countOneBits(i) == numOfFlipedBits) {
				smallest = i;
				break;
			}
		}
		
		for(int i = x + 1; i < 2147483647; i++) {
			if(countOneBits(i) == numOfFlipedBits) {
				largest = i;
				break;
			}
		}
		
		System.out.println("The next smallest of " + x + " is " + smallest);
		System.out.println("The next largest of " + x + " is " + largest);
	}
	
	public static int countOneBits(int num) {
		int count = 0;
		while(num != 0) {
			if((num & 1) == 1) count++;
			num >>= 1;
		}
		return count;
	}

}
