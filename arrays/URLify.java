package arrays;

public class URLify {

	public static void main(String[] args) {
		/*URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
		has sufficient space at the end to hold the additional characters, and that you are given the "true"
		length of the string. (Note: If implementing in Java, please use a character array so that you can
		perform this operation in place.)
		EXAMPLE
		Input: "Mr John Smith ", 13
		Output: "Mr%20John%20Smith" *///
		String s = "Mr John Smith ";
		
		char[] a = s.toCharArray();
		String[] convertedArray = new String[a.length];
		
		for(int i = 0; i < s.length(); i++) {
			if(a[i] == ' ') {
				convertedArray[i] = "%20";
			}else{
				convertedArray[i] = Character.toString(a[i]);
			}
		}
		System.out.println(String.join("", convertedArray));
		
	
	}

}
