package strings;

import java.util.ArrayList;

public class ValidParentheses {

	public static void main(String[] args) {
		/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

		An input string is valid if:

		Open brackets must be closed by the same type of brackets.
		Open brackets must be closed in the correct order.
		 

		Example 1:

		Input: s = "()"
		Output: true
		Example 2:

		Input: s = "()[]{}"
		Output: true
		Example 3:

		Input: s = "(]"
		Output: false
		Example 4:

		Input: s = "([)]"
		Output: false
		Example 5:

		Input: s = "{[]}"
		Output: true
		 

		Constraints:

		1 <= s.length <= 104
		s consists of parentheses only '()[]{}'.*/
		//String s = "()[]{}";
		
		//Doesn't seem simple to convert string to Character[] so skip it for now
		//Character[] charArray = new Character[] {'(',')', '[',']', '{','}'};
		//Character[] charArray = new Character[] {'(','[',')',']'};
		Character[] charArray = new Character[] {'(',']'};
		ArrayList <Character> bracketList = new  ArrayList <Character>();
		Character currentEndChar;
		int currentIndex = 0;
		
		//convert to array then list
		for(int i = 0; i < charArray.length; i++) bracketList.add(charArray[i]);
		
		while(bracketList.size() != 0) {
			currentEndChar = findEndBracket(bracketList.get(currentIndex));
			if(bracketList.get(currentIndex + 1) == '('  ||  
			   bracketList.get(currentIndex + 1) == '[' ||
			   bracketList.get(currentIndex + 1) == '{') {
				currentIndex++;
				continue;
			}
			if(currentEndChar == bracketList.get(currentIndex + 1)){
				bracketList.remove(currentIndex);
				bracketList.remove(currentIndex);
				currentIndex = 0;
			}else{
				System.out.println("false");
				System.exit(0);
			}
		}
		System.out.println("true");
	}
	public static char findEndBracket(char c) {
		//Would probably be neater to make this into a collection
		//So you can just map start to end
		Character[] brackets = new Character[] {'(', ')', '{', '}', '[' ,']'};
		int bracketIndex = -1;
		for(int i = 0; i < brackets.length; i++) if(brackets[i] == c) bracketIndex = i;
		if(bracketIndex == -1 || bracketIndex % 2 != 0) {
			System.out.println("false");
			System.exit(0);
		}else{
			return brackets[bracketIndex + 1];
		}
		return 'e';

	}
	//Runtime is 0(n) since you need to compare every element memory is also
	//Linear since you need to copy info into a list

}
