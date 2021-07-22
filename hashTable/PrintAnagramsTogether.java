package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PrintAnagramsTogether {
	/*Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.


			Example 1:

			Input:
			N = 5
			words[] = {act,god,cat,dog,tac}
			Output: 
			god dog
			act cat tac
			Explanation:
			There are 2 groups of
			anagrams "god", "dog" make group 1.
			"act", "cat", "tac" make group 2.
			Example 2:

			Input:
			N = 3
			words[] = {no,on,is}
			Output: 
			no on
			is
			Explanation:
			There are 2 groups of
			anagrams "no", "on" make group 1.
			"is" makes group 2.*/

	public static void main(String[] args) {
		//String words[] = {"act","god","cat","dog","tac"};
		String words[] = {"no","on","is"};
	    HashMap<Set<Character>,ArrayList<String>> map = new HashMap<Set<Character>,ArrayList<String>>();
		for(String word: words) {
			Set s = convertStringToSet(word, new HashSet());
			if(map.containsKey(s)) {
				map.get(s).add(word);
			}else {
				ArrayList<String> l = new ArrayList<String>();
				l.add(word);
				map.put(s, l);
			}
		}
		for(ArrayList<String> list : map.values()) System.out.println(list);
	}
	
	public static Set convertStringToSet(String word, Set s) {
		for(char c : word.toCharArray()) s.add(c);
		return s;

	}

}
