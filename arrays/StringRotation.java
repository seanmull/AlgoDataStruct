package arraysAndStrings;

import java.util.ArrayList;

public class StringRotation {

	public static void main(String[] args) {
		/*String Rotation:Assumeyou have a method isSubstringwhich checks if oneword is a substring
		of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
		call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat"). *///
		String string = "waterbottle";
		String rotatedStringCheck = "erbottlewat";
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		ArrayList<String> stringRotateList = new ArrayList<String>();
		char firstChar = rotatedStringCheck.charAt(0);
		
		for (int i = 0; i < string.length(); i++){ //find first char indexes
			if(string.charAt(i) == firstChar) {
				indexList.add(i);
			}
		}
		for (int j = 0; j < indexList.size(); j++) {
			stringRotateList.add(string.substring(indexList.get(j),string.length()) //right side
							   + string.substring(0,indexList.get(j))); //left side
		}
		for(String rotatedString : stringRotateList) {
			if(rotatedString.equals(rotatedStringCheck)) {
				System.out.println(rotatedStringCheck + " is a rotated string of " + string);
				System.exit(0);			
			}
		}
		System.out.println(rotatedStringCheck + " is not a rotated string of " + string);			
	}
}
