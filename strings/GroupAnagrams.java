package strings;

import java.util.ArrayList;
import java.util.Arrays;

public class GroupAnagrams {

	public static void main(String[] args) {
		/*Given an array of strings strs, group the anagrams together. 
		 * You can return the answer in any order.

		An Anagram is a word or phrase formed 
		by rearranging the letters of a different word or phrase, 
		typically using all the original letters exactly once.

				 

		Example 1:

		Input: strs = ["eat","tea","tan","ate","nat","bat"]
		Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
		Example 2:

		Input: strs = [""]
		Output: [[""]]
		Example 3:

		Input: strs = ["a"]
		Output: [["a"]]
				 

		Constraints:

		1 <= strs.length <= 104
		0 <= strs[i].length <= 100
		strs[i] consists of lower-case English letters*/
		
		//Inputs
		String[] strs1 = new String[] {"eat","tan", "tea","ate","nat","bat"};
		//String[] strs1 = new String[] {" "};
		ArrayList <String> strs = new ArrayList <String> ();
		for(String str1 : strs1) strs.add(str1);
	
		//Storage
		ArrayList <ArrayList <String>> anas = new ArrayList <ArrayList <String>> ();
		
		while(!strs.isEmpty()) {
			String firstStr = strs.get(0);
			ArrayList <String> ana = new ArrayList <String> ();
			ana.add(strs.get(0));
			strs.remove(0);
			for(int i = 0; i < strs.size(); i++) {
				String compareStr = strs.get(i);
				System.out.println(firstStr + " " + compareStr);
				char[] charA = firstStr.toCharArray();  
				Arrays.sort(charA);
				char[] charB = strs.get(i).toCharArray();
				Arrays.sort(charB);
				//System.out.println(Arrays.toString(charA) + " " + Arrays.toString(charB));
				if(compareArray(charA, charB)) {
					System.out.println("Add");
					ana.add(compareStr);
					strs.remove(i);
					i--;
				}	
			}
			anas.add(ana);	
		}
		System.out.println(anas);
		
		//Runtime is n (number of strings) * w log w (number of letters in string)
		//Memory space is n 

	}
	public static boolean compareArray(char[] a, char[] b) {
		if(a.length != b.length) return false;
		for(int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
		return true;
	}

}
