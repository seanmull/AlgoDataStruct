package arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class OneAway {

	public static void main(String[] args) {
		/*One Away: There are three types of edits that can be performed on strings: insert a character,
		remove a character, or replace a character. Given two strings, write a function to check if they are
		one edit (or zero edits) away.
		EXAMPLE
		pale, ple -> true
		pales, pale -> true
		pale, bale -> true
		pale, bake -> false*/
		String s1 = "brag";
		String s2 = "bra";
		
		LinkedList<String> string1 = new LinkedList<String>(Arrays.asList(s1.split("")));
		LinkedList<String> string2 = new LinkedList<String>(Arrays.asList(s2.split("")));
		
		int diff = s1.length() - s2.length();
		if(Math.abs(diff) > 1) {
			System.out.println(s1 + " is not one away from " + s2);
			System.exit(0);
		}else if(diff > 0) {
			string2.addLast(" ");
		}else if(diff < 0){
			string1.addLast(" ");
		}
		
		int counter = 0;
		for(int i = 0; i < string1.size(); i++) {
			if(!string1.get(i).equals(string2.get(i))) {
				counter++;
			}
		}
		if(counter == 1) {
			System.out.println(s1 + " is one away from " + s2);
		}else {
			System.out.println(s1 + " is not one away from " + s2);
		}
		
		//Each linked list creations is N so 2N runtime
		//The adding of elements is constant 1 runtime
		//Checking each element N runtime so big 0(N) runtime.
		//Sorting wouldn't helps since quick sort its runtime is NlogN
			


	}

}
