package strings;

public class StringtoInteger {

	public static void main(String[] args) {
		/*Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

		The algorithm for myAtoi(string s) is as follows:

		Read in and ignore any leading whitespace.
		Check if the next character (if not already at the end of the string) 
		is '-' or '+'. Read this character in if it is either. 
		This determines if the final result is negative or positive respectively. 
		Assume the result is positive if neither is present.
		Read in next the characters until the next non-digit 
		charcter or the end of the input is reached. The rest of the string is ignored.
		Convert these digits into an integer (i.e. "123" -> 123, 
		"0032" -> 32). If no digits were read, then the integer is 0. 
		Change the sign as necessary (from step 2).
		If the integer is out of the 32-bit signed integer range [-231, 231 - 1], 
		then clamp the integer so that it remains in the range. 
		Specifically, integers less than -231 should be clamped to -231, 
		and integers greater than 231 - 1 should be clamped to 231 - 1.
		Return the integer as the final result.
		Note:

		Only the space character ' ' is considered a whitespace character.
		Do not ignore any characters other than the leading whitespace 
		or the rest of the string after the digits.
				 

		Example 1:

		Input: s = "42"
		Output: 42
		Explanation: The underlined characters are what is read in, the caret is the current reader position.
		Step 1: "42" (no characters read because there is no leading whitespace)
				         ^
		Step 2: "42" (no characters read because there is neither a '-' nor '+')
				         ^
		Step 3: "42" ("42" is read in)
				           ^
		The parsed integer is 42.
		Since 42 is in the range [-231, 231 - 1], the final result is 42.
		Example 2:

		Input: s = "   -42"
		Output: -42
		Explanation:
		Step 1: "   -42" (leading whitespace is read and ignored)
				            ^
		Step 2: "   -42" ('-' is read, so the result should be negative)
				             ^
		Step 3: "   -42" ("42" is read in)
				               ^
		The parsed integer is -42.
		Since -42 is in the range [-231, 231 - 1], the final result is -42.
		Example 3:

		Input: s = "4193 with words"
		Output: 4193
		Explanation:
		Step 1: "4193 with words" (no characters read because there is no leading whitespace)
				         ^
		Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
				         ^
		Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
				             ^
		The parsed integer is 4193.
		Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
		Example 4:

		Input: s = "words and 987"
		Output: 0
		Explanation:
		Step 1: "words and 987" (no characters read because there is no leading whitespace)
				         ^
		Step 2: "words and 987" (no characters read because there is neither a '-' nor '+')
				         ^
		Step 3: "words and 987" (reading stops immediately because there is a non-digit 'w')
				         ^
		The parsed integer is 0 because no digits were read.
		Since 0 is in the range [-231, 231 - 1], the final result is 0.
		Example 5:

		Input: s = "-91283472332"
		Output: -2147483648
		Explanation:
		Step 1: "-91283472332" (no characters read because there is no leading whitespace)
				         ^
		Step 2: "-91283472332" ('-' is read, so the result should be negative)
				          ^
		Step 3: "-91283472332" ("91283472332" is read in)
				                     ^
		The parsed integer is -91283472332.
		Since -91283472332 is less than the lower bound of the range [-231, 231 - 1], the final result is clamped to -231 = -2147483648.
				 

		Constraints:

		0 <= s.length <= 200
		s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.*/
		
		
		//String s = "-91283472332";
		//String s = "42";
		//String s = "   -42";
		//String s = "4193 with words";
		//String s = "words and 987";
		//String s = "words and 987-";  //out of bounds 
		//String s = "00004021-"; //4020
		String s = " 000-040233;aksjdsa"; //402
		char[] charArr = new char[s.length()];
		int ascii;
		boolean flag;
		String intString = "";
		
		
		
		charArr = s.toCharArray();
		
		if((int) charArr[0] >= 49 && (int) charArr[0] <= 57) {
			flag = true;
		}else {
			flag = false;
		}
		
		for(int i = 0; i < charArr.length; i++) {
			ascii = (int) charArr[i];
			switch(ascii) {
				case 32:   //white space
					continue;
				case 43: case 45: // '-' or '+'
					if(i != charArr.length - 1 && 
					!flag && 
					charArr[i+1] <= 57 
					&& charArr[i+1] >= 48) { 
						flag = true;
						intString += charArr[i];
						continue;
					}
					continue;
				case 48: // '0'
					if(!flag && 
					charArr[i+1] <= 57 && 
					charArr[i+1] >= 49) {
						flag = true;
						continue;
					}
					if(!flag) {
						continue;
					}else {
						intString += charArr[i];
						continue;
					}		
				case 49: case 50: case 51: case 52:  // 1 - 9
				case 53: case 54: case 55: case 56:
				case 57:
					if(flag) intString += charArr[i];
					continue;
				default:
					break;
			}
		}
		
		System.out.println(intString);
		//intString = "-402";
		
		if(intString.length() == 0) {
			System.out.println(0);
			System.exit(0);
		}
		long a = Long.parseLong(String.valueOf(intString));
		if(a < -2147483648) {
			System.out.println(-2147483648);
			System.exit(0);
		}
		if(a > 2147483647) {
			System.out.println(2147483647);
			System.exit(0);
		}

		System.out.println(a);
	}
	
	//Runtime is n where n is the number of char (assuming I used stringbuilder).
	//Memory is n times

}
