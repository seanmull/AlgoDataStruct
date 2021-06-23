package strings;

public class LongCommonPrefix {

	public static void main(String[] args) {
		/*Write a function to find the longest common prefix string amongst an array of strings.

		If there is no common prefix, return an empty string "".

		 

		Example 1:

		Input: strs = ["flower","flow","flight"]
		Output: "fl"
		Example 2:

		Input: strs = ["dog","racecar","car"]
		Output: ""
		Explanation: There is no common prefix among the input strings.
		 

		Constraints:

		0 <= strs.length <= 200
		0 <= strs[i].length <= 200
		strs[i] consists of only lower-case English letters.*/
		
		String[] strs = new String[] {"flower","flow","flight"};
		//String[] strs = new String[] {"dog","racecar","car"};
		char[][] charArrays = new char[strs.length][200];
		String prefix = "";
		int minStrLength = 200;
		boolean matchFlag;
		
		//Break string into char arrays
		for(int i = 0; i < strs.length; i++) {
			char[] charArray = new char[200];
			charArray = strs[i].toCharArray();
			if(charArray.length < minStrLength) minStrLength = charArray.length;
			charArrays[i] = charArray;
		}
		
		//System.out.println(charArrays[0][0]);
		//System.out.println(minStrLength);
		
		
		for(int i = 0; i < minStrLength; i++) { //Loop through each char
			matchFlag = true;
			for(int j = 1; j < strs.length; j++) { //Compare first array to all others
				if(charArrays[0][i] != charArrays[j][i]) matchFlag = false;  
				}	
			if(matchFlag) {
				prefix = prefix + charArrays[0][i];
			}else{
				break;
			}
		}
		System.out.println(prefix);
		
		//Runtime is n -1 where n is the number of words.  And if we look at the length of the word is w*n, where
		//w is the shortest length word.

	}

}
