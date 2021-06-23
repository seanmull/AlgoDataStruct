package strings;

import java.util.ArrayList;

public class LongPalindormeSub {

	public static void main(String[] args) {
		/*Given a string s, return the longest palindromic substring in s.

		Example 1:

		Input: s = "babad"
		Output: "bab"
		Note: "aba" is also a valid answer.
		
		Example 2:

		Input: s = "cbbd"
		Output: "bb"
		
		Example 3:

		Input: s = "a"
		Output: "a"
		
		Example 4:

		Input: s = "ac"
		Output: "a"
				 

		Constraints:

		1 <= s.length <= 1000
		s consist of only digits and English letters (lower-case and/or upper-case),*/
		

		//StringBuilder s = new StringBuilder("ba"); //Convert this to stringbuilder
		//StringBuilder s = "babad"; //TODO Convert this to stringbuilder
		//StringBuilder s = "cbbdabbbbbbbbbbba"; //TODO Convert this to stringbuilder
		StringBuilder s = new StringBuilder("cbbdabbbbbbbbbbba");
		ArrayList <StringBuilder> subList = new  ArrayList <StringBuilder>();
		StringBuilder sub;
		StringBuilder pal;
		StringBuilder longPal = new StringBuilder();
		int subLen;
		int max = 0;
		
		for(int start = 0; start < s.length(); start++) {	
			for(int end = start + 1; end < s.length() + 1; end++) {
				sub = new StringBuilder();
				for(int pos = start; pos < end; pos++) { 
					sub.append(s.charAt(pos));
				}
				subList.add(sub);
			}
		}
		//System.out.println(subList);
		for(int subListIndex = 0; subListIndex < subList.size(); subListIndex++) {
			pal = new StringBuilder();
			subLen = subList.get(subListIndex).length();
			for(int subIndex = subLen - 1; subIndex > -1; subIndex--) {
				pal.append(subList.get(subListIndex).charAt(subIndex));
			}
			//System.out.println(pal + " " + subList.get(subListIndex));
			if(compareStrBuilder(pal, subList.get(subListIndex))) {
				if(pal.length() > max) {
					longPal = new StringBuilder();
					longPal.append(subList.get(subListIndex));
					max = pal.length();
				}
			}	
		}
		System.out.println(longPal);
	}
	
	public static boolean compareStrBuilder(StringBuilder a, StringBuilder b) {
		if(a.length() != b.length()) return false;
		for(int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) return false;
		return true;
	}
	
	//Runtime n * n for getting the substrings, and compare n of them
	//Runtime is n^3 and memory n^4 since we compare this to the palendrome

}
