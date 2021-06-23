package arraysAndStrings;

import java.util.Arrays;
import java.util.LinkedList;

public class CheckPerm {

	public static void main(String[] args) {
		/*Check Permutation: Given two strings, write a method to decide if one is a permutation of the
		other. */
		String s1 = "sag";
		String s2 = "gas";
		
		//Brute force algorthm
		LinkedList<String> String1 = new LinkedList<String>(Arrays.asList(s1.split("")));
		LinkedList<String> String2 = new LinkedList<String>(Arrays.asList(s2.split("")));

		boolean flag; //flag to see if char match
		while(!String1.isEmpty()) {
			flag = false;
			for(int i = 0; i < String2.size(); i++) {
				if (String1.get(0).equals(String2.get(i))) {
					String1.remove(0);
					String2.remove(i);
					flag = true;
					break;
				}
			}
			if(flag == false) {
				System.out.println(s2 + " is not a permutation of " + s1);
				System.exit(0);
			}
		}
		System.out.println(s2 + " is a permutation of " + s1);
	
		//Runtime is 2N for the string to Linkedlist conversion,
		//We then do N + N-1 + N-2 ... 1 comparisions
		//Runtime is big O of N^2 the only better solution would be to sort the array
		//then compare, but then the problem would be trivial.
		
	}

}
