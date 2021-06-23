package bitmanipulation;

import java.util.ArrayList;

public class FlipBitToWin {

	public static void main(String[] args) {
		/*Flip Bit to Win: You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to 
		find the length of the longest sequence of ls you could create. 
		EXAMPLE 
		Input: 1775 
		Output: 8*/
		
		int x = 1775;
		ArrayList <Integer> zeroLoc = new ArrayList <Integer> ();
		int r = x;
		int loc = 0; //index of 0's
		int count;
		int max = 0; //maximum number of '1's after the flip
		
		//store locations of zeros in array
		while(r != 0) {
			if((int)(~r & 1) == 1) zeroLoc.add(loc);
			loc++;
			r >>= 1;
		}
		
		System.out.println(zeroLoc);
		
		//Loop through different flipped scenerios and count the '1's in row
		for(int i = 0; i < zeroLoc.size(); i++) {
			r = x;
			r |= (1 << zeroLoc.get(i));  //flip it!
			count = 0;
			while(r != 0) {
				if((int)(r & 1) == 1) {
					count++;
					if(count > max) max = count;
				}else {
					count = 0;
				}
				r >>= 1;
			}
		}
		System.out.println(max);
	}

}
