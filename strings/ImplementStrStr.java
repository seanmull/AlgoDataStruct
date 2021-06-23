package strings;

public class ImplementStrStr {

	public static void main(String[] args) {
		/*Implement strStr().

		Return the index of the first occurrence of needle in haystack, 
		or -1 if needle is not part of haystack.

		Clarification:

		What should we return when needle is an empty string?
		This is a great question to ask during an interview.

		For the purpose of this problem, we will return 0 when needle is an empty string. 
		This is consistent to C's strstr() and Java's indexOf().

		Example 1:

		Input: haystack = "hello", needle = "ll"
		Output: 2
		
		Example 2:

		Input: haystack = "aaaaa", needle = "bba"
		Output: -1
		Example 3:

		Input: haystack = "", needle = ""
		Output: 0
		 

		Constraints:

		0 <= haystack.length, needle.length <= 5 * 104
		haystack and needle consist of only lower-case English characters.*/
		
		//String haystack = "hello";
		//String needle = "ll";
		//String haystack = "aaaaa";
		//String needle = "bba";
		//String haystack = "";
		//String needle = "";
		String haystack = "worldhello";
		String needle = "hello";
		char[] haystackArr = new char[haystack.length()];
		char[] needleArr = new char[needle.length()];
		boolean checkForNeedle = false;
		
		//Convert haystack and needle to charArrays
		haystackArr = haystack.toCharArray();
		needleArr = needle.toCharArray();
		
		if(haystackArr.length == 0 || needleArr.length == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		for(int haystackIndex = 0; haystackIndex < haystackArr.length; haystackIndex++) {
			if(haystackArr[haystackIndex] == needleArr[0]) checkForNeedle = true;
			if(checkForNeedle) {
				for(int needleIndex = 0; needleIndex < needleArr.length; needleIndex++) {
					if(needleArr[needleIndex] != haystackArr[haystackIndex]) {
						checkForNeedle = false;
						break;
					}
					haystackIndex++;
				}
				if(checkForNeedle) {
					System.out.println(haystackIndex - needleArr.length);
					System.exit(0);
				}
			}
		}
		System.out.println(-1);
		
		//Runtime is n since you have to look at every element 
		//memory is n + m where n is the haystack and m is the needle
	}

}
