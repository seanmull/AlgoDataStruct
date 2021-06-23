package strings;


public class LongSubWithoutRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Given a string s, find the length of the longest substring without repeating characters.

		Example 1:

		Input: s = "abcabcbb"
		Output: 3
		Explanation: The answer is "abc", with the length of 3.
		Example 2:

		Input: s = "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.
		Example 3:

		Input: s = "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3.
		Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
		Example 4:

		Input: s = ""
		Output: 0
		 

		Constraints:

		0 <= s.length <= 5 * 104
		s consists of English letters, digits, symbols and spaces.*/
		
		String s = "";
		char[] str = new char[s.length()];
		char[] sub = new char[s.length()];
		int subcount = 1;
		int max = 0;
		int subIndex = 1;
		boolean charFound;
		
		str = s.toCharArray();
		if(s.length() == 0) {
			System.out.println(0);
			System.exit(0);
		}
		sub[0] = str[0];
		
		for(int strIndex = 1; strIndex < s.length();) {
			charFound = false;
			for(int findsubIndex = 0; findsubIndex < sub.length; findsubIndex++) {
				if(str[strIndex] == sub[findsubIndex]) { 
					sub = new char[s.length()];
					subIndex = 0;
					subcount = 0;
					charFound = true;
					break;
				}
			}
			if(!charFound) {
				sub[subIndex] = str[strIndex];
				subcount++;
				strIndex++;
				subIndex++;
				if(subcount > max) max = subcount;	
			}
			
		}
		System.out.println(max);
		
		//Runtime is n since you need to look at each number memory 
		//Memory is a bit inefficent since we create new arrays each time
		//A salution could be to use an array list so I can empty it each
		//Theres a repeat

	}

}
