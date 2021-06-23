package recursionDP;

import java.util.ArrayList;

public class AllConstruct {

	public static void main(String[] args) {
		//Write a function "allConstruct(target,wordbank)" that accepts a target string
		//and an array of strings
		
		//The function should return an 2D array containing all of the ways target can be constructed by
		//conatenating elements in the wordbank array.  Each element should represent one combination that 
		//constructs the target.
		
		//allConstruct("purple" [purp,p,ur,le,purpl]) -> [[purp,le],[p,ur,p,le]]
		String s = "abcdef";
		String[] words = new String[] {"ab","abc", "cd", "def","abcd","ef","c"};
		System.out.println(allConstruct(s,words));

	}
	
	public static ArrayList <ArrayList <String>> allConstruct(String target, String[] wordBank) {
			if(target.isEmpty()) return new ArrayList <ArrayList <String>>();
			
			ArrayList <ArrayList <String>> result = new ArrayList <ArrayList <String>>();
			
			for(String word : wordBank) {
				if(target.startsWith(word)) {
					String suffix = target.substring(word.length());
					//System.out.println(postfix);
					ArrayList <ArrayList <String>> suffixWays = allConstruct(suffix, wordBank);
					for(ArrayList <String> way: suffixWays) {
						way.add(0, word);
					}
					for(int i = 0; i < suffixWays.size(); i++) {
						result.add(suffixWays.get(i));
					}
					
					//System.out.println(suffixWays);
					//ArrayList <ArrayList <Integer>> targetWays = suffixWays.
					
					//targetways = suffixways.map(word..way)
					//result push ...targetways
				}
			}
			return result;
				
			
	}
		
		
		
		
		
	

}
